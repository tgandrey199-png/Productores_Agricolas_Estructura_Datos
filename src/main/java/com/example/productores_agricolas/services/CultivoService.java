package com.example.productores_agricolas.services;

import com.example.productores_agricolas.dto.CreateCultivoRequest;
import com.example.productores_agricolas.models.Cultivo;
import com.example.productores_agricolas.structures.MiListaLigada;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CultivoService {

    private final MiListaLigada<Cultivo> cultivos = new MiListaLigada<>();
    private Long nextId = 1L;

    public CultivoService() {
        crearInterno("Maíz", LocalDate.now(), LocalDate.now().plusMonths(3), 2.5, 1L);
        crearInterno("Frijol", LocalDate.now(), LocalDate.now().plusMonths(4), 1.5, 2L);
        crearInterno("Tomate", LocalDate.now(), LocalDate.now().plusMonths(2), 1.0, 3L);
    }

    private void crearInterno(String nombre, LocalDate siembra, LocalDate cosecha, Double superficie, Long idParcela) {
        Cultivo c = new Cultivo();
        c.setId(nextId++);
        c.setNombreCultivo(nombre);
        c.setFechaSiembra(siembra);
        c.setFechaCosechaEstimada(cosecha);
        c.setSuperficieSembrada(superficie);
        c.setEstado("CRECIENDO");
        c.setIdParcela(idParcela);
        cultivos.agregar(c);
    }

    public List<Cultivo> obtenerTodos() {
        return cultivos.toList();
    }

    public Cultivo obtenerPorId(Long id) {
        return cultivos.toList().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Cultivo crear(CreateCultivoRequest req) {
        Cultivo c = new Cultivo();
        c.setId(nextId++);
        c.setNombreCultivo(req.getNombreCultivo());
        c.setFechaSiembra(req.getFechaSiembra());
        c.setFechaCosechaEstimada(req.getFechaCosechaEstimada());
        c.setSuperficieSembrada(req.getSuperficieSembrada());
        c.setEstado("CRECIENDO");
        c.setIdParcela(req.getIdParcela());

        cultivos.agregar(c);
        return c;
    }
}