package com.example.demo.servicios.api.productos;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelos.ProductosDTO;
import com.example.demo.servicios.servicio.categorias.ServiciosCategorias;
import com.example.demo.servicios.servicio.productos.ServiciosProductos;
import com.example.demo.util.modelos.ListaDTO;
import com.example.demo.util.otros.constantes.config.ConstantesCodigosError;
import com.example.demo.util.otros.constantes.path.ConstantesSeguridadPathRest;

@RestController
public class RestProductos {
	@Autowired
	private ServiciosProductos serviciosProductos;

	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_OBTENER_PRODUCTOS, method = RequestMethod.GET, headers = "Accept="
			+ MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaDTO> obtenerProductos() throws Exception {

		ListaDTO respuesta = null;
		try {
			respuesta = serviciosProductos.consultarProductos();

			return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			if (respuesta == null) {
				respuesta = new ListaDTO();
			}
			// TODO: handle exception
			return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.OK);
		}

	}

	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_CREAR_PRODUCTO, method = RequestMethod.POST, headers = "Accept="
			+ MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaDTO> crearProducto(@RequestBody ProductosDTO datos) throws Exception {

		ListaDTO respuesta = null;
		try {
			respuesta = serviciosProductos.crearProductos(datos);
			

			   if (respuesta.getCodigoRespuesta().equals(ConstantesCodigosError.CODIGO_EXITO)) {

	                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
	                respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);

	                return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.OK);

	            } else {
	                if (respuesta.getMensajeRespuesta() == null
	                        || respuesta.getMensajeRespuesta().trim().equals("")) {
	                    respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_NO_ESPECIFICADO);
	                }


	                return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
	            }
		} catch (Exception e) {
			 if (respuesta == null) {
	                respuesta = new ListaDTO();
	            }
	            if (respuesta.getCodigoRespuesta() == null || respuesta.getCodigoRespuesta().equals("")) {
	                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_NO_CONTROLADO);
	                respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_ERROR_NO_CONTROLADO);
	            }


	            return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
	        } finally {
	            Date horaFin = new Date();
	      
	        }

	}
	@RequestMapping(value =ConstantesSeguridadPathRest.PATH_MODIFICAR_PRODUCTO, method = RequestMethod.PUT, headers = "Accept="
			+ MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaDTO> modificarProductos(@RequestBody ProductosDTO datos) throws Exception {

		ListaDTO respuesta = null;
		try {
			respuesta = serviciosProductos.modificarProductos(datos);

			
			   if (respuesta.getCodigoRespuesta().equals(ConstantesCodigosError.CODIGO_EXITO)) {

	                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
	                respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);

	                return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.OK);

	            } else {
	                if (respuesta.getMensajeRespuesta() == null
	                        || respuesta.getMensajeRespuesta().trim().equals("")) {
	                    respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_NO_ESPECIFICADO);
	                }

	              

	                return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
	            }
		} catch (Exception e) {
			 if (respuesta == null) {
	                respuesta = new ListaDTO();
	            }
	            if (respuesta.getCodigoRespuesta() == null || respuesta.getCodigoRespuesta().equals("")) {
	                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_NO_CONTROLADO);
	                respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_ERROR_NO_CONTROLADO);
	            }


	            return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
	        } finally {
	            Date horaFin = new Date();
	      
	        }
	}
	
	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_CAMBIAR_ESTADO_PRODUCTO, method = RequestMethod.PUT, headers = "Accept="
			+ MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaDTO> cambiarEatdoProducto(@RequestBody ProductosDTO datos) throws Exception {

		ListaDTO respuesta = null;
		try {
			respuesta = serviciosProductos.cambiarEstadoProductos(datos);
			

			   if (respuesta.getCodigoRespuesta().equals(ConstantesCodigosError.CODIGO_EXITO)) {

	                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
	                respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);

	                return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.OK);

	            } else {
	                if (respuesta.getMensajeRespuesta() == null
	                        || respuesta.getMensajeRespuesta().trim().equals("")) {
	                    respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_NO_ESPECIFICADO);
	                }

	              

	                return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
	            }
		} catch (Exception e) {
			 if (respuesta == null) {
	                respuesta = new ListaDTO();
	            }
	            if (respuesta.getCodigoRespuesta() == null || respuesta.getCodigoRespuesta().equals("")) {
	                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_NO_CONTROLADO);
	                respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_ERROR_NO_CONTROLADO);
	            }


	            return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
	        } finally {
	            Date horaFin = new Date();
	      
	        }

	}

}
