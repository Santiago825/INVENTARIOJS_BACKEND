	package com.example.demo.modelos;

import lombok.Data;

@Data
public class ProveedorDTO {
	
	private Long idProveedor;
	private String nombreProveedor;
	private String telefono;
	private String email;
	private String direccion;
	private Long idDepartamento;
	private Long idMunicipio;	
	private String nombreMunicipio;
	private String nombreDepartamento;
	private String estado;

}
