package Finagro.Prueba.controller;

import Finagro.Prueba.model.Departamento;
import Finagro.Prueba.model.Municipio;
import Finagro.Prueba.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionController {

    private final UbicacionService ubicacionService;

    @Autowired
    public UbicacionController(UbicacionService ubicacionService) {
        this.ubicacionService = ubicacionService;
    }

    @GetMapping("/departamentos")
    public ResponseEntity<List<Departamento>> getAllDepartamentos() {
        List<Departamento> departamentos = ubicacionService.getAllDepartamentos();
        return ResponseEntity.ok(departamentos);
    }

    @GetMapping("/municipios/{codigoDepartamento}")
    public ResponseEntity<List<Municipio>> getMunicipiosByDepartamento(
            @PathVariable String codigoDepartamento) {
        List<Municipio> municipios = ubicacionService.getMunicipiosByDepartamento(codigoDepartamento);
        return ResponseEntity.ok(municipios);
    }

    @GetMapping("/actualizar")
    public ResponseEntity<String> actualizarDatosDANE() {
        try {
            ubicacionService.actualizarDatosDANE();
            return ResponseEntity.ok("Datos actualizados correctamente");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar datos: " + e.getMessage());
        }
    }
}
