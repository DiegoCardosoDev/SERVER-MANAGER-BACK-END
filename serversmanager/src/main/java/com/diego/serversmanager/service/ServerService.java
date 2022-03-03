package com.diego.serversmanager.service;

import com.diego.serversmanager.models.Server;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

import java.util.Collection;



public interface ServerService {

    Server create(Server server);
    Server ping(String ipAndress) throws IOException;
    Collection<Server> list(int limit);
    Server getId(Long id);
    Server update(Server server);
    Boolean delete(Long id);


}
