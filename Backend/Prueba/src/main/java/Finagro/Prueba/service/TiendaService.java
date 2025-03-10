package Finagro.Prueba.service;

import Finagro.Prueba.dto.response.ApiResponse;
import Finagro.Prueba.model.Tienda;
import Finagro.Prueba.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendaService {

    @Autowired
    private TiendaRepository  tiendaRepository;


    public ApiResponse<List<Tienda>> getAllTiendas() {
        try {
            List<Tienda> tiendas = tiendaRepository.findAll();
            return ResponseApiBuilderService.successResponse(tiendas, "tiendas", 200);
        } catch (Exception e) {
            return ResponseApiBuilderService.errorResponse(500, "ERROR_GETTING_TIENDAS", e.getMessage());
        }
    }

    public ApiResponse<Tienda> getTiendaById(int id) {
        try {
            Tienda tienda = tiendaRepository.findById(id);
            if (tienda != null) {
                return ResponseApiBuilderService.successResponse(tienda, "tienda", 200);
            } else {
                return ResponseApiBuilderService.errorResponse(404, "TIENDA_NOT_FOUND", "No se encontró la tienda con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseApiBuilderService.errorResponse(500, "ERROR_GETTING_TIENDA", e.getMessage());
        }
    }

    public ApiResponse<Tienda> createTienda(Tienda tienda) {
        try {
            tiendaRepository.insert(tienda);
            return ResponseApiBuilderService.successResponse(tienda, "tienda", 201);
        } catch (Exception e) {
            return ResponseApiBuilderService.errorResponse(500, "ERROR_CREATING_TIENDA", e.getMessage());
        }
    }

    public ApiResponse<String> updateTienda(Tienda tienda) {
        try {
            boolean updated = tiendaRepository.update(tienda) > 0;
            if (updated) {
                return ResponseApiBuilderService.successResponse("TIENDA_UPDATED", "updated", 200);
            } else {
                return ResponseApiBuilderService.errorResponse(404, "TIENDA_NOT_UPDATED", "No se pudo actualizar la tienda");
            }
        } catch (Exception e) {
            return ResponseApiBuilderService.errorResponse(500, "ERROR_UPDATING_TIENDA", e.getMessage());
        }
    }

    public ApiResponse<String> deleteTienda(int id) {
        try {
            boolean deleted = tiendaRepository.delete(id) > 0;
            if (deleted) {
                return ResponseApiBuilderService.successResponse("TIENDA_DELETED", "deleted", 200);
            } else {
                return ResponseApiBuilderService.errorResponse(404, "TIENDA_NOT_DELETED", "No se pudo eliminar la tienda");
            }
        } catch (Exception e) {
            return ResponseApiBuilderService.errorResponse(500, "ERROR_DELETING_TIENDA", e.getMessage());
        }
    }

}
