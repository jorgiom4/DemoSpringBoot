package com.instancia2.demoSpringBoot.dto;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String user;

    @Column
    private String pass;


}
