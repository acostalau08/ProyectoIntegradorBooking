package com.example.DigitalBooking.service.impl;

import com.example.DigitalBooking.model.CategoriaDTO;
import com.example.DigitalBooking.model.Categorias;
import com.example.DigitalBooking.repository.ICategoriaRepository;
import com.example.DigitalBooking.service.ICategoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoriaServiceimpl implements ICategoriaService {
   @Autowired
   ICategoriaRepository categoriaRepository;
   @Autowired
   ObjectMapper mapper;


    public void saveMethod(CategoriaDTO categoriaDTO){
        if(categoriaDTO != null){
            Categorias categorias = mapper.convertValue(categoriaDTO, Categorias.class);
            categoriaRepository.save(categorias);
        }
    }



    @Override
    public Collection<CategoriaDTO> findAllCategorias() {
        List<Categorias> todaCategoria = categoriaRepository.findAll();
        Set<CategoriaDTO> todaCategoriaDTO = new HashSet<CategoriaDTO>();
        for(Categorias categorias: todaCategoria)
            todaCategoriaDTO.add(mapper.convertValue(categorias,CategoriaDTO.class));

        return todaCategoriaDTO;
    }


    @Override
    public CategoriaDTO findCategoriaById(Long id) {
        Optional<Categorias> categorias = categoriaRepository.findById(id);
        CategoriaDTO categoriaDTO = null;

        if(categorias.isPresent()){
            categoriaDTO = mapper.convertValue(categorias, CategoriaDTO.class);
        }
        return categoriaDTO;
    }

    @Override
    public void saveCategoria(CategoriaDTO newCategoriaDTO) {
    guardarCategoria(newCategoriaDTO);
    }

    @Override
    public void deleteCategoria(Long id) {
    Optional<Categorias> categorias = categoriaRepository.findById(id);
    categoriaRepository.deleteById(id);

    }

    @Override
    public void updateCategoria(CategoriaDTO newCategoriaDTO) {
        guardarCategoria(newCategoriaDTO);
    }
    private void guardarCategoria(CategoriaDTO categoriasDTO){
        Categorias newCategoria = mapper.convertValue(categoriasDTO, Categorias.class);
        categoriaRepository.save(newCategoria);
    }
}
