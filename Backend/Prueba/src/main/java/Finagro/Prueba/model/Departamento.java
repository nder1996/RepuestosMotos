package Finagro.Prueba.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {

    private String codigo_dane;
    private String nombre;
    private String region;
}
