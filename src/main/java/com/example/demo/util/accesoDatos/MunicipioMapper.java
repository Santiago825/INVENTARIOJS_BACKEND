package com.example.demo.util.accesoDatos;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.util.modelos.MunicipioDTO;

@Mapper
public interface MunicipioMapper {
	public final String COSNULTAR_MUNICIPIOS_ID="SELECT id_municipio idMunicipio,municipio nombreMunicipio FROM inventariojs.municipios where departamento_id=#{id};";
	
	@Select(COSNULTAR_MUNICIPIOS_ID)
	public List<MunicipioDTO> consultarMunicipio(@Param("id") Long id);

}
