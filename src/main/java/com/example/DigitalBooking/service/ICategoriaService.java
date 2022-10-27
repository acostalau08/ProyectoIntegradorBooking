package com.example.DigitalBooking.service;

import com.example.DigitalBooking.model.CategoriaDTO;
import java.util.Collection;


import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
   Collection<CategoriaDTO> findAllCategorias();

    CategoriaDTO findCategoriaById(Long id);

    void saveCategoria(CategoriaDTO newCategoriaDTO);
    void deleteCategoria(Long id);
    void updateCategoria(CategoriaDTO newCategoriaDTO);







}
