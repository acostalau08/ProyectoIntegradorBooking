package com.example.DigitalBooking.repository;

import com.example.DigitalBooking.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICategoriaRepository extends JpaRepository<Categorias, Long> {
}
