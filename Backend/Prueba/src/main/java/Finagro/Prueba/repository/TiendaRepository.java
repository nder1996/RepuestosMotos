package Finagro.Prueba.repository;

import Finagro.Prueba.model.Tienda;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TiendaRepository {

    @Select("SELECT * FROM dbo.TIENDAS")
    List<Tienda> findAll();

    @Select("SELECT * FROM dbo.TIENDAS WHERE id = #{id}")
    Tienda findById(int id);

    @Insert("INSERT INTO dbo.TIENDAS (nombre, municipio_codigo_dane, direccion, telefono) " +
            "VALUES (#{nombre}, #{municipio_codigo_dane}, #{direccion}, #{telefono})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Tienda tienda);

    @Update("UPDATE dbo.TIENDAS SET nombre = #{nombre}, " +
            "municipio_codigo_dane = #{municipio_codigo_dane}, " +
            "direccion = #{direccion}, " +
            "telefono = #{telefono} " +
            "WHERE id = #{id}")
    int update(Tienda tienda);

    @Delete("DELETE FROM dbo.TIENDAS WHERE id = #{id}")
    int delete(int id);

}
