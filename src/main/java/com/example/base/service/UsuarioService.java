package com.example.base.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.base.models.UsuarioModel;
import com.example.base.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>)usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario (UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Boolean deleteById (Long id)
    {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

}
