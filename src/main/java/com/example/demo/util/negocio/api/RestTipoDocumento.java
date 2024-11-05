package com.example.demo.util.negocio.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.modelos.ListaDTO;
import com.example.demo.util.negocio.servicio.departamento.ServiciosDepartamento;
import com.example.demo.util.negocio.servicio.tipoDocumento.ServiciosTipoDocumento;
import com.example.demo.util.otros.constantes.config.ConstantesCodigosError;
import com.example.demo.util.otros.constantes.path.ConstantesSeguridadPathRest;

@RestController
public class RestTipoDocumento {
	@Autowired
	ServiciosTipoDocumento serviciosTipoDocumento;
	
	@RequestMapping(value = ConstantesSeguridadPathRest.PATH_TIPO_DOCUMENTO, method = RequestMethod.GET, headers = "Accept="
			+ MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  ResponseEntity<ListaDTO> consultarTipoDocumento() {
		System.out.println("chupo");
		ListaDTO respuesta = null;
		try {
			 respuesta = serviciosTipoDocumento.cosnultarTipoDocumento();

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
