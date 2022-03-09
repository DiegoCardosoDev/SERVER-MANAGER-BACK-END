package com.diego.serversmanager.service;

import com.diego.serversmanager.models.Server;
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
