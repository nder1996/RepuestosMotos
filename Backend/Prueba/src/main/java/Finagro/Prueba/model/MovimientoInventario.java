package Finagro.Prueba.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoInventario {

    private Integer id;
    private Integer idTienda;
    private Integer idRespuesta;
    private Integer idVenta;
    private Integer cantidad;
    private Date fecha;
    private String tipo;
    private String observaciones;
}
