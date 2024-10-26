package com.example.demo.servicios.api.categorias;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelos.CategoriasDTO;
import com.example.demo.servicios.servicio.categorias.ServiciosCategorias;
import com.example.demo.util.modelos.ListaDTO;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.util.otros.constantes.path.ConstantesSeguridadPathRest;



import com.example.demo.util.otros.constantes.config.ConstantesCodigosError;

@RestController
public class RestCategorias {

	@Autowired
	private ServiciosCategorias servicioCategorias;

	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_OBTENER_CATEGORIAS, method = RequestMethod.GET, headers = "Accept="
			+ MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListaDTO> obtenerCategorias( ModelMap model,
			Principal principal) throws Exception {
		ListaDTO respuesta = null;
		System.out.println("tigre");

		try {
			 respuesta = servicioCategorias.obtenerCategorias();

			System.out.println(respuesta);
			
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

	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_CREAR_CATEGORIAS, method = RequestMethod.POST, headers = "Accept="
			+ MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListaDTO> crearCataegoria(@RequestBody CategoriasDTO datos, ModelMap model,
			Principal principal) throws Exception {
		System.out.println(datos);
		System.out.println("best");
		ListaDTO respuesta = null;
		try {
			 respuesta = servicioCategorias.crearCategorias(datos);

			
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
	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_MODIFICAR_CATEGORIAS, method = RequestMethod.PUT, headers = "Accept="
			+ MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListaDTO> modificarCataegoria(@RequestBody CategoriasDTO datos, ModelMap model,
			Principal principal) throws Exception {
		ListaDTO respuesta = null;
		try {
			 respuesta = servicioCategorias.modificarCategorias(datos);

			
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
	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_DETALLE_CATEGORIAS,params = {"idCategoria"}, method = RequestMethod.GET, headers = "Accept="
			+ MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListaDTO> detalleCataegoria(@RequestParam long idCategoria, ModelMap model,
			Principal principal) throws Exception {
		ListaDTO respuesta = null;
		try {
			 respuesta = servicioCategorias.detallesCategorias();

			System.out.println(respuesta);
			
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
	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_CAMBIAR_ESTADO_CATEGORIAS, method=RequestMethod.PUT,headers = "Accept="+MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListaDTO> cambiarEstadoCataegoria(@RequestBody CategoriasDTO datos, ModelMap model,
			Principal principal) throws Exception {
		System.out.println("llegue");
		System.out.println(datos);
		ListaDTO respuesta = null;
		try {
			 respuesta = servicioCategorias.cambiarEstadoCategorias(datos);

			System.out.println(respuesta);
			
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
