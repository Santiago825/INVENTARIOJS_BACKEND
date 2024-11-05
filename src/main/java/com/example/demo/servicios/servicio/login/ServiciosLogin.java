package com.example.demo.servicios.servicio.login;

import com.example.demo.modelos.CategoriasDTO;
import com.example.demo.modelos.PersonaDTO;
import com.example.demo.modelos.UsuarioDTO;
import com.example.demo.util.modelos.ListaDTO;

public interface ServiciosLogin {
	
	
	public ListaDTO validarLogin(UsuarioDTO usuarioDTO) throws Exception;
	public ListaDTO registrarUsuario(PersonaDTO PersonaDTO) throws Exception;

}
