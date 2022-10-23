package com.example.DigitalBooking.controller;

import com.example.DigitalBooking.DTO.CategoriaDTO;
import com.example.DigitalBooking.service.ICategoriaService;
import com.example.DigitalBooking.service.impl.CategoriaServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    ICategoriaService categoriaService;

    @GetMapping("/all")
    public ResponseEntity<Collection<CategoriaDTO>> getAllCategoria(){
        return ResponseEntity.ok(categoriaService.findAllCategoria());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoria(@PathVariable Long id){
        CategoriaDTO categoriaDTO = categoriaService.findCategoriaById(id);
        return ResponseEntity.ok(categoriaDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveCategoria(@RequestBody CategoriaDTO categoriaDTO){
        categoriaService.saveCategoria(categoriaDTO);
        return ResponseEntity.ok("Categoría guardada");

    }
    @PutMapping ("/update")
    public ResponseEntity<?> updateCategoria(@RequestBody CategoriaDTO categoriaDTO){
        ResponseEntity<String> response;
        if(categoriaService.findCategoriaById(categoriaDTO.getId()) != null){
            categoriaService.updateCategoria(categoriaDTO);
            response = ResponseEntity.ok("Categoria actualizada");
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable Long id){
        ResponseEntity<String> response;
        if(categoriaService.findCategoriaById(id) != null){
            categoriaService.deleteCategoria(id);
            response = ResponseEntity.ok("Categoría con id" + id + "ha sido eliminada");
        }
        else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

}
