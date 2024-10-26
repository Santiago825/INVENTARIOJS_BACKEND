package com.example.demo.servicios.servicio.categorias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.accesoDatos.CategoriasMapper;
import com.example.demo.modelos.CategoriasDTO;
import com.example.demo.util.modelos.ListaDTO;

import com.example.demo.util.otros.constantes.config.ConstantesCodigosError;


@Service
public class ServiciosCategoriasImpl implements ServiciosCategorias {
	
	@Autowired
	CategoriasMapper categoriaMapper;

	@Override
	public ListaDTO obtenerCategorias() throws Exception {
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			List<CategoriasDTO> listado=categoriaMapper.consultarCategorias();
		
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
	public ListaDTO detallesCategorias() throws Exception {
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			List<CategoriasDTO> listado=categoriaMapper.consultarCategorias();
		
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
	public ListaDTO crearCategorias(CategoriasDTO categoriasDTO) throws Exception {
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			 categoriaMapper.crearCategoria(categoriasDTO);
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
	public ListaDTO modificarCategorias(CategoriasDTO categoriasDTO) throws Exception {
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			System.out.println("6644");
			System.out.println(categoriasDTO);
			categoriaMapper.modificarCategoria(categoriasDTO);;
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
	public ListaDTO cambiarEstadoCategorias(CategoriasDTO categoriasDTO) throws Exception {
	
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			System.out.println("escala");
			System.out.println(categoriasDTO);
			 categoriaMapper.cambiarEsatdoCategoria(categoriasDTO);
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
