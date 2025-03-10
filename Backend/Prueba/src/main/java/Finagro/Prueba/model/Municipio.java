package Finagro.Prueba.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Municipio {

    private String codigo_dane;
    private String nombre;
    private String departamento_codigo_dane;
}
