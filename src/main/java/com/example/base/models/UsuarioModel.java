package com.example.base.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
public class UsuarioModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Getter
    @Setter
    long id;

    @Getter
    @Setter
    String nombre;
}
