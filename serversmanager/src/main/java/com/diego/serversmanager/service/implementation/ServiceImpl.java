package com.diego.serversmanager.service.implementation;
/*ESSA CLASSE IMPLEMENTA OS METÓDOS DA INTERFACE SERVICE*/

import com.diego.serversmanager.models.Server;
import com.diego.serversmanager.repo.ServerRepository;
import com.diego.serversmanager.service.ServerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;
import static com.diego.serversmanager.enumeration.Status.SERVER_DOWN;
import static com.diego.serversmanager.enumeration.Status.SERVER_UP;

@Service
@Transactional
@Slf4j
public class ServiceImpl implements ServerService {

    private final ServerRepository serverRepository;

    @Autowired
    public ServiceImpl(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }


    /*CREATE SERVER*/
    @Override
    public Server create(Server server) {
        log.info("creating new server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return  serverRepository.save(server);

    }

    /*UPDATE SERVER*/
    @Override
    public Server update(Server server) {
        log.info("update server: {}", server.getName());
        return  serverRepository.save(server);

    }

    /*LISTAR TODOS*/
    @Override
    public Collection<Server> list(int limit) {
        log.info("all servers");
        return serverRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    /*DELETE SERVER*/
    @Override
    public Boolean delete(Long id) {
        log.info("deleting server by id {}", id);
        serverRepository.deleteById(id);
        return Boolean.TRUE;
    }

    /*PING SERVER*/
    @Override
    public Server ping(String ipAndress) throws IOException {
        log.info("Pinging server IP: {}", ipAndress);
        Server server = serverRepository.findByIpAndress(ipAndress);
        InetAddress address = InetAddress.getByName(ipAndress);
        server.setStatus(address.isReachable(10000) ? SERVER_UP : SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }


    /* ESSE METODO ATRIBUI UM AIMAGEM DE FORMA ALEATORIA AO SERVIDOR CRIADO*/
    private String setServerImageUrl() {
        String[] imageNames = {"server1.png", "server2.png", "server3.png",
                "server4.png", "server5.png", "server6.png", "server7.png"};
        log.info("setting image by server");
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + imageNames[new Random()
                .nextInt(7)]).toUriString();
    }


    /*GET BY ID SERVER*/
    @Override
    public Server getId(Long id) {
        log.info("server by id {}", id);
        return serverRepository.findById(id).get();
    }


}
