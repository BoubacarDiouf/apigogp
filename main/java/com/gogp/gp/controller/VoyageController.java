package com.gogp.gp.controller;

import com.gogp.gp.modele.Voyage;
import com.gogp.gp.service.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voyages")
@CrossOrigin(origins = "http://localhost:4200")
public class VoyageController {

    @Autowired
    private VoyageService voyageService;

    @GetMapping
    public List<Voyage> getAllVoyages() {
        return voyageService.getAllVoyages();
    }

    @GetMapping("/{idVoyage}")
    public ResponseEntity<Voyage> getVoyageById(@PathVariable Long idVoyage) {
        Voyage voyage = voyageService.getVoyageById(idVoyage);
        if (voyage != null) {
            return ResponseEntity.ok(voyage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Voyage createVoyage(@RequestBody Voyage voyage) {
        return voyageService.saveVoyage(voyage);
    }

    @DeleteMapping("/{idVoyage}")
    public ResponseEntity<Void> deleteVoyage(@PathVariable Long idVoyage) {
        voyageService.deleteVoyage(idVoyage);
        return ResponseEntity.noContent().build();
    }
}
