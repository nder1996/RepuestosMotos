package Finagro.Prueba.repository;

import Finagro.Prueba.dto.response.TiendaResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GestionTiendaRepository {

    @Select("SELECT tienda.id, tienda.nombre, tienda.direccion, tienda.telefono, " +
            "municipio.codigo_dane, municipio.nombre as municipio_nombre, municipio.departamento_codigo_dane " +
            "FROM TIENDAS as tienda " +
            "LEFT JOIN MUNICIPIOS as municipio ON tienda.municipio_codigo_dane = municipio.codigo_dane")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nombre", column = "nombre"),
            @Result(property = "direccion", column = "direccion"),
            @Result(property = "telefono", column = "telefono"),
            @Result(property = "municipio.codigo_dane", column = "codigo_dane"),
            @Result(property = "municipio.nombre", column = "municipio_nombre"),
            @Result(property = "municipio.departamento_codigo_dane", column = "departamento_codigo_dane")
    })
    List<TiendaResponse> findAllTiendas();
}
