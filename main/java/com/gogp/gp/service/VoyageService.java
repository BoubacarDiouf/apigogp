package com.gogp.gp.service;

import com.gogp.gp.modele.Voyage;
import com.gogp.gp.repository.VoyageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoyageService {

    @Autowired
    private VoyageRepository voyageRepository;

    public List<Voyage> getAllVoyages() {
        return voyageRepository.findAll();
    }

    public Voyage getVoyageById(Long idVoyage) {
        return voyageRepository.findById(idVoyage).orElse(null);
    }

    public Voyage saveVoyage(Voyage voyage) {
        return voyageRepository.save(voyage);
    }

    public void deleteVoyage(Long idVoyage) {
        voyageRepository.deleteById(idVoyage);
    }
}
