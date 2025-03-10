package Finagro.Prueba.service;

import Finagro.Prueba.model.Repuesto;
import Finagro.Prueba.repository.RepuestosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestosService {

    private RepuestosRepository repuestosRepository;

    public List<Repuesto> getAllRepuestos() {
        return repuestosRepository.findAll();
    }

    public Repuesto getRepuestoById(int id) {
        return repuestosRepository.findById(id);
    }

    public List<Repuesto> getRepuestosByModelo(int modeloId) {
        return repuestosRepository.findByModeloId(modeloId);
    }

    public Repuesto createRepuesto(Repuesto repuesto) {
        repuestosRepository.insert(repuesto);
        return repuesto;
    }

    public boolean updateRepuesto(Repuesto repuesto) {
        return repuestosRepository.update(repuesto) > 0;
    }

    public boolean deleteRepuesto(int id) {
        return repuestosRepository.delete(id) > 0;
    }
}
