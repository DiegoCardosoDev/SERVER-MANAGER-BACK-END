package com.diego.manager.server.services;


import com.diego.manager.server.models.ServerModel;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;


public interface ServerService {

    ServerModel create(ServerModel server);
    ServerModel ping(String ipAndress) throws IOException;
    Collection<ServerModel> list(int limit);
    ServerModel getId(Long id);
    ServerModel update(ServerModel server);
    Boolean delete(Long id);


}
