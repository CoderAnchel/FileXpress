package org.magiceagle.filexpress.Repositorys;

import org.magiceagle.filexpress.Entities.Request;
import org.magiceagle.filexpress.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RequestRepo extends JpaRepository<Request, Long> {
    // TODO Metodo personalizado para buscar una solicitud entre dos usuarios
    Optional<Request> findByFromAndTo(User from, User to);

    List<Request> findByTo(User to);
}
