package Finagro.Prueba.service;

import Finagro.Prueba.model.Marca;
import Finagro.Prueba.repository.MotocicletasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MotocicletasService {


    private final MotocicletasRepository motocicletaRepository;

    @Autowired
    public MotocicletasService(MotocicletasRepository motocicletaRepository) {
        this.motocicletaRepository = motocicletaRepository;
    }

    public List<Marca> findAll() {
        return motocicletaRepository.findAll();
    }

    public Marca findById(Long id) {
        return motocicletaRepository.findById(id);
    }

    public Marca findByNombre(String nombre) {
        return motocicletaRepository.findByNombre(nombre);
    }

    @Transactional
    public void save(Marca marca) {
        if (marca.getId() == null) {
            motocicletaRepository.insert(marca);
        } else {
            motocicletaRepository.update(marca);
        }
    }

    @Transactional
    public void delete(Long id) {
        motocicletaRepository.delete(id);
    }
}
