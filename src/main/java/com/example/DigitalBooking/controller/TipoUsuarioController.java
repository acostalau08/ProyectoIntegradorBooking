package com.example.DigitalBooking.controller;

import com.example.DigitalBooking.DTO.TipoUsuarioDTO;
import com.example.DigitalBooking.service.ITipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioController {
    @Autowired
    ITipoUsuarioService tipoUsuarioService;

    @GetMapping("/all")
    public ResponseEntity<Collection<TipoUsuarioDTO>> getAllTipoUsuario(){
        return ResponseEntity.ok(tipoUsuarioService.findAllTipoUsuario());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTipoUsuarioByID(@PathVariable Long id){
        TipoUsuarioDTO tipoUsuarioDTO = tipoUsuarioService.findTipoUsuarioById(id);
        return ResponseEntity.ok(tipoUsuarioDTO);
    }
    @PostMapping("/add")
    public ResponseEntity<?> saveTipoUsuario(@RequestBody TipoUsuarioDTO tipoUsuarioDTO){
        tipoUsuarioService.saveTipoUsuario(tipoUsuarioDTO);
        return ResponseEntity.ok("Tipo de usuario guardado");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTipoUsuario(@RequestBody TipoUsuarioDTO tipoUsuarioDTO){
        ResponseEntity<String> response;
        if (tipoUsuarioService.findTipoUsuarioById(tipoUsuarioDTO.getId()) != null){
            tipoUsuarioService.updateTipoUsuario(tipoUsuarioDTO);
            response = ResponseEntity.ok("Tipo de usuario actualizado");
        }else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTipoUsuario(@PathVariable Long id){
        ResponseEntity<String> response;
        if (tipoUsuarioService.findTipoUsuarioById(id) != null){
            tipoUsuarioService.deleteTipoUsuario(id);
            response = ResponseEntity.ok("Tipo de usuario eliminado");

        }else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;

    }
}
