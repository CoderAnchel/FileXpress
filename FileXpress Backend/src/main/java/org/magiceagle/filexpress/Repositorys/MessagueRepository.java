package org.magiceagle.filexpress.Repositorys;

import org.magiceagle.filexpress.Entities.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessagueRepository extends JpaRepository<Message, Long> {
    //marker interface
    List<Message> findByChatIDOrderByTimestampDesc(Long chatID, Pageable pageable);
    List<Message> findByChatIDAndIdLessThanOrderByTimestampDesc(Long chatID, Long messageId, Pageable pageable);
    List<Message> findByChatIDOrderByTimestampAsc(Long chatID, Pageable pageable);
}
