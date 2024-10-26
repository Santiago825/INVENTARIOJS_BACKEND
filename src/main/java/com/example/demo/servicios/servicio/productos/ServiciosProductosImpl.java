package com.example.demo.servicios.servicio.productos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.accesoDatos.ProductoMapper;
//import com.example.demo.accesoDatos.ProductosMapper;
//import com.example.demo.accesoDatos.ProductosMapper;
import com.example.demo.modelos.ProductosDTO;
import com.example.demo.modelos.ProveedorDTO;
import com.example.demo.servicios.servicio.categorias.ServiciosCategorias;
import com.example.demo.util.modelos.ListaDTO;
import com.example.demo.util.otros.constantes.config.ConstantesCodigosError;


@Service
public class ServiciosProductosImpl implements ServiciosProductos {
	
	@Autowired
	ProductoMapper productosMapper;

	@Override
	public ListaDTO consultarProductos() throws Exception {
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			List<ProductosDTO> listado=productosMapper.consultarProductos();
		
			if (listado.isEmpty()) {
                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_DATOS_NO_ENCONTRADOS);
                respuesta.setMensajeRespuesta(ConstantesCodigosError.CODIGO_DATOS_NO_ENCONTRADOS);
            } else {
                respuesta.setLista(listado);
                respuesta.setTotalPaginas(listado.size() > 0 ? 1 : 0);
                respuesta.setTotalRegistros(listado.size());
                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
            }


			
		} catch (Exception e) {
			 respuesta = new ListaDTO();
	            respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_NO_CONTROLADO);
	            //respuesta.setMensajeRespuesta(serviciosComun.consultarMensajePorIdioma(respuesta.getCodigoRespuesta()).getMensaje());

		}
		  return respuesta;
		// TODO Auto-generated method stub
	
	}

	@Override
	public ListaDTO crearProductos(ProductosDTO ProductosDTO) throws Exception {
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			System.out.println("primeras");

			productosMapper.crearProductos(ProductosDTO	);
			System.out.println("ultimaas");
			respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
			 respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);

			


			
		} catch (Exception e) {
			 respuesta = new ListaDTO();
	            respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_NO_CONTROLADO);
	            //respuesta.setMensajeRespuesta(serviciosComun.consultarMensajePorIdioma(respuesta.getCodigoRespuesta()).getMensaje());

		}
		  return respuesta;
		// TODO Auto-generated method stub
	}

	@Override
	public ListaDTO modificarProductos(ProductosDTO ProductosDTO) throws Exception {
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			productosMapper.modificarProductos(ProductosDTO);
		
			respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
			 respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);


			
		} catch (Exception e) {
			 respuesta = new ListaDTO();
	            respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_NO_CONTROLADO);
	            //respuesta.setMensajeRespuesta(serviciosComun.consultarMensajePorIdioma(respuesta.getCodigoRespuesta()).getMensaje());

		}
		  return respuesta;
		// TODO Auto-generated method stub
	}

	@Override
	public ListaDTO cambiarEstadoProductos(ProductosDTO ProductosDTO) throws Exception {
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			productosMapper.cambiarEstadoProductos(ProductosDTO);
			 respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
			 respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);
		
			

			
		} catch (Exception e) {
			 respuesta = new ListaDTO();
	            respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_NO_CONTROLADO);
	            //respuesta.setMensajeRespuesta(serviciosComun.consultarMensajePorIdioma(respuesta.getCodigoRespuesta()).getMensaje());

		}
		  return respuesta;
		// TODO Auto-generated method stub
	}

	

}
