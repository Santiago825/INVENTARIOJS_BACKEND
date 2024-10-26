package com.example.demo.servicios.servicio.productos;

import com.example.demo.modelos.ProductosDTO;
import com.example.demo.util.modelos.ListaDTO;

public interface ServiciosProductos {
	public ListaDTO consultarProductos() throws Exception;
	public ListaDTO crearProductos(ProductosDTO ProductosDTO) throws Exception;
	public ListaDTO modificarProductos(ProductosDTO ProductosDTO) throws Exception;
	public ListaDTO cambiarEstadoProductos(ProductosDTO ProductosDTO) throws Exception;


}
