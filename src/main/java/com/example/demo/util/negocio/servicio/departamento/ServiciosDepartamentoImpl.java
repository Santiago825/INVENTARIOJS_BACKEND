package com.example.demo.util.negocio.servicio.departamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.CategoriasDTO;
import com.example.demo.util.accesoDatos.DepartamentoMapper;
import com.example.demo.util.modelos.DepartamentoDTO;
import com.example.demo.util.modelos.ListaDTO;
import com.example.demo.util.otros.constantes.config.ConstantesCodigosError;

@Service
public class ServiciosDepartamentoImpl implements ServiciosDepartamento {
	@Autowired
	DepartamentoMapper departamentoMapper;

	@Override
	public ListaDTO cosnultarDepartamento() {
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			List<DepartamentoDTO> listado=departamentoMapper.consultarDepartemento();
		
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
	

}
