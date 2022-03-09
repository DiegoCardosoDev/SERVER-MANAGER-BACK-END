package com.diego.serversmanager.controllers;
import com.diego.serversmanager.models.Response;
import com.diego.serversmanager.models.Server;
import com.diego.serversmanager.service.implementation.ServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static com.diego.serversmanager.enumeration.Status.SERVER_UP;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.util.MimeTypeUtils.IMAGE_PNG_VALUE;


@Slf4j
@RestController
@CrossOrigin("*")
@Api(value = "api servers manager")
@RequestMapping("/server")
public class ServerController {

    private final ServiceImpl serverService;

    @Autowired
    public ServerController(ServiceImpl serverService) {
        this.serverService = serverService;
    }

    /*METODDO PARA RETRORNAR TODOS SERVIDORES*/
    @ApiOperation(value = "metodo para listar todos servidores cadastrados.")
    @GetMapping("/list")
    public ResponseEntity<Response> getServer() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("servers", serverService.list(30)))
                        .message("servidores carregados!!!")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    /*METODDO PARA RETRORNAR TODOS SERVIDORES POR ID*/
    @ApiOperation(value = "metodo para obter um servidor por id, insira um id existente." +
            "exemplo: 1")
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
    @ApiOperation(value = "metodo para realizar o ping do servidor, o ip deve existir e está ativo e estar" +
            "exemplo:  192.,168.15.1" +
            "no status UP")
    @GetMapping("/ping/{ipAndress}")
    public ResponseEntity<Response> pingServer(@PathVariable("ipAndress") String ipAndress) throws IOException {
        Server server = serverService.ping(ipAndress);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("server", server))
                        .message(server.getStatus() == SERVER_UP ? "Ping success" : "Ping failed")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    /*METODDO PARA CRIAR UM SERVIDOR*/
    @ApiOperation(value = "metodo para cadastrar um servidor passando os parametros.")
    @PostMapping("/save")
    public ResponseEntity<Response> saveServer(@RequestBody @Valid Server server) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("server", serverService.create(server)))
                        .message("Server created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    /*METODDO PARA DELETAR O SERVIDOR(ID)*/
    @ApiOperation(value = "metodo para deletar um servidor por id, esemplo: id: 1")
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

    /*METODDO PARA ATRIBUIR A IMAGE DO SERVIDOR(ALEATÓRIA)*/
    /*ATENÇÃO AO PATH ONDE ESTÁ AS IMAGENS PARA FUNCIONAR */
    @ApiOperation(value = "esse metodo atribui uma imagem aleatoria ao servidor automaticamente, ao criar o servidor")
    @GetMapping(path = "/image/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getServerImage(@PathVariable("fileName") String fileName) throws IOException{
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/Downloads/img/" + fileName));
    }



}