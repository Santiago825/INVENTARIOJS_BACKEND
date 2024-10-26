package com.example.demo.accesoDatos;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.modelos.ProveedorDTO;

@Mapper
public interface ProveedorMapper {
	public final String CONSULTAR_PROVEEDOR="SELECT p.idprovedor idProveedor,p.nombre nombreProveedor,p.telefono telefono, p.direccion direccion,p.email email ,d.id_departamento idDepartamento,d.departamento nombreDepartamento,p.idMunicipio idMunicipio,m.municipio nombreMunicipio,p.estado estado FROM inventariojs.proveedor p \r\n"
			+ "inner join municipios m on p.idMunicipio=m.id_municipio inner join departamentos d on  m.departamento_id=d.id_departamento;\r\n"
			+ " ";
	public final String CREAR_PROVEEDOR="INSERT INTO `inventariojs`.`proveedor` ( `nombre`, `telefono`, `email`, `idMunicipio`, `estado`, `direccion`) VALUES (#{nombreProveedor}, #{telefono}, #{email}, #{idMunicipio}, 'A', #{direccion});"
			+ "";
	public final String MODIFICAR_PROVEEDOR="UPDATE `inventariojs`.`proveedor` SET `nombre` = #{nombreProveedor}, `telefono` = #{telefono}, `email` = #{email}, `idMunicipio` = #{idMunicipio}, `direccion` = #{direccion} WHERE (`idprovedor` = #{idProveedor});\r\n"
			+ ""
		+ "";
	public final String CAMBIAR_ESTADO_PROVEEDOR="UPDATE `inventariojs`.`proveedor`  set estado=case estado when 'A' then 'I' when 'I' then 'A' end  WHERE (`idprovedor` = #{idProveedor});";
	
	@Select(CONSULTAR_PROVEEDOR)
	public List<ProveedorDTO> consultarProveedores();
	@Insert(CREAR_PROVEEDOR)
	public void crearProveedores(ProveedorDTO proveedorDTO);
	@Update(MODIFICAR_PROVEEDOR)
	public void modificarProveedores(ProveedorDTO proveedorDTO);
	@Update(CAMBIAR_ESTADO_PROVEEDOR)
	public void cambiarEstadoProveedores(ProveedorDTO proveedorDTO);
	
}
