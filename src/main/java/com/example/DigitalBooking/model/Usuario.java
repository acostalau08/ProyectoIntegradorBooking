package com.example.DigitalBooking.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table

public class Usuario {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String apellido;
    private String correo;
    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id")
    TipoUsuario tipoUsuario;
    private String userName;
    private String password;
    private String historyLog;


}
