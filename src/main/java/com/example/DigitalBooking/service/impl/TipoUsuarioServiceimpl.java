package com.example.DigitalBooking.service.impl;

import com.example.DigitalBooking.DTO.TipoUsuarioDTO;
import com.example.DigitalBooking.model.TipoUsuario;

import com.example.DigitalBooking.repository.ITipoUsuarioRepository;
import com.example.DigitalBooking.service.ITipoUsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TipoUsuarioServiceimpl implements ITipoUsuarioService {
    @Autowired
    ITipoUsuarioRepository tipoUsuarioRepository;
    @Autowired
    ObjectMapper mapper;

    public void saveMethod(TipoUsuarioDTO tipoUsuarioDTO){
        if(tipoUsuarioDTO != null){
            TipoUsuario tipoUsuario = mapper.convertValue(tipoUsuarioDTO, TipoUsuario.class);
            tipoUsuarioRepository.save(tipoUsuario);
        }
    }
    @Override
    public Collection<TipoUsuarioDTO> findAllTipoUsuario() {
        List<TipoUsuario> tipoUsuario = tipoUsuarioRepository.findAll();
        Set<TipoUsuarioDTO> tipoUsuarioDTO = new HashSet<>() ;

        for (TipoUsuario tipoUsuario1 : tipoUsuario){
            tipoUsuarioDTO.add(mapper.convertValue(tipoUsuario, TipoUsuarioDTO.class));
        }
        return tipoUsuarioDTO;
    }

    @Override
    public TipoUsuarioDTO findTipoUsuarioById(Long id) {
        Optional<TipoUsuario> tipoUsuario = tipoUsuarioRepository.findById(id);
        TipoUsuarioDTO tipoUsuarioDTO = null;

        if(tipoUsuario != null){
            tipoUsuarioDTO = mapper.convertValue(tipoUsuario, TipoUsuarioDTO.class);
        }
        return tipoUsuarioDTO;
    }

    @Override
    public void saveTipoUsuario(TipoUsuarioDTO newTipoUsuarioDTO) {
    saveMethod(newTipoUsuarioDTO);
    }

    @Override
    public void deleteTipoUsuario(Long id) {
        Optional<TipoUsuario> TipoUsuario = tipoUsuarioRepository.findById(id);
        tipoUsuarioRepository.deleteById(id);

    }

    @Override
    public void updateTipoUsuario(TipoUsuarioDTO newTipoUsuarioDTO) {
        saveMethod(newTipoUsuarioDTO);
    }
}
