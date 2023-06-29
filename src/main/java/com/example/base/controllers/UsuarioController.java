package com.example.base.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.example.base.controllers.config.EvaluationConfig;
import com.example.base.models.AuthModel;
import com.example.base.models.UsuarioModel;
import com.example.base.service.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
	private EvaluationConfig config;

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




    public String isTokenActive(String token){
 
        URI uri = null;
        try {
            uri = new URI(config.getAuthurl() );
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        RestTemplate rt = new RestTemplate();

        AuthModel authModel = new AuthModel();
        authModel.setToken(token);

        MultiValueMap<String,String> headerMap=new LinkedMultiValueMap<>() ;
        headerMap.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());

        RequestEntity<AuthModel> requestEntity = new  RequestEntity<AuthModel>(authModel, headerMap, HttpMethod.POST, uri);

        ResponseEntity<String> response = rt.exchange(uri, HttpMethod.POST, requestEntity, String.class); 
        return response.getBody();
    
    }

}
