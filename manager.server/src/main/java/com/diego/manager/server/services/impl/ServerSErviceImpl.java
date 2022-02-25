package com.diego.manager.server.services.impl;


import com.diego.manager.server.enumeration.Status;
import com.diego.manager.server.models.ServerModel;
import com.diego.manager.server.repositories.ServerRepository;
import com.diego.manager.server.services.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerSErviceImpl implements ServerService {

    private final  ServerRepository serverRepository;

    @Override
    public ServerModel create(ServerModel server) {
        log.info("creating new server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        serverRepository.save(server);
        return null;
    }



    @Override
    public ServerModel ping(String ipAndress) throws IOException {
        log.info("Ping server IP: {}", ipAndress);
        ServerModel serverModel = serverRepository.findByIpAndress(ipAndress);
        InetAddress address = InetAddress.getByName(ipAndress);
        serverModel.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepository.save(serverModel);
        return serverModel;
    }

    @Override
    public Collection<ServerModel> list(int limit) {
        log.info("all servers");
        return serverRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public ServerModel getId(Long id) {
        log.info("server by id {}", id);
        return serverRepository.findById(id).get();
    }

    @Override
    public ServerModel update(ServerModel server) {
        log.info("update server: {}", server.getName());
        return  serverRepository.save(server);

    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private String setServerImageUrl() {
        return null;
    }
}
