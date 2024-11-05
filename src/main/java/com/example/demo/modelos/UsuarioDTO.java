package com.example.demo.modelos;

import lombok.Data;

@Data
public class UsuarioDTO {
	
	private Long idUsuario;
	private String usuario;
	private String clave;
	private Long idPersona;

}
