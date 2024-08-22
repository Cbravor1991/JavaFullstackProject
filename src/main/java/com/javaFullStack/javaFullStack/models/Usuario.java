package com.javaFullStack.javaFullStack.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id", nullable = false)
    private Long id;

    @Getter @Setter
    @Column(name = "nombre", length = 40, nullable = false)
    private String nombre;

    @Getter @Setter
    @Column(name = "apellido", length = 40, nullable = false)
    private String apellido;

    @Getter @Setter
    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Getter @Setter
    @Column(name = "telefono", length = 40, nullable = true)
    private String telefono;

    @Getter @Setter
    @Column(name = "password", length = 255, nullable = false)
    private String password;

}
