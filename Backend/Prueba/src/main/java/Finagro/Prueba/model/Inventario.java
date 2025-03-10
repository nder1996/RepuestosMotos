package Finagro.Prueba.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {

    private Integer id;
    private Integer idTienda;
    private Integer idRespuesta;
    private Integer cantidad;
    private Integer stockMinimo;
    private Date ultimaActualizacion;
}
