package Finagro.Prueba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repuesto {

    private Integer id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer idModelo;

}
