package com.example.demo.util.accesoDatos;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.util.modelos.DepartamentoDTO;

@Mapper
public interface DepartamentoMapper {
	public final String COSNULTAR_DEPARTAMENTOS="SELECT id_departamento idDepartamento,departamento nombreDepartamento FROM inventariojs.departamentos;";
	
	@Select(COSNULTAR_DEPARTAMENTOS)
	public List<DepartamentoDTO> consultarDepartemento();

}
