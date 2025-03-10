package Finagro.Prueba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modelo {

    private Integer id;
    private String nombre;
    private Integer cilindrada;
    private Integer anio;
    private Integer idMarca;
}
