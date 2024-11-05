package com.example.demo.accesoDatos;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.demo.modelos.PersonaDTO;
import com.example.demo.modelos.UsuarioDTO;

@Mapper
public interface LoginMapper {
	public final String CREAR_PERSONA="INSERT INTO `inventariojs`.`persona` ( `nombre`, `apellido`, `tipoDocumento`, `numeroDocumento`, `email`, `telefono`, `estado`) VALUES (#{nombre}, #{apellido},#{tipoDocumento}, #{numeroDocumento}, #{correo}, #{telefono}, 'A');\r\n"
			+ "";
	public final String CREAR_USUARIO="INSERT INTO `inventariojs`.`usuario` (`Usuario`, `idRol`, `estado`, `idPersona`, `clave`) VALUES (#{usuario}, '1', 'A', #{idPersona}, #{clave});\r\n"
			+ "";
	public final String VALIDAR_CORREO="SELECT count(*) FROM inventariojs.persona where email=#{correo}";
	public final String VALIDAR_DOCUMENTO="SELECT count(*) FROM inventariojs.persona where tipoDocumento=#{tipoDocumento} and numeroDocumento=#{numeroDocumento} ;";
	public final String VALIDAR_LOGIN="SELECT count(*) FROM inventariojs.usuario where usuario=#{usuario} and clave=#{clave};";

	
	@Insert(CREAR_USUARIO)
	public void crearUsuario(UsuarioDTO usuarioDTO);
	@Insert(CREAR_PERSONA)
    @Options(useGeneratedKeys=true, keyProperty="idPersona")
	public void crearPersona(PersonaDTO personaDTO);
	@Select(VALIDAR_CORREO)
	public Long validarCorreo(PersonaDTO personaDTO);
	@Select(VALIDAR_DOCUMENTO)
	public Long validarDocumento(PersonaDTO personaDTO);
	@Select(VALIDAR_LOGIN)
	public Long validarLogin(UsuarioDTO usuarioDTO);



}
