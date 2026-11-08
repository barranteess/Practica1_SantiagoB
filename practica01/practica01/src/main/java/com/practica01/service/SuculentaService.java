/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica01.service;

import com.practica01.domain.Suculenta;
import com.practica01.repository.SuculentaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SuculentaService {

    private final SuculentaRepository suculentaRepository;

    public SuculentaService(SuculentaRepository suculentaRepository) {
        this.suculentaRepository = suculentaRepository;
    }

    @Transactional(readOnly = true)
    public List<Suculenta> getSuculentas() {
        return suculentaRepository.findAll(Sort.by("nombreComun"));
    }

    @Transactional(readOnly = true)
    public Optional<Suculenta> getSuculenta(Integer idSuculenta) {
        return suculentaRepository.findById(idSuculenta);
    }

    @Transactional
    public void save(Suculenta suculenta) {
        suculentaRepository.save(suculenta);
    }

    @Transactional
    public void delete(Integer idSuculenta) {
        if (!suculentaRepository.existsById(idSuculenta)) {
            throw new IllegalArgumentException("La suculenta con código " + idSuculenta + " no existe.");
        }
        suculentaRepository.deleteById(idSuculenta);
    }
}