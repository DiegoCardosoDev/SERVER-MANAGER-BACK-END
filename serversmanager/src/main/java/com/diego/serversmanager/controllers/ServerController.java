package com.diego.serversmanager.controllers;


import com.diego.serversmanager.enumeration.Status;
import com.diego.serversmanager.models.Response;
import com.diego.serversmanager.models.Server;
import com.diego.serversmanager.service.implementation.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.util.MimeTypeUtils.IMAGE_PNG_VALUE;


@Slf4j
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/server")

public class ServerController {

    private final ServiceImpl serverService;


    /*METODDO PARA RETRORNAR TODOS SERVIDORES*/
    @GetMapping("/list")
    public ResponseEntity<Response> getServer(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("servers", serverService.list(30)))
                        .message("servers retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    /*METODDO PARA RETRORNAR TODOS SERVIDORES POR ID*/
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> serverById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("servers", serverService.getId(id)))
                        .message("Server retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    /*METODDO PARA PINGAR O SERVIDOR*/
    @GetMapping("/ping/{ipAndress}")
    public ResponseEntity<Response> pingServer(@PathVariable("ipAndress") String ipAndress) throws IOException {
        Server server = serverService.ping(ipAndress);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("servers", server))
                        .message(server.getStatus() == Status.SERVER_UP ? "Ping Success" : "Ping Failed")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    /*METODDO PARA CRIAR UM SERVIDOR*/
    @PostMapping("/save")
    public ResponseEntity<Response> saveServer(@RequestBody @Valid Server server){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("servers", serverService.create(server)))
                        .message("server created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    /*METODDO PARA DELETAR O SERVIDOR(ID)*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteByServer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", serverService.delete(id)))
                        .message("Server deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    /*METODDO PARA ATRIBUIR A IMAGE DO SERVIDOR*/
    @GetMapping(path = "/image/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getServerImage(@PathVariable("fileName") String fileName) throws IOException{
        return Files.readAllBytes(Paths.get(System.getProperty("/.home/diegocardosodev") + "/Downloads/img/" + fileName));
    }



}
