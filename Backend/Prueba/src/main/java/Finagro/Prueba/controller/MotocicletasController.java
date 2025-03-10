package Finagro.Prueba.controller;

import Finagro.Prueba.model.Marca;
import Finagro.Prueba.repository.MotocicletasRepository;
import Finagro.Prueba.service.MotocicletasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MotocicletasController {


    private final MotocicletasService motocicletasService;

    @Autowired
    public MotocicletasController(MotocicletasService motocicletasService) {
        this.motocicletasService = motocicletasService;
    }

    @GetMapping
    public ResponseEntity<List<Marca>> getAllMarcas() {
        return ResponseEntity.ok(motocicletasService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> getMarcaById(@PathVariable Long id) {
        Marca marca = motocicletasService.findById(id);
        if (marca == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(marca);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Marca> getMarcaByNombre(@PathVariable String nombre) {
        Marca marca = motocicletasService.findByNombre(nombre);
        if (marca == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(marca);
    }

    @PostMapping
    public ResponseEntity<Void> createMarca(@RequestBody Marca marca) {
        motocicletasService.save(marca);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMarca(
            @PathVariable Long id,
            @RequestBody Marca marca) {

        if (!id.equals(marca.getId())) {
            return ResponseEntity.badRequest().build();
        }

        if (motocicletasService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        motocicletasService.save(marca);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarca(@PathVariable Long id) {
        if (motocicletasService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        motocicletasService.delete(id);
        return ResponseEntity.ok().build();
    }
}
