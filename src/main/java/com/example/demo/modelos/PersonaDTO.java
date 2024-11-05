package com.example.demo.modelos;

import lombok.Data;

@Data
public class PersonaDTO {
	
	private Long idPersona;
	private String nombre;
	private String apellido;
	private String tipoDocumento;
	private String numeroDocumento;
	private String telefono;
	private String correo;
	private String constrasena;
	private String confirmarContrasena;
	

}
