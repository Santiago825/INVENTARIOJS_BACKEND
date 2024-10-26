package com.example.demo.servicios.servicio.proveedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.accesoDatos.CategoriasMapper;
import com.example.demo.accesoDatos.ProveedorMapper;
import com.example.demo.modelos.CategoriasDTO;
import com.example.demo.modelos.ProveedorDTO;
import com.example.demo.util.modelos.ListaDTO;

import com.example.demo.util.otros.constantes.config.ConstantesCodigosError;


@Service
public class ServiciosProveedorImpl implements ServiciosProveedor {
	
	@Autowired
	ProveedorMapper proveedorMapper ;

	@Override
	public ListaDTO obtenerProveedor() throws Exception {
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			List<ProveedorDTO> listado=proveedorMapper.consultarProveedores();
		
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
	public ListaDTO crearProveedor(ProveedorDTO proveedorDTO) throws Exception {
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			proveedorMapper.crearProveedores(proveedorDTO);
			 respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
			 respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);
			/*if (listado.isEmpty()) {
                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_DATOS_NO_ENCONTRADOS);
                respuesta.setMensajeRespuesta(ConstantesCodigosError.CODIGO_DATOS_NO_ENCONTRADOS);
            } else {
                respuesta.setLista(listado);
                respuesta.setTotalPaginas(listado.size() > 0 ? 1 : 0);
                respuesta.setTotalRegistros(listado.size());
                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
            }
*/

			
		} catch (Exception e) {
			 respuesta = new ListaDTO();
	            respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_NO_CONTROLADO);
	            //respuesta.setMensajeRespuesta(serviciosComun.consultarMensajePorIdioma(respuesta.getCodigoRespuesta()).getMensaje());

		}
		  return respuesta;
		// TODO Auto-generated method stub
	}

	@Override
	public ListaDTO modificarProveedor(ProveedorDTO proveedorDTO) throws Exception {
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			System.out.println("6644");
			System.out.println(proveedorDTO);
			proveedorMapper.modificarProveedores(proveedorDTO);
			System.out.println("saliiiii");
            respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
			 respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);

			/*if (listado.isEmpty()) {
                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_DATOS_NO_ENCONTRADOS);
                respuesta.setMensajeRespuesta(ConstantesCodigosError.CODIGO_DATOS_NO_ENCONTRADOS);
            } else {
                respuesta.setLista(listado);
                respuesta.setTotalPaginas(listado.size() > 0 ? 1 : 0);
                respuesta.setTotalRegistros(listado.size());
                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
            }*/


			
		} catch (Exception e) {
			 respuesta = new ListaDTO();
	            respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_NO_CONTROLADO);
	            //respuesta.setMensajeRespuesta(serviciosComun.consultarMensajePorIdioma(respuesta.getCodigoRespuesta()).getMensaje());

		}
		  return respuesta;
		// TODO Auto-generated method stub
	}
	

	@Override
	public ListaDTO cambiarEstadoProveedor(ProveedorDTO proveedorDTO) throws Exception {
	
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			System.out.println("escala");
			proveedorMapper.cambiarEstadoProveedores(proveedorDTO);
			 respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
			 respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);
			/*if (listado.isEmpty()) {
                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_DATOS_NO_ENCONTRADOS);
                respuesta.setMensajeRespuesta(ConstantesCodigosError.CODIGO_DATOS_NO_ENCONTRADOS);
            } else {
                respuesta.setLista(listado);
                respuesta.setTotalPaginas(listado.size() > 0 ? 1 : 0);
                respuesta.setTotalRegistros(listado.size());
                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
            }
*/

			
		} catch (Exception e) {
			 respuesta = new ListaDTO();
	            respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_NO_CONTROLADO);
	            //respuesta.setMensajeRespuesta(serviciosComun.consultarMensajePorIdioma(respuesta.getCodigoRespuesta()).getMensaje());

		}
		  return respuesta;
		// TODO Auto-generated method stub
	}

}
