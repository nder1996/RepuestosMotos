package Finagro.Prueba.service;

import Finagro.Prueba.dto.response.ApiResponse;
import Finagro.Prueba.model.Inventario;
import Finagro.Prueba.repository.GestionInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GestionInventarioService {

    @Autowired
    private GestionInventarioRepository gestionInventarioRepository;

    public ApiResponse<Inventario> findById(int id) {
        Inventario inventario = gestionInventarioRepository.findById(id);
        if (inventario != null) {
            return ResponseApiBuilderService.successResponse(inventario, "inventario", 200);
        }
        return ResponseApiBuilderService.errorResponse(404, "NOT_FOUND", "Inventario no encontrado");
    }

    public ApiResponse<List<Inventario>> findAll() {
        List<Inventario> inventarios = gestionInventarioRepository.findAll();
        return ResponseApiBuilderService.successResponse(inventarios, "inventarios", 200);
    }

    public ApiResponse<List<Inventario>> findByTienda(int tiendaId) {
        List<Inventario> inventarios = gestionInventarioRepository.findByTienda(tiendaId);
        return ResponseApiBuilderService.successResponse(inventarios, "inventarios", 200);
    }

    public ApiResponse<List<Inventario>> findByRepuesto(int repuestoId) {
        List<Inventario> inventarios = gestionInventarioRepository.findByRepuesto(repuestoId);
        return ResponseApiBuilderService.successResponse(inventarios, "inventarios", 200);
    }

    public ApiResponse<Inventario> create(Inventario inventario) {
        try {
            inventario.setUltimaActualizacion(new Date());
            gestionInventarioRepository.insert(inventario);
            return ResponseApiBuilderService.successResponse(inventario, "inventario", 201);
        } catch (Exception e) {
            return ResponseApiBuilderService.errorResponse(500, "ERROR", e.getMessage());
        }
    }

    public ApiResponse<String> update(Inventario inventario) {
        try {
            inventario.setUltimaActualizacion(new Date());
            if (gestionInventarioRepository.update(inventario) > 0) {
                return ResponseApiBuilderService.successResponse("Inventario actualizado correctamente", "mensaje", 200);
            }
            return ResponseApiBuilderService.errorResponse(404, "NOT_FOUND", "No se pudo actualizar el inventario");
        } catch (Exception e) {
            return ResponseApiBuilderService.errorResponse(500, "ERROR", e.getMessage());
        }
    }

    public ApiResponse<String> delete(int id) {
        try {
            if (gestionInventarioRepository.delete(id) > 0) {
                return ResponseApiBuilderService.successResponse("Inventario eliminado correctamente", "mensaje", 200);
            }
            return ResponseApiBuilderService.errorResponse(404, "NOT_FOUND", "No se pudo eliminar el inventario");
        } catch (Exception e) {
            return ResponseApiBuilderService.errorResponse(500, "ERROR", e.getMessage());
        }
    }

    public ApiResponse<String> actualizarCantidad(int id, int cantidad) {
        try {
            Inventario inventario = gestionInventarioRepository.findById(id);
            if (inventario != null) {
                inventario.setCantidad(cantidad);
                inventario.setUltimaActualizacion(new Date());
                if (gestionInventarioRepository.update(inventario) > 0) {
                    return ResponseApiBuilderService.successResponse("Cantidad actualizada correctamente", "mensaje", 200);
                }
            }
            return ResponseApiBuilderService.errorResponse(404, "NOT_FOUND", "Inventario no encontrado");
        } catch (Exception e) {
            return ResponseApiBuilderService.errorResponse(500, "ERROR", e.getMessage());
        }
    }
}
