package Finagro.Prueba.repository;

import Finagro.Prueba.model.Marca;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MotocicletasRepository {

    @Select("SELECT * FROM dbo.MARCAS")
    List<Marca> findAll();

    @Select("SELECT * FROM dbo.MARCAS WHERE id = #{id}")
    Marca findById(Long id);

    @Select("SELECT * FROM dbo.MARCAS WHERE nombre = #{nombre}")
    Marca findByNombre(String nombre);

    @Insert("INSERT INTO dbo.MARCAS(nombre, pais_origen) VALUES(#{nombre}, #{paisOrigen})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Marca marca);

    @Update("UPDATE dbo.MARCAS SET nombre = #{nombre}, pais_origen = #{paisOrigen} WHERE id = #{id}")
    void update(Marca marca);

    @Delete("DELETE FROM dbo.MARCAS WHERE id = #{id}")
    void delete(Long id);
}
