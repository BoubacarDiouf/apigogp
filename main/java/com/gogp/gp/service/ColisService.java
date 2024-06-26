package com.gogp.gp.service;

import com.gogp.gp.modele.Colis;
import com.gogp.gp.repository.ColisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColisService {

    @Autowired
    private ColisRepository colisRepository;

    public List<Colis> getAllColis() {
        return colisRepository.findAll();
    }

    public Colis getColisById(Long id) {
        return colisRepository.findById(id).orElse(null);
    }

    public Colis saveColis(Colis colis) {
        return colisRepository.save(colis);
    }

    public void deleteColis(Long id) {
        colisRepository.deleteById(id);
    }
}
