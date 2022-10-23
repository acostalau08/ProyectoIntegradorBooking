package com.example.DigitalBooking.DTO;

import com.example.DigitalBooking.model.TipoUsuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class usuarioDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    TipoUsuario tipoUsuario;
    private String userName;
    private String password;
    private String historyLog;
}
