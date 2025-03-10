package Finagro.Prueba.controller;

import Finagro.Prueba.dto.response.ApiResponse;
import Finagro.Prueba.model.Tienda;
import Finagro.Prueba.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiendas")
public class TiendaController {


    @Autowired
    private TiendaService tiendaService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Tienda>>> getAllTiendas() {
        ApiResponse<List<Tienda>> response = tiendaService.getAllTiendas();
        return ResponseEntity.status(response.getMeta().getStatusCode()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Tienda>> getTiendaById(@PathVariable int id) {
        ApiResponse<Tienda> response = tiendaService.getTiendaById(id);
        return ResponseEntity.status(response.getMeta().getStatusCode()).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Tienda>> createTienda(@RequestBody Tienda tienda) {
        ApiResponse<Tienda> response = tiendaService.createTienda(tienda);
        return ResponseEntity.status(response.getMeta().getStatusCode()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updateTienda(@PathVariable int id, @RequestBody Tienda tienda) {
        tienda.setId(id);
        ApiResponse<String> response = tiendaService.updateTienda(tienda);
        return ResponseEntity.status(response.getMeta().getStatusCode()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteTienda(@PathVariable int id) {
        ApiResponse<String> response = tiendaService.deleteTienda(id);
        return ResponseEntity.status(response.getMeta().getStatusCode()).body(response);
    }
}
