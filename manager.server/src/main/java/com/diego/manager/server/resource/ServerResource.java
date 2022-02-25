package com.diego.manager.server.resource;
/*CLASSE CONTROLADORA*/

import com.diego.manager.server.models.Response;
import com.diego.manager.server.models.ServerModel;
import com.diego.manager.server.services.impl.ServerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import static com.diego.manager.server.enumeration.Status.SERVER_UP;
import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/server-manager")
@RequiredArgsConstructor
public class ServerResource {

    private ServerServiceImpl serverService;

    @GetMapping("/list")
    public ResponseEntity<Response> getServer(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("servers", serverService.list(30)))
                        .message("servers retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/ping/{ipAndress}")
    public ResponseEntity<Response> pingServer(@PathVariable("ipAndress") String ipAndress) throws IOException {
        ServerModel server = serverService.ping(ipAndress);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("servers", server))
                        .message(server.getStatus() == SERVER_UP ? "Ping Success" : "Ping Failed")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveServer(@RequestBody @Valid ServerModel server){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("servers", serverService.create(server)))
                        .message("server created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

}
