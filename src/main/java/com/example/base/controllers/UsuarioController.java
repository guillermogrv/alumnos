package com.example.base.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.base.models.UsuarioModel;
import com.example.base.service.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> getUsuarios(){
        return this.usuarioService.obtenerUsuarios();
    }

    @PostMapping
    public UsuarioModel guardarUsuario (@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @DeleteMapping()
    public Boolean deleteUser (@RequestBody UsuarioModel usuario){
        return this.usuarioService.deleteById(usuario.getId());
    }

}
