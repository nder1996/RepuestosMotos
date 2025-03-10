package Finagro.Prueba.controller;


import Finagro.Prueba.dto.response.ApiResponse;
import Finagro.Prueba.model.Inventario;
import Finagro.Prueba.service.GestionInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
public class GestionInventarioController {

    @Autowired
    private GestionInventarioService inventarioService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Inventario>>> getAllInventarios() {
        ApiResponse<List<Inventario>> response = inventarioService.findAll();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getMeta().getStatusCode()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Inventario>> getInventarioById(@PathVariable int id) {
        ApiResponse<Inventario> response = inventarioService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getMeta().getStatusCode()));
    }

    @GetMapping("/tienda/{tiendaId}")
    public ResponseEntity<ApiResponse<List<Inventario>>> getInventariosByTienda(@PathVariable int tiendaId) {
        ApiResponse<List<Inventario>> response = inventarioService.findByTienda(tiendaId);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getMeta().getStatusCode()));
    }

    @GetMapping("/repuesto/{repuestoId}")
    public ResponseEntity<ApiResponse<List<Inventario>>> getInventariosByRepuesto(@PathVariable int repuestoId) {
        ApiResponse<List<Inventario>> response = inventarioService.findByRepuesto(repuestoId);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getMeta().getStatusCode()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Inventario>> createInventario(@RequestBody Inventario inventario) {
        ApiResponse<Inventario> response = inventarioService.create(inventario);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getMeta().getStatusCode()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updateInventario(@PathVariable int id, @RequestBody Inventario inventario) {
        inventario.setId(id);
        ApiResponse<String> response = inventarioService.update(inventario);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getMeta().getStatusCode()));
    }

    @PatchMapping("/{id}/cantidad/{cantidad}")
    public ResponseEntity<ApiResponse<String>> updateCantidad(@PathVariable int id, @PathVariable int cantidad) {
        ApiResponse<String> response = inventarioService.actualizarCantidad(id, cantidad);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getMeta().getStatusCode()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteInventario(@PathVariable int id) {
        ApiResponse<String> response = inventarioService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getMeta().getStatusCode()));
    }
}
