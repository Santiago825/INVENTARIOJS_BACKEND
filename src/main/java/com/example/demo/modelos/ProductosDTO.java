package com.example.demo.modelos;

import lombok.Data;

@Data
public class ProductosDTO {
	
	private Long idProducto;
	private String nombreProducto;
	private Long idCategoria;
	private String nombreCategoria;
	private Long precioProducto;
	private Long cantidadProducto;
	private String imagenProducto;
	private String estadoProducto;
}
