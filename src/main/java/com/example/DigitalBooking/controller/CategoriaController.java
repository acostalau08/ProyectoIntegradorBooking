package com.example.DigitalBooking.controller;

import com.example.DigitalBooking.model.CategoriaDTO;
import com.example.DigitalBooking.model.Categorias;
import com.example.DigitalBooking.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    ICategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<Collection<CategoriaDTO>> getAllCategoria(){
        return ResponseEntity.ok(categoriaService.findAllCategorias());
    }

   // @GetMapping("/{id}")
   // public ResponseEntity<?> getCategoria(@PathVariable Long id){
      // CategoriaDTO categoriaDTO = categoriaService.findCategoriaById(id);
       // return ResponseEntity.ok(categoriaDTO);
  // }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoria(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.findCategoriaById(id));
    }


    @PostMapping("/add")
    public ResponseEntity<?> saveCategoria(@RequestBody CategoriaDTO categoriaDTO){
        categoriaService.saveCategoria(categoriaDTO);
        return ResponseEntity.ok("Categoría Guardada");

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
