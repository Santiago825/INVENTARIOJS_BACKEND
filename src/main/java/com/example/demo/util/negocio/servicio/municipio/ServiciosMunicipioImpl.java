package com.example.demo.util.negocio.servicio.municipio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.CategoriasDTO;
import com.example.demo.util.accesoDatos.DepartamentoMapper;
import com.example.demo.util.accesoDatos.MunicipioMapper;
import com.example.demo.util.modelos.DepartamentoDTO;
import com.example.demo.util.modelos.ListaDTO;
import com.example.demo.util.modelos.MunicipioDTO;
import com.example.demo.util.otros.constantes.config.ConstantesCodigosError;

@Service
public class ServiciosMunicipioImpl implements ServiciosMunicipio {
	@Autowired
	MunicipioMapper municipioMapper;

	@Override
	public ListaDTO cosnultarMunicipio(Long id) {
		ListaDTO respuesta;
		try {
			respuesta =new ListaDTO();
			System.out.println("kinkkks");
			System.out.println(id);
			List<MunicipioDTO> listado=municipioMapper.consultarMunicipio(id);
			System.out.println("pororo");
			System.out.println(listado);

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
