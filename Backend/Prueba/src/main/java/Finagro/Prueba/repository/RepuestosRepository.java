package Finagro.Prueba.repository;

import Finagro.Prueba.model.Repuesto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RepuestosRepository {

    @Select("SELECT * FROM dbo.REPUESTOS")
    List<Repuesto> findAll();

    @Select("SELECT * FROM dbo.REPUESTOS WHERE id = #{id}")
    Repuesto findById(int id);

    @Select("SELECT * FROM dbo.REPUESTOS WHERE modelo_id = #{modeloId}")
    List<Repuesto> findByModeloId(int modeloId);

    @Insert("INSERT INTO dbo.REPUESTOS (codigo, nombre, descripcion, precio, modelo_id) " +
            "VALUES (#{codigo}, #{nombre}, #{descripcion}, #{precio}, #{modeloId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Repuesto repuesto);

    @Update("UPDATE dbo.REPUESTOS SET codigo = #{codigo}, " +
            "nombre = #{nombre}, " +
            "descripcion = #{descripcion}, " +
            "precio = #{precio}, " +
            "modelo_id = #{modeloId} " +
            "WHERE id = #{id}")
    int update(Repuesto repuesto);

    @Delete("DELETE FROM dbo.REPUESTOS WHERE id = #{id}")
    int delete(int id);
}
