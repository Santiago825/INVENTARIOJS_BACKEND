package com.example.demo.util.accesoDatos;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.util.modelos.DepartamentoDTO;
import com.example.demo.util.modelos.TipoDocumento;

@Mapper
public interface TipoDocumentoMapper {
	public final String COSNULTAR_TIPO_DOCUMENTO="SELECT nombre,valor FROM inventariojs.tipodocumento;";
	
	@Select(COSNULTAR_TIPO_DOCUMENTO)
	public List<TipoDocumento> consultarTipoDocumento();

}
