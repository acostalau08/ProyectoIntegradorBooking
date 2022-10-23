package com.example.DigitalBooking.service.impl;

import com.example.DigitalBooking.DTO.CategoriaDTO;
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
    public Collection<CategoriaDTO> findAllCategoria() {
        List<Categorias> categorias = categoriaRepository.findAll();
        Set<CategoriaDTO> categoriaDTO = new HashSet<>() ;

        for (Categorias categorias1 : categorias){
            categoriaDTO.add(mapper.convertValue(categorias, CategoriaDTO.class));
        }
        return  categoriaDTO;
    }

    @Override
    public CategoriaDTO findCategoriaById(Long id) {
        Categorias categorias = (Categorias) categoriaRepository.findAllById(Collections.singleton(id));
        CategoriaDTO categoriaDTO = null;

        if(categorias != null){
            categoriaDTO = mapper.convertValue(categorias, CategoriaDTO.class);
        }
        return categoriaDTO;

    }

    @Override
    public void saveCategoria(CategoriaDTO newCategoriaDTO) {
    saveMethod(newCategoriaDTO);
    }

    @Override
    public void deleteCategoria(Long id) {
    Optional<Categorias> categorias = categoriaRepository.findById(id);
    categoriaRepository.deleteById(id);

    }

    @Override
    public void updateCategoria(CategoriaDTO newCategoriaDTO) {
        saveMethod(newCategoriaDTO);
    }
}
