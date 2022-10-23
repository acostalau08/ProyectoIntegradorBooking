package com.example.DigitalBooking.service;


import com.example.DigitalBooking.DTO.TipoUsuarioDTO;

import java.util.Collection;

public interface ITipoUsuarioService {
    Collection<TipoUsuarioDTO> findAllTipoUsuario();
    TipoUsuarioDTO findTipoUsuarioById(Long id);

    void saveTipoUsuario(TipoUsuarioDTO newTipoUsuarioDTO);
    void deleteTipoUsuario(Long id);
    void updateTipoUsuario(TipoUsuarioDTO newTipoUsuarioDTO);
}
