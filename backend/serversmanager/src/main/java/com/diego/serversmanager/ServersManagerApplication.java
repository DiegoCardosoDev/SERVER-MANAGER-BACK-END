package com.diego.serversmanager;

import com.diego.serversmanager.enumeration.Status;
import com.diego.serversmanager.models.Server;
import com.diego.serversmanager.repo.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServersManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServersManagerApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(ServerRepository serverRepository) {
//		return args -> {
//
//
//			serverRepository.save(new Server(null, "192.168.15.7", "Red Hat Enterprise Linux", "16 GB", "Personal PC",
//					"http://localhost:8080/server/image/server7.png", Status.SERVER_UP));
//
//			serverRepository.save(new Server(null, "192.168.1.21", "windows server", "32Gb", "Personal",
//					"http://localhost:8080/server/image/server2.png", Status.SERVER_UP));
//
//			serverRepository.save(new Server(null, "192.168.15.3", " Linux mint", "1T", "Workspace",
//					"http://localhost:8080/server/image/server3.png", Status.SERVER_UP));
//
//			serverRepository.save(new Server(null, "192.168.1.58", "Fedora Linux", "16 GB", "Dell Tower",
//					"http://localhost:8080/server/image/server5.png", Status.SERVER_UP));
//
//			serverRepository.save(new Server(null, "192.168.1.14", "MS 2008", "32 GB", "Web Server",
//					"http://localhost:8080/server/image/server6.png", Status.SERVER_DOWN));
//
//			serverRepository.save(new Server(null, "192.168.15.1", "Ubuntu Linux", "16Gb", "Personal",
//					"http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
//
//
//		};
//	}
}


