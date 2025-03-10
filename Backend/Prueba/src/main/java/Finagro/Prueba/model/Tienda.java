package Finagro.Prueba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tienda {

    private Integer id;
    private String nombre;
    private String municipio_codigo_dane;
    private String direccion;
    private String telefono;

}
