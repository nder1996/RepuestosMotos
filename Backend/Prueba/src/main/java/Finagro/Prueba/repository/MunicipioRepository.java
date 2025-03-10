package Finagro.Prueba.repository;

import Finagro.Prueba.model.Municipio;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MunicipioRepository {


    @Select("SELECT codigo_dane, nombre, departamento_codigo_dane FROM dbo.MUNICIPIOS ORDER BY nombre")
    List<Municipio> findAll();

    @Select("SELECT codigo_dane, nombre, departamento_codigo_dane FROM dbo.MUNICIPIOS WHERE departamento_codigo_dane = #{departamentoCodigoDane} ORDER BY nombre")
    List<Municipio> findByDepartamento(String departamentoCodigoDane);

    @Select("SELECT codigo_dane, nombre, departamento_codigo_dane FROM dbo.MUNICIPIOS WHERE codigo_dane = #{codigo_dane}")
    Municipio findByCodigoDane(String codigoDane);

    @Insert("INSERT INTO dbo.MUNICIPIOS (codigo_dane, nombre, departamento_codigo_dane) VALUES (#{codigoDane}, #{nombre}, #{departamento_codigo_dane})")
    int insert(Municipio municipio);

    @Update("UPDATE dbo.MUNICIPIOS SET nombre = #{nombre}, departamento_codigo_dane = #{departamento_codigo_dane} WHERE codigo_dane = #{codigo_dane}")
    int update(Municipio municipio);

    @Select("SELECT COUNT(*) FROM dbo.MUNICIPIOS WHERE codigo_dane = #{codigo_dane}")
    int countByCodigoDane(String codigoDane);

}
