package Finagro.Prueba.service;

import Finagro.Prueba.dto.response.ApiResponse;
import Finagro.Prueba.dto.response.TiendaResponse;
import Finagro.Prueba.model.Tienda;
import Finagro.Prueba.repository.GestionTiendaRepository;
import Finagro.Prueba.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionTiendaService {

    @Autowired
    private GestionTiendaRepository gestionTiendaRepository;

    public ApiResponse<List<TiendaResponse>> getAllTiendas() {
        try {
            List<TiendaResponse> tiendas = gestionTiendaRepository.findAllTiendas();
            return ResponseApiBuilderService.successResponse(tiendas, "tiendas", 200);
        } catch (Exception e) {
            return ResponseApiBuilderService.errorResponse(500, "ERROR_GETTING_TIENDAS", e.getMessage());
        }
    }
}
