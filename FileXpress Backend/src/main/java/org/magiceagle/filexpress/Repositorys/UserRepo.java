package org.magiceagle.filexpress.Repositorys;

import org.magiceagle.filexpress.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    //marker interface
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);

    List<User> findByNameContainingIgnoreCase(String fullName);
    List<User> findByUsernameContainingIgnoreCase(String username);
    Optional<User> findByUsername(String username);
}
