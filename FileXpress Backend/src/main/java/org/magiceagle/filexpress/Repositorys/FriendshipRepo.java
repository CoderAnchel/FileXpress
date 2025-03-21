package org.magiceagle.filexpress.Repositorys;

import org.magiceagle.filexpress.Entities.Friendship;
import org.magiceagle.filexpress.Entities.Request;
import org.magiceagle.filexpress.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FriendshipRepo extends JpaRepository<Friendship, Long> {
    //marker interface
    // TODO Metodo personalizado para buscar una solicitud entre dos usuarios
    Optional<Friendship> findByAAndB(User a, User b);

    List<Friendship> findByA(User a);
    List<Friendship> findByB(User b);


    // Obtener las amistades X independiente de si es a o b

    @Query("SELECT f FROM Friendship f WHERE f.a = :value OR f.b = :value")
    List<Friendship> findByAOrB(@Param("value") User value);
}
