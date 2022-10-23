package com.example.DigitalBooking.service.impl;

import com.example.DigitalBooking.DTO.usuarioDTO;
import com.example.DigitalBooking.model.Usuario;
import com.example.DigitalBooking.repository.IUsuarioRepository;
import com.example.DigitalBooking.service.IUsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioServiceimpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository usuarioRepository;
    @Autowired
    ObjectMapper mapper;

    public void saveMethod(usuarioDTO UsuarioDTO){
        if(UsuarioDTO != null){
            Usuario usuario = mapper.convertValue(UsuarioDTO, Usuario.class);
            usuarioRepository.save(usuario);
        }

    }
    @Override
    public Collection<usuarioDTO> findAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        Set<usuarioDTO> UsuarioDTO = new HashSet<>() ;

        for (Usuario usuario1 : usuarios ){
            UsuarioDTO.add(mapper.convertValue(usuarios, usuarioDTO.class ));
        }
        return UsuarioDTO;
    }

    @Override
    public usuarioDTO findUsuarioById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        usuarioDTO UsuarioDTO = null;

        if(usuario != null){
            UsuarioDTO = mapper.convertValue(usuario, usuarioDTO.class);
        }
        return UsuarioDTO;
    }

    @Override
    public void saveUsuario(usuarioDTO newUsuarioDTO) {
     saveMethod(newUsuarioDTO);
    }

    @Override
    public void deleteUsuario(Long id) {
    Optional<Usuario> usuario = usuarioRepository.findById(id);
    usuarioRepository.deleteById(id);
    }

    @Override
    public void updateUsuario(usuarioDTO newUsuarioDTO) {
        saveMethod(newUsuarioDTO);
    }
}
