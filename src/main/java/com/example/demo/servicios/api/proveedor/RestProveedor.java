package com.example.demo.servicios.api.proveedor;

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
import com.example.demo.modelos.ProveedorDTO;
import com.example.demo.servicios.servicio.categorias.ServiciosCategorias;
import com.example.demo.servicios.servicio.proveedor.ServiciosProveedor;
import com.example.demo.util.modelos.ListaDTO;
import com.example.demo.util.otros.constantes.config.ConstantesCodigosError;
import com.example.demo.util.otros.constantes.path.ConstantesSeguridadPathRest;

@RestController
public class RestProveedor {
	
	@Autowired
	private ServiciosProveedor serviciosProveedor;

	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_OBTENER_PROVEEDOR, method = RequestMethod.GET, headers = "Accept="
			+ MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListaDTO> obtenerCategorias( ModelMap model,
			Principal principal) throws Exception {
		ListaDTO respuesta = null;
		try {
			 respuesta = serviciosProveedor.obtenerProveedor();

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

	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_CREAR_PROVEEDOR, method = RequestMethod.POST, headers = "Accept="
			+ MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListaDTO> crearCataegoria(@RequestBody ProveedorDTO datos, ModelMap model,
			Principal principal) throws Exception {
		System.out.println(datos);
		System.out.println("best");
		ListaDTO respuesta = null;
		try {
			 respuesta = serviciosProveedor.crearProveedor(datos);

			
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
	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_MODIFICAR_PROVEEDOR, method = RequestMethod.PUT, headers = "Accept="
			+ MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListaDTO> modificarCataegoria(@RequestBody ProveedorDTO datos, ModelMap model,
			Principal principal) throws Exception {
		ListaDTO respuesta = null;
		System.out.println("pasado");
		System.out.println(datos);
		try {
			 respuesta = serviciosProveedor.modificarProveedor(datos);

			
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
	
	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_CAMBIAR_ESTADO_PROVEEDOR, method=RequestMethod.PUT,headers = "Accept="+MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListaDTO> cambiarEstadoCataegoria(@RequestBody ProveedorDTO datos, ModelMap model,
			Principal principal) throws Exception {
		ListaDTO respuesta = null;
		System.out.println("estado");
		System.out.println(datos);
		try {
			 respuesta = serviciosProveedor.cambiarEstadoProveedor(datos);

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
