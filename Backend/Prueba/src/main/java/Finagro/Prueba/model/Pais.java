package Finagro.Prueba.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pais {

    private Integer id;
    private String codigo;
    private String nombre;
}
