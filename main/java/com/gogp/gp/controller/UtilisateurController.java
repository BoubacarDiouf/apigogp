package com.gogp.gp.controller;

import com.gogp.gp.modele.Utilisateur;
import com.gogp.gp.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
        return ResponseEntity.ok(utilisateurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        if (utilisateur != null) {
            return ResponseEntity.ok(utilisateur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur createdUtilisateur = utilisateurService.saveUtilisateur(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUtilisateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id,
            @RequestBody Utilisateur utilisateurDetails) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        if (utilisateur != null) {
            utilisateur.setPrenom(utilisateurDetails.getPrenom());
            utilisateur.setNom(utilisateurDetails.getNom());
            utilisateur.setEmail(utilisateurDetails.getEmail());
            utilisateur.setRole(utilisateurDetails.getRole());
            utilisateur.setPassword(utilisateurDetails.getPassword());
            utilisateur.setActive(utilisateurDetails.isActive()); // Assurez-vous d'ajouter ceci
            Utilisateur updatedUtilisateur = utilisateurService.saveUtilisateur(utilisateur);
            return ResponseEntity.ok(updatedUtilisateur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity<Void> activateUtilisateur(@PathVariable Long id) {
        utilisateurService.activateUtilisateur(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<Void> deactivateUtilisateur(@PathVariable Long id) {
        utilisateurService.deactivateUtilisateur(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.noContent().build();
    }

}
