package com.diego.serversmanager.repo;

import com.diego.serversmanager.models.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends JpaRepository<Server, Long> {

    Server findByIpAndress(String ipAndress);
}
