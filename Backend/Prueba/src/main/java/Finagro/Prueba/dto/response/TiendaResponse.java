package Finagro.Prueba.dto.response;


import Finagro.Prueba.model.Municipio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TiendaResponse {

    private Integer id;
    private String nombre;
    private Municipio municipio;
    private String direccion;
    private String telefono;
}
