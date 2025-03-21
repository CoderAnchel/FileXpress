package org.magiceagle.filexpress.Repositorys;

import org.magiceagle.filexpress.Entities.Chat;
import org.magiceagle.filexpress.Entities.Friendship;
import org.magiceagle.filexpress.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    //marker interface

    // TODO Metodo personalizado para buscar una solicitud entre dos usuarios
    Optional<Chat> findByAAndB(User a, User b);

    // Método personalizado para buscar chats donde el usuario es 'a' o 'b'
    List<Chat> findByAOrB(User user, User user2);
}
