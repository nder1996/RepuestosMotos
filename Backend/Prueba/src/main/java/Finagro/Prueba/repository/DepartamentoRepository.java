package Finagro.Prueba.repository;

import Finagro.Prueba.model.Departamento;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartamentoRepository {

    @Select("SELECT codigo_dane, nombre, region FROM dbo.DEPARTAMENTOS ORDER BY nombre")
    List<Departamento> findAll();

    @Select("SELECT codigo_dane, nombre, region FROM dbo.DEPARTAMENTOS WHERE codigo_dane = #{codigo_dane}")
    Departamento findByCodigoDane(String codigoDane);

    @Insert("INSERT INTO dbo.DEPARTAMENTOS (codigo_dane, nombre, region) VALUES (#{codigo_dane}, #{nombre}, #{region})")
    int insert(Departamento departamento);

    @Update("UPDATE dbo.DEPARTAMENTOS SET nombre = #{nombre}, region = #{region} WHERE codigo_dane = #{codigo_dane}")
    int update(Departamento departamento);

    @Select("SELECT COUNT(*) FROM dbo.DEPARTAMENTOS WHERE codigo_dane = #{codigo_dane}")
    int countByCodigoDane(String codigoDane);
}
