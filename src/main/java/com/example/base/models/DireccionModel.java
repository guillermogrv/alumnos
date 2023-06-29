package com.example.base.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class DireccionModel {

    @Id
    @Setter
    @Getter
    Long id;

    @Getter
    @Setter
    String direccion;
    
}
