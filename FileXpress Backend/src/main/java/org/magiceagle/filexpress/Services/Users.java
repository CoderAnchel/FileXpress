package org.magiceagle.filexpress.Services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.magiceagle.filexpress.DTOS.*;
import org.magiceagle.filexpress.Entities.Friendship;
import org.magiceagle.filexpress.Entities.Request;
import org.magiceagle.filexpress.Entities.User;
import org.magiceagle.filexpress.Repositorys.FriendshipRepo;
import org.magiceagle.filexpress.Repositorys.RequestRepo;
import org.magiceagle.filexpress.Repositorys.UserRepo;
import org.magiceagle.filexpress.Exceptions.UserNotFoundException;
import org.magiceagle.filexpress.Utils.ByCriptUtils;
import org.magiceagle.filexpress.Utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class Users {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RequestRepo requestRepo;
    @Autowired
    private FriendshipRepo friendshipRepo;
    @Autowired
    private ObjectMapper objectMapper;

    public User addUser(User user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use");
        }
        if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already in use");
        }
        Date now = new Date();
        user.setCreated(now);
        user.setPassword(BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));
        return  userRepo.save(user);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public ResponseEntity<String> login(UserLoginDTO userLoginDTO) {
        if(userLoginDTO.getEmail() == null || userLoginDTO.getPassword() == null) {
            return null;
        }

        User originalUser = userRepo.findByEmail(userLoginDTO.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User with email " + userLoginDTO.getEmail() + " not found"));

        if (ByCriptUtils.resolve(userLoginDTO.getPassword(), originalUser.getPassword()).verified) {
            Map<String, Object> userMap = objectMapper.convertValue(originalUser, Map.class);

            String jwt = JwtUtils.createJWT(1000 * 60 * 10, userMap);

            //  Claims claims = JwtUtils.decodeJWT(jwt);

            return ResponseEntity.ok(jwt);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    public ResponseEntity<String> createRequest(RequestDTO requestPetition) {
        User from = userRepo.findById(requestPetition.getFrom_id())
                .orElseThrow(() ->  new UserNotFoundException("User with ID " + requestPetition.getFrom_id() + " not found"));
        User to = userRepo.findById(requestPetition.getTo_id())
                .orElseThrow(() ->  new UserNotFoundException("User with ID " + requestPetition.getFrom_id() + " not found"));

        if (Objects.equals(from.getId(), to.getId())) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR: You can not send a friend request to the same request origin :/ ❌");
        }

        Optional<Friendship>  existingFriendship = friendshipRepo.findByAAndB(from, to);
        Optional<Friendship>  existingFriendship2 = friendshipRepo.findByAAndB(to, from);
        if (existingFriendship.isPresent() || existingFriendship2.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR: Users are all ready friends. :/ ❌");
        }

        Optional<Request> existingRequest = requestRepo.findByFromAndTo(from, to);
        Optional<Request> existingRequest2 = requestRepo.findByFromAndTo(to, from);
        if (existingRequest.isPresent() || existingRequest2.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR: A friend request already exists between these users. :/ ❌");
        }

        Date now = new Date();
        Request request = new Request();
        request.setSend_date(now);
        request.setFrom(from);
        request.setTo(to);

        requestRepo.save(request);

        return ResponseEntity.ok("Friend Request Sended ✅");
    }

    public ResponseEntity<List<FriendRequestdto>> checkRequests(HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute("id");
        Long idLong = id.longValue();

        User user = userRepo.findById(idLong)
                .orElseThrow(() ->  new UserNotFoundException("User with ID " + id + " not found"));

        List<Request> requests = requestRepo.findByTo(user);
        ArrayList<FriendRequestdto> friendList = getRequestBasicDTOS(requests);

        if (requests.isEmpty()) {
            // No existe ninguna solicitud de amistad para el usuario 'to'
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else return ResponseEntity.ok(friendList);
    }

    private static ArrayList<FriendRequestdto> getRequestBasicDTOS(List<Request> requests) {
        ArrayList<FriendRequestdto> friendList = new ArrayList<>();

        for(Request request : requests) {
            FriendRequestdto basicData = new FriendRequestdto();
            basicData.setName(request.getFrom().getName());
            basicData.setEmail(request.getFrom().getEmail());
            basicData.setBio(request.getFrom().getBio());
            basicData.setPhone(request.getFrom().getPhone());
            basicData.setId(request.getFrom().getId());
            basicData.setRequestId(request.getId());
            basicData.setUsername(request.getFrom().getUsername());
            friendList.add(basicData);
        }
        return friendList;
    }

    public List<Request> getAllRequests() {
        return requestRepo.findAll();
    }

    public ResponseEntity<String> acceptRequest(Long id) {
        Optional<Request> request = requestRepo.findById(id);

        if (request.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request not found!! ❌");
        }

        Request requestValidated = request.get();

        Date now = new Date();
        Friendship friendship = new Friendship();
        friendship.setA(requestValidated.getFrom());
        friendship.setB(requestValidated.getTo());
        friendship.setCreated(now);
        friendshipRepo.save(friendship);

        requestRepo.delete(requestValidated);

        return ResponseEntity.ok("Request with id "+requestValidated.getId()+" From: "+requestValidated.getFrom().getName()+" To: "+requestValidated.getTo().getName()+" ACCEPTED! ✅");
    }

    public ResponseEntity<UserBasicDataDTO> geBasicUserData(HttpServletRequest request) {
        UserBasicDataDTO userBasicDataDTO = new UserBasicDataDTO();

        Integer id = (Integer) request.getAttribute("id");
        Long idLong = id.longValue();

        User user = userRepo.findById(idLong)
                .orElseThrow(() ->  new UserNotFoundException("User with ID " + 2 + " not found"));

        userBasicDataDTO.setId(user.getId());
        userBasicDataDTO.setName(user.getName());
        userBasicDataDTO.setEmail(user.getEmail());
        userBasicDataDTO.setBio(user.getBio());
        userBasicDataDTO.setPhone(user.getPhone());
        userBasicDataDTO.setUsername(user.getUsername());

        return ResponseEntity.ok(userBasicDataDTO);
    }

    public ResponseEntity<ArrayList<UserBasicDataDTO>> getFriends(HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute("id");
        Long idLong = id.longValue();
        ArrayList<UserBasicDataDTO> friendList = new ArrayList<>();

        Optional<User> user = userRepo.findById(idLong);

        User userValidated = user.get();

        List<Friendship> friendships = friendshipRepo.findByAOrB(userValidated);

        for (Friendship friendship : friendships) {
            if (Objects.equals(friendship.getA().getId(), idLong)) {
                User friend = friendship.getB();
                UserBasicDataDTO basicData = new UserBasicDataDTO();
                basicData.setName(friend.getName());
                basicData.setEmail(friend.getEmail());
                basicData.setBio(friend.getBio());
                basicData.setPhone(friend.getPhone());
                basicData.setId(friend.getId());
                basicData.setUsername(friend.getUsername());
                friendList.add(basicData);
            } else {
                User friend = friendship.getA();
                UserBasicDataDTO basicData = new UserBasicDataDTO();
                basicData.setName(friend.getName());
                basicData.setEmail(friend.getEmail());
                basicData.setBio(friend.getBio());
                basicData.setPhone(friend.getPhone());
                basicData.setId(friend.getId());
                basicData.setUsername(friend.getUsername());
                friendList.add(basicData);
            }
        }

        return ResponseEntity.ok(friendList);
    }

    public ResponseEntity<ArrayList<UserBasicDataDTO>> findSearch(String value) {
        List<User> users = userRepo.findByNameContainingIgnoreCase(value);
        List<User> usersFromUsername = userRepo.findByUsernameContainingIgnoreCase(value);
        ArrayList<User> resolvedUsers = new ArrayList<>(users);
        ArrayList<UserBasicDataDTO> resolvedUsersDTO = new ArrayList<>();

        for (User user : usersFromUsername) {
            if (resolvedUsers.contains(user)) {
            } else resolvedUsers.add(user);
        }
        
        for(User user : resolvedUsers) {
            UserBasicDataDTO userBasic = new UserBasicDataDTO();
            userBasic.setUsername(user.getUsername());
            userBasic.setId(user.getId());
            userBasic.setName(user.getName());
            userBasic.setBio(user.getBio());
            userBasic.setPhone(user.getPhone());
            resolvedUsersDTO.add(userBasic);
        }

        return ResponseEntity.ok(resolvedUsersDTO);
    }

    public ResponseEntity<String> update(HttpServletRequest request, UserDataUpdateDTO data) {
        Integer id = (Integer) request.getAttribute("id");
        Long idLong = id.longValue();
        Optional<User> user = userRepo.findById(idLong);
        User userValidated = user.get();
        String modifiedValue = "";

        switch (data.getType()) {
            case("name"):
                modifiedValue = data.getValue();
                userValidated.setName(data.getValue());
                break;
            case("username"):
                modifiedValue = data.getValue();
                userValidated.setUsername(data.getValue());
                break;
            case("email"):
                modifiedValue = data.getValue();
                userValidated.setEmail(data.getValue());
                break;
            case("phone"):
                modifiedValue = data.getValue();
                userValidated.setPhone(data.getValue());
                break;
            case("bio"):
                modifiedValue = data.getValue();
                userValidated.setBio(data.getValue());
                break;
        }

        userRepo.save(userValidated);

        return ResponseEntity.ok("Changes maded to user "+userValidated.getUsername()+" TYPE: "+data.getType());
    }
}
