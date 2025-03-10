package Finagro.Prueba.repository;

import Finagro.Prueba.model.Inventario;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GestionInventarioRepository {

    @Select("SELECT * FROM dbo.INVENTARIOS WHERE id = #{id}")
    Inventario findById(int id);

    @Select("SELECT * FROM dbo.INVENTARIOS")
    List<Inventario> findAll();

    @Select("SELECT * FROM dbo.INVENTARIOS WHERE tienda_id = #{tiendaId}")
    List<Inventario> findByTienda(int tiendaId);

    @Select("SELECT * FROM dbo.INVENTARIOS WHERE repuesto_id = #{repuestoId}")
    List<Inventario> findByRepuesto(int repuestoId);

    @Insert("INSERT INTO dbo.INVENTARIOS (tienda_id, repuesto_id, cantidad, stock_minimo, ultima_actualizacion) " +
            "VALUES (#{tiendaId}, #{repuestoId}, #{cantidad}, #{stockMinimo}, #{ultimaActualizacion})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Inventario inventario);

    @Update("UPDATE dbo.INVENTARIOS SET tienda_id = #{tiendaId}, repuesto_id = #{repuestoId}, " +
            "cantidad = #{cantidad}, stock_minimo = #{stockMinimo}, ultima_actualizacion = #{ultimaActualizacion} " +
            "WHERE id = #{id}")
    int update(Inventario inventario);

    @Delete("DELETE FROM dbo.INVENTARIOS WHERE id = #{id}")
    int delete(int id);
}
