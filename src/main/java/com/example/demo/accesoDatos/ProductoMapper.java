package com.example.demo.accesoDatos;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.modelos.ProductosDTO;

@Mapper
public interface ProductoMapper {
	public final String CONSULTAR_PRODUCTOS="SELECT p.idProductos idProducto,p.nombre nombreProducto,p.cantidad cantidadProducto,p.precio precioProducto,p.idCategoria idCategoria,c.nombre nombreCategoria ,p.imagen imagenProducto,p.estado estadoProducto FROM inventariojs.productos p\r\n"
			+ "inner join categorias c on p.idCategoria=c.idCategoria";
	public final String CREAR_PRODUCTO="INSERT INTO `inventariojs`.`productos` ( `nombre`, `cantidad`, `precio`, `idCategoria`, `imagen`, `estado`) VALUES (#{nombreProducto}, #{cantidadProducto}, #{precioProducto}, #{idCategoria}, #{imagenProducto}, 'A');";
	public final String MODIFICAR_PRODUCTO="UPDATE `inventariojs`.`productos` SET `nombre` = #{nombreProducto}, `cantidad` = #{cantidadProducto}, `precio` = #{precioProducto}, `idCategoria` = #{idCategoria}, `imagen` = #{imagenProducto} WHERE (`idProductos` = #{idProducto});\r\n"
			+ "";
	public final String CAMBIAR_ESTADO_PRODUCTO="UPDATE `inventariojs`.`productos`  set estado=case estado when 'A' then 'I' when 'I' then 'A' end  WHERE (`idProductos` = #{idProducto});";
	
	@Select(CONSULTAR_PRODUCTOS)
	public List<ProductosDTO> consultarProductos();
	@Insert(CREAR_PRODUCTO)
	public void crearProductos(ProductosDTO ProductosDTO);
	@Update(MODIFICAR_PRODUCTO)
	public void modificarProductos(ProductosDTO ProductosDTO);
	@Update(CAMBIAR_ESTADO_PRODUCTO)
	public void cambiarEstadoProductos(ProductosDTO ProductosDTO);

}
