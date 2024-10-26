package com.example.demo.servicios.servicio.proveedor;

import com.example.demo.modelos.CategoriasDTO;
import com.example.demo.modelos.ProveedorDTO;
import com.example.demo.util.modelos.ListaDTO;

public interface ServiciosProveedor {
	
	public ListaDTO obtenerProveedor() throws Exception;
	public ListaDTO crearProveedor(ProveedorDTO proveedorDTO) throws Exception;
	public ListaDTO modificarProveedor(ProveedorDTO proveedorDTO) throws Exception;
	public ListaDTO cambiarEstadoProveedor(ProveedorDTO proveedorDTO) throws Exception;

}
