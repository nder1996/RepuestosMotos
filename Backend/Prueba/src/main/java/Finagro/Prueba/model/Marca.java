package Finagro.Prueba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marca {

    private Integer id;
    private String nombre;
    private String paisOrigen;
}
