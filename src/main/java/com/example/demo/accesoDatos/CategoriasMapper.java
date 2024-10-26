package com.example.demo.accesoDatos;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.modelos.CategoriasDTO;

import jakarta.websocket.server.PathParam;

@Mapper
public interface CategoriasMapper {
	public final String CONSULTAR_CATEGORIAS="SELECT idCategoria idCategoria,nombre nombreCategoria,estado estadoCategoria FROM inventariojs.categorias;";
	public final String CONSULTAR_CATEGORIAS_ID="SELECT idCategoria idCategoria,nombre nombreCategoria,estado estadoCategoria FROM inventariojs.categorias WHERE nombre=#{id};";

	public final String CREAR_CATEGORIAS="INSERT INTO `inventariojs`.`categorias` (`idCategoria`, `nombre`, `estado`) VALUES (#{idCategoria}, #{nombreCategoria},'A');";
	public final String MODIFICAR_CATEGORIAS="UPDATE `inventariojs`.`categorias` SET `nombre` = #{nombreCategoria} WHERE (`idCategoria` = #{idCategoria});";
	public final String CAMBIAR_ESTADO_CATEGORIAS="UPDATE `inventariojs`.`categorias`  set estado=case estado when 'A' then 'I' when 'I' then 'A' end  WHERE (`idCategoria` = #{idCategoria});\r\n"
			+ "";

	@Select(CONSULTAR_CATEGORIAS)
	public List<CategoriasDTO> consultarCategorias();
	@Select(CONSULTAR_CATEGORIAS_ID)
	public CategoriasDTO consultarCategoriaId(@Param("id") Long id);
	@Insert(CREAR_CATEGORIAS)
	public void crearCategoria(CategoriasDTO categoriaDTO );
	@Update(MODIFICAR_CATEGORIAS)
	public void modificarCategoria(CategoriasDTO categoriaDTO );
	@Update(CAMBIAR_ESTADO_CATEGORIAS)
	public void cambiarEsatdoCategoria(CategoriasDTO categoriaDTO );
}
