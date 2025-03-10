package Finagro.Prueba.controller;


import Finagro.Prueba.dto.response.ApiResponse;
import Finagro.Prueba.dto.response.TiendaResponse;
import Finagro.Prueba.model.Tienda;
import Finagro.Prueba.service.GestionTiendaService;
import Finagro.Prueba.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gestionTienda")
public class GestionTiendaController {

    @Autowired
    private GestionTiendaService gestionTiendaService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<TiendaResponse>>> getAllTiendas() {
        ApiResponse<List<TiendaResponse>> response = gestionTiendaService.getAllTiendas();
        return ResponseEntity.status(response.getMeta().getStatusCode()).body(response);
    }
}
