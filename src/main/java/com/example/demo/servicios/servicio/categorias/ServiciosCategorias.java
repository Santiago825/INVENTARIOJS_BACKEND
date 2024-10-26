package com.example.demo.servicios.servicio.categorias;

import com.example.demo.modelos.CategoriasDTO;
import com.example.demo.util.modelos.ListaDTO;

public interface ServiciosCategorias {
	
	public ListaDTO obtenerCategorias() throws Exception;
	public ListaDTO detallesCategorias() throws Exception;
	public ListaDTO crearCategorias(CategoriasDTO categoriasDTO) throws Exception;
	public ListaDTO modificarCategorias(CategoriasDTO categoriasDTO) throws Exception;
	public ListaDTO cambiarEstadoCategorias(CategoriasDTO categoriasDTO) throws Exception;

}
