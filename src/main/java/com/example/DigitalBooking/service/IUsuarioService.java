package com.example.DigitalBooking.service;


import com.example.DigitalBooking.DTO.usuarioDTO;

import java.util.Collection;

public interface IUsuarioService {
    Collection<usuarioDTO> findAllUsuarios();
    usuarioDTO findUsuarioById(Long id);

    void saveUsuario(usuarioDTO newUsuarioDTO);
    void deleteUsuario(Long id);
    void updateUsuario(usuarioDTO newUsuarioDTO);
}
