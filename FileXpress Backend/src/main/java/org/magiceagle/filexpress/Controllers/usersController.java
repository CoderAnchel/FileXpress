package org.magiceagle.filexpress.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.magiceagle.filexpress.DTOS.*;
import org.magiceagle.filexpress.Entities.Friendship;
import org.magiceagle.filexpress.Entities.Request;
import org.magiceagle.filexpress.Entities.User;
import org.magiceagle.filexpress.Services.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class usersController {

    @Autowired
    private Users users;

    //NO PROTECTED ❌⬇️
    @PostMapping("/api/addUser")
    public User addUser(@RequestBody User user) {
        return users.addUser(user);
    }
    //NO PROTECTED ❌⬇️
    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody  UserLoginDTO userLoginDTO) {
        return users.login(userLoginDTO);
    }

    //ALL PROTECTED 🔐⬇️
    @PostMapping("/app/sendFriendRequest")
    public ResponseEntity<String> sendFriendRequest(@RequestBody RequestDTO requestDTO) {
        return users.createRequest(requestDTO);
    }

    @GetMapping("/app/checkRequests")
    public ResponseEntity<List<FriendRequestdto>> getRequest(HttpServletRequest request) {
        return users.checkRequests(request);
    }

    @GetMapping("/app/checkAllRequests")
    public List<Request> getAllRequest() {
        return users.getAllRequests();
    }

    @GetMapping("/app/acceptRequest")
    public ResponseEntity<String> acceptRequest(@RequestParam long id) {
        return users.acceptRequest(id);
    }

    @GetMapping("/app/getUserBasicData")
    public ResponseEntity<UserBasicDataDTO> getUserBasicData(HttpServletRequest request) {
        return users.geBasicUserData(request);
    }

    @GetMapping("/app/Friends")
    public ResponseEntity<ArrayList<UserBasicDataDTO>> getFriends(HttpServletRequest request) {
        return users.getFriends(request);
    }

    @GetMapping("/app/search")
    public ResponseEntity<ArrayList<UserBasicDataDTO>> findsearch(@RequestParam  String value) {
        return users.findSearch(value);
    }

    @PostMapping("/app/user/modified")
    public ResponseEntity<String> sendFriendRequest(HttpServletRequest request, @RequestBody UserDataUpdateDTO data) {
        return users.update(request, data);
    }

}
