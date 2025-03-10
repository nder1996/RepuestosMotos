package Finagro.Prueba.controller;

import Finagro.Prueba.model.Repuesto;
import Finagro.Prueba.service.RepuestosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {

    private RepuestosService repuestoService;

    @GetMapping
    public ResponseEntity<List<Repuesto>> getAllRepuestos() {
        return ResponseEntity.ok(repuestoService.getAllRepuestos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Repuesto> getRepuestoById(@PathVariable int id) {
        Repuesto repuesto = repuestoService.getRepuestoById(id);
        if (repuesto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(repuesto);
    }

    @GetMapping("/modelo/{modeloId}")
    public ResponseEntity<List<Repuesto>> getRepuestosByModelo(@PathVariable int modeloId) {
        return ResponseEntity.ok(repuestoService.getRepuestosByModelo(modeloId));
    }

    @PostMapping
    public ResponseEntity<Repuesto> createRepuesto(@RequestBody Repuesto repuesto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repuestoService.createRepuesto(repuesto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRepuesto(@PathVariable int id, @RequestBody Repuesto repuesto) {
        repuesto.setId(id);
        if (repuestoService.updateRepuesto(repuesto)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepuesto(@PathVariable int id) {
        if (repuestoService.deleteRepuesto(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
