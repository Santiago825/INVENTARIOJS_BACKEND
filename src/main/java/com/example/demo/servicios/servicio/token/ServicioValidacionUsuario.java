package com.example.demo.servicios.servicio.token;

import com.example.demo.modelos.DatosAutenticacionDTO;
import com.example.demo.modelos.DatosBasicosUsuarioDTO;
import com.example.demo.modelos.UsuarioDTO;


public interface ServicioValidacionUsuario {

    public DatosAutenticacionDTO validarUsuario(DatosAutenticacionDTO usuario) throws Exception;

  

}