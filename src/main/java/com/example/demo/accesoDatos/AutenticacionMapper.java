package com.example.demo.accesoDatos;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.modelos.DatosAutenticacionDTO;

@Mapper
public interface AutenticacionMapper {

    @Select(value= "SELECT usuario usuario,clave usuarioContr FROM inventariojs.usuario where Usuario=#{usuario} ")
    public DatosAutenticacionDTO autenticacion(String usuario);

}
