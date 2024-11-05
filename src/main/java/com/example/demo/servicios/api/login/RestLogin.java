package com.example.demo.servicios.api.login;

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
import com.example.demo.modelos.PersonaDTO;
import com.example.demo.modelos.UsuarioDTO;
import com.example.demo.servicios.servicio.categorias.ServiciosCategorias;
import com.example.demo.servicios.servicio.login.ServiciosLogin;
import com.example.demo.util.modelos.ListaDTO;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.util.otros.constantes.path.ConstantesSeguridadPathRest;



import com.example.demo.util.otros.constantes.config.ConstantesCodigosError;

@RestController
public class RestLogin {

	@Autowired
	private ServiciosLogin servicioLogin;


	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_VALIDAR_LOGIN, method = RequestMethod.POST, headers = "Accept="
			+ MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListaDTO> validarLogin(@RequestBody UsuarioDTO datos, ModelMap model,
			Principal principal) throws Exception {
		System.out.println(datos);
		System.out.println("best");
		ListaDTO respuesta = null;
		try {
			 respuesta = servicioLogin.validarLogin(datos);

			
			   if (respuesta.getCodigoRespuesta().equals(ConstantesCodigosError.CODIGO_EXITO)||respuesta.getCodigoRespuesta().equals(ConstantesCodigosError.CODIGO_ERROR_USU_PWD_NOVAL)) {
				   if(respuesta.getCodigoRespuesta().equals(ConstantesCodigosError.CODIGO_EXITO)) {
					   respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
		                respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);  
				   }
				   if(respuesta.getCodigoRespuesta().equals(ConstantesCodigosError.CODIGO_ERROR_USU_PWD_NOVAL)) {
					   respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_USU_PWD_NOVAL);
						respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_ERROR_USU_PWD_NOVAL);
				   }
	               

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
	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_REGISTRAR_USUARIO, method = RequestMethod.POST, headers = "Accept="
			+ MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListaDTO> registrarUsuario(@RequestBody PersonaDTO datos, ModelMap model,
			Principal principal) throws Exception {
		ListaDTO respuesta = null;
		try {
			 respuesta = servicioLogin.registrarUsuario(datos);

			
			   if (respuesta.getCodigoRespuesta().equals(ConstantesCodigosError.CODIGO_EXITO)||respuesta.getCodigoRespuesta().equals(ConstantesCodigosError.CODIGO_ERROR_EMAIL_EXISTE)||respuesta.getCodigoRespuesta().equals(ConstantesCodigosError.CODIGO_ERROR_TIPO_DOCUMENTO)) {
				   	if(respuesta.getCodigoRespuesta().equals(ConstantesCodigosError.CODIGO_ERROR_EMAIL_EXISTE)) {
				   		respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_EMAIL_EXISTE);
						respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_ERROR_EMAIL_EXISTE);
				   	}
				   	if(respuesta.getCodigoRespuesta().equals(ConstantesCodigosError.CODIGO_EXITO)) {
				   	 respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
		                respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);
				   	}
					if(respuesta.getCodigoRespuesta().equals(ConstantesCodigosError.CODIGO_ERROR_TIPO_DOCUMENTO)) {
						respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_TIPO_DOCUMENTO);
						respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_ERROR_TIPO_DOCUMENTO);
					   	}
	               

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
