package com.example.DigitalBooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@ToString
@Getter
@Setter
@Entity
@Table(name = "Categorias")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}) //para que el hibernate no funcione en seg plano
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String descripcion;
    private String urlImg;

    public Categorias() {
    }

    public Categorias(String titulo, String descripcion, String urlImg) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImg = urlImg;
    }


}
