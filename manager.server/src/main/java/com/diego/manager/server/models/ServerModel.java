package com.diego.manager.server.models;

/*CLASSE DE DOMINIO SERVER*/

import com.diego.manager.server.enumeration.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SERVER_DB")
public class ServerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "ip andress cannot be empty  or null")
    private String ipAndress;

    private String name;
    private String memory;
    private String type;
    private String imageUrl;
    private Status status;


}
