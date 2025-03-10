package Finagro.Prueba.service;

import Finagro.Prueba.model.Departamento;
import Finagro.Prueba.model.Municipio;
import Finagro.Prueba.repository.DepartamentoRepository;
import Finagro.Prueba.repository.MunicipioRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UbicacionService {

    private final RestTemplate restTemplate;
    private final DepartamentoRepository departamentoMapper;
    private final MunicipioRepository municipioMapper;
    private final ObjectMapper objectMapper;

    private static final String DANE_API_URL = "https://www.datos.gov.co/resource/xdk5-pm3f.json";

    @Autowired
    public UbicacionService(RestTemplate restTemplate,
                            DepartamentoRepository departamentoMapper,
                            MunicipioRepository municipioMapper,
                            ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.departamentoMapper = departamentoMapper;
        this.municipioMapper = municipioMapper;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public void actualizarDatosDANE() {
        try {
            JsonNode[] response = restTemplate.getForObject(DANE_API_URL, JsonNode[].class);

            Map<String, Departamento> departamentos = new HashMap<>();
            List<Municipio> municipios = new ArrayList<>();

            for (JsonNode item : response) {
                // Extraer datos del JSON
                String region = item.has("region") ? item.get("region").asText() : null;
                String codigoDepartamento = item.get("c_digo_dane_del_departamento").asText();
                String nombreDepartamento = item.get("departamento").asText();

                // El código del municipio incluye un punto que debe eliminarse
                String codigoMunicipioRaw = item.get("c_digo_dane_del_municipio").asText();
                String codigoMunicipio = codigoMunicipioRaw.replace(".", "");

                String nombreMunicipio = item.get("municipio").asText();

                // Crear o actualizar departamento
                if (!departamentos.containsKey(codigoDepartamento)) {
                    Departamento departamento = new Departamento();
                    departamento.setCodigo_dane(codigoDepartamento);
                    departamento.setNombre(nombreDepartamento);
                    departamento.setRegion(region);
                    departamentos.put(codigoDepartamento, departamento);
                }

                // Crear municipio
                Municipio municipio = new Municipio();
                municipio.setCodigo_dane(codigoMunicipio);
                municipio.setNombre(nombreMunicipio);
                municipio.setDepartamento_codigo_dane(codigoDepartamento);
                municipios.add(municipio);
            }

            // Guardar departamentos en la BD
            for (Departamento departamento : departamentos.values()) {
                if (departamentoMapper.countByCodigoDane(departamento.getCodigo_dane()) == 0) {
                    departamentoMapper.insert(departamento);
                } else {
                    departamentoMapper.update(departamento);
                }
            }

            // Guardar municipios en la BD
            for (Municipio municipio : municipios) {
                if (municipioMapper.countByCodigoDane(municipio.getCodigo_dane()) == 0) {
                    municipioMapper.insert(municipio);
                } else {
                    municipioMapper.update(municipio);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar datos DANE: " + e.getMessage(), e);
        }
    }

    public List<Departamento> getAllDepartamentos() {
        return departamentoMapper.findAll();
    }

    public List<Municipio> getMunicipiosByDepartamento(String codigoDepartamento) {
        return municipioMapper.findByDepartamento(codigoDepartamento);
    }


}
