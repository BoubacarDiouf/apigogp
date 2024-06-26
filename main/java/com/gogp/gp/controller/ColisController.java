package com.gogp.gp.controller;

import com.gogp.gp.modele.Colis;
import com.gogp.gp.service.ColisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colis")
@CrossOrigin(origins = "http://localhost:4200")
public class ColisController {

    @Autowired
    private ColisService colisService;

    @GetMapping
    public List<Colis> getAllColis() {
        return colisService.getAllColis();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colis> getColisById(@PathVariable Long id) {
        Colis colis = colisService.getColisById(id);
        if (colis != null) {
            return ResponseEntity.ok(colis);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Colis createColis(@RequestBody Colis colis) {
        return colisService.saveColis(colis);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colis> updateColis(@PathVariable Long id, @RequestBody Colis updatedColis) {
        Colis existingColis = colisService.getColisById(id);
        if (existingColis == null) {
            return ResponseEntity.notFound().build();
        } else {
            // Mettre à jour les champs du colis existant avec les valeurs du colis mis à
            // jour
            existingColis.setQuantite(updatedColis.getQuantite());
            existingColis.setDescription(updatedColis.getDescription());
            existingColis.setPoids(updatedColis.getPoids());
            existingColis.setStatut(updatedColis.getStatut());
            existingColis.setPesable(updatedColis.getPesable());

            // Enregistrer le colis mis à jour
            Colis updatedColisEntity = colisService.saveColis(existingColis);

            // Retourner la réponse avec le colis mis à jour
            return ResponseEntity.ok(updatedColisEntity);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColis(@PathVariable Long id) {
        colisService.deleteColis(id);
        return ResponseEntity.noContent().build();
    }
}
