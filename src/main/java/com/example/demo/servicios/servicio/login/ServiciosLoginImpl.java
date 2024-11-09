package com.example.demo.servicios.servicio.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.accesoDatos.CategoriasMapper;
import com.example.demo.accesoDatos.LoginMapper;
import com.example.demo.modelos.CategoriasDTO;
import com.example.demo.modelos.PersonaDTO;
import com.example.demo.modelos.UsuarioDTO;
import com.example.demo.util.modelos.ListaDTO;

import com.example.demo.util.otros.constantes.config.ConstantesCodigosError;

@Service
public class ServiciosLoginImpl implements ServiciosLogin {

	@Autowired
	LoginMapper loginMapper;

	@Override
	public ListaDTO validarLogin(UsuarioDTO usuarioDTO) throws Exception {
		ListaDTO respuesta;
		try {
			respuesta = new ListaDTO();
			System.out.println("asasas");

			Long valor=loginMapper.validarLogin(usuarioDTO);
			System.out.println("asasas");
			System.out.println(valor);

			if(valor<=0) {
				respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_USU_PWD_NOVAL);
				respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_ERROR_USU_PWD_NOVAL);

				return respuesta;

			}

			respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
			respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);
			
			
			
			/*
			 * if (listado.isEmpty()) { respuesta.setCodigoRespuesta(ConstantesCodigosError.
			 * CODIGO_DATOS_NO_ENCONTRADOS);
			 * respuesta.setMensajeRespuesta(ConstantesCodigosError.
			 * CODIGO_DATOS_NO_ENCONTRADOS); } else { respuesta.setLista(listado);
			 * respuesta.setTotalPaginas(listado.size() > 0 ? 1 : 0);
			 * respuesta.setTotalRegistros(listado.size());
			 * respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO); }
			 */

		} catch (Exception e) {
			respuesta = new ListaDTO();
			respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_NO_CONTROLADO);
			// respuesta.setMensajeRespuesta(serviciosComun.consultarMensajePorIdioma(respuesta.getCodigoRespuesta()).getMensaje());

		}
		return respuesta;
		// TODO Auto-generated method stub
	}

	@Override
	public ListaDTO registrarUsuario(PersonaDTO personaDTO) throws Exception {
		ListaDTO respuesta;
		try {
			respuesta = new ListaDTO();
	
			Long validar = loginMapper.validarCorreo(personaDTO);
			if (validar > 0) {
				respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_EMAIL_EXISTE);
				respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_ERROR_EMAIL_EXISTE);
				return respuesta;
			}
			validar=0L;
			validar = loginMapper.validarDocumento(personaDTO);
			if (validar > 0) {
				respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_TIPO_DOCUMENTO);
				respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_ERROR_TIPO_DOCUMENTO);
				return respuesta;
			}
			
			loginMapper.crearPersona(personaDTO);
			System.out.println("notassaa");
			UsuarioDTO dto =new UsuarioDTO();
		     dto.setUsuario(personaDTO.getCorreo());
		     dto.setClave(personaDTO.getConstrasena());
		     dto.setIdPersona(personaDTO.getIdPersona());
			 loginMapper.crearUsuario(dto);
			 respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
			 respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);

			

		} catch (Exception e) {
			respuesta = new ListaDTO();
			respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_NO_CONTROLADO);
			// respuesta.setMensajeRespuesta(serviciosComun.consultarMensajePorIdioma(respuesta.getCodigoRespuesta()).getMensaje());

		}
		return respuesta;
		// TODO Auto-generated method stub
	}

}
