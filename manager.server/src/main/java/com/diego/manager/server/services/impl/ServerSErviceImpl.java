package com.diego.manager.server.services.impl;


import com.diego.manager.server.enumeration.Status;
import com.diego.manager.server.models.ServerModel;
import com.diego.manager.server.repositories.ServerRepository;
import com.diego.manager.server.services.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerSErviceImpl implements ServerService {

    private final  ServerRepository serverRepository;

    /*SAVE SERVER*/
    @Override
    public ServerModel create(ServerModel server) {
        log.info("creating new server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return  serverRepository.save(server);

    }
    /*PING SERVER*/
    @Override
    public ServerModel ping(String ipAndress) throws IOException {
        log.info("Ping server IP: {}", ipAndress);
        ServerModel serverModel = serverRepository.findByIpAndress(ipAndress);
        InetAddress address = InetAddress.getByName(ipAndress);
        serverModel.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepository.save(serverModel);
        return serverModel;
    }

    /*GET ALL SERVERS*/
    @Override
    public Collection<ServerModel> list(int limit) {
        log.info("all servers");
        return serverRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    /*GET BY ID SERVER*/
    @Override
    public ServerModel getId(Long id) {
        log.info("server by id {}", id);
        return serverRepository.findById(id).get();
    }

    /*UPDATE SERVER*/
    @Override
    public ServerModel update(ServerModel server) {
        log.info("update server: {}", server.getName());
        return  serverRepository.save(server);

    }

    /*DELETE SERVER*/
    @Override
    public Boolean delete(Long id) {
        log.info("deleting server by id {}", id);
        serverRepository.deleteById(id);
        return Boolean.TRUE;
    }

    private String setServerImageUrl() {
        String[] imageNames = {"server1.png, server2.png, server3.png, server4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image" + imageNames[new Random()
                .nextInt(4)]).toString();
    }
}
