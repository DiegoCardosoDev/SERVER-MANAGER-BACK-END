package com.diego.manager.server.repositories;

import com.diego.manager.server.models.ServerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<ServerModel, Long> {

    ServerModel findByIpAndress(String ipAndress);
    ServerModel findByName(String name);
}
