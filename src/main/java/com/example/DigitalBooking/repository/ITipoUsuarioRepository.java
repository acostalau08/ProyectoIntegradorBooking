package com.example.DigitalBooking.repository;

import com.example.DigitalBooking.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
}
