package com.example.DigitalBooking.service;

import com.example.DigitalBooking.DTO.CategoriaDTO;

import java.util.Collection;

public interface ICategoriaService {
    Collection<CategoriaDTO> findAllCategoria();
    CategoriaDTO findCategoriaById(Long id);

    void saveCategoria(CategoriaDTO newCategoriaDTO);
    void deleteCategoria(Long id);
    void updateCategoria(CategoriaDTO newCategoriaDTO);

}
