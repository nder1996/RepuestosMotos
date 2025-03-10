package Finagro.Prueba.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    private Long id;
    private String numeroFactura;
    private Date fecha;
    private Long idTienda;
    private BigDecimal total;
}
