package com.example.DigitalBooking.controller;

import com.example.DigitalBooking.DTO.usuarioDTO;
import com.example.DigitalBooking.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService usuarioService;

    @GetMapping("/all")
    public ResponseEntity<Collection<usuarioDTO>> getAllUsuarios(){
        return ResponseEntity.ok(usuarioService.findAllUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetUsuarioID(@PathVariable Long id){
        usuarioDTO UsuarioDTO = usuarioService.findUsuarioById(id);
        return ResponseEntity.ok(UsuarioDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUsuario(@RequestBody usuarioDTO usuarioDTO){
        usuarioService.saveUsuario(usuarioDTO);
        return ResponseEntity.ok("Usuario agreado");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUsuario(@RequestBody usuarioDTO usuarioDTO){
        ResponseEntity<String> response;
        if(usuarioService.findUsuarioById(usuarioDTO.getId()) != null){
            usuarioService.updateUsuario(usuarioDTO);
            response = ResponseEntity.ok("Usuario actualizado");
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id){
        ResponseEntity<String> response;
        if(usuarioService.findUsuarioById(id) != null){
            usuarioService.deleteUsuario(id);
            response = ResponseEntity.ok("Usuario con id:" +id + "eliminado");
        }
        else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;

    }
}
