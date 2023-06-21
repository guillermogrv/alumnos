package com.example.base.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.base.models.UsuarioModel;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
    
}