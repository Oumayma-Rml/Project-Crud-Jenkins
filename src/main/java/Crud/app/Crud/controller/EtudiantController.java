package Crud.app.Crud.controller;

import Crud.app.Crud.entity.Etudiant;
import Crud.app.Crud.services.serviceImp.EtudiantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/etudiant")

public class EtudiantController {

    private final EtudiantServiceImp etudiantService;

    public EtudiantController(EtudiantServiceImp etudiantService) {
        this.etudiantService = etudiantService;
    }

    // Get all Etudiants
        @GetMapping("list")
        public List<Etudiant> getAllEtudiants() {
            return etudiantService.getAllEtudiants();
        }

        // Get Etudiant by ID
        @GetMapping("/{id}")
        public Optional<Etudiant> getEtudiantById(@PathVariable Long id) {
            return etudiantService.getEtudiantById(id);
        }

        // Create or Update Etudiant
        @PostMapping("/add")
        public Etudiant createOrUpdateEtudiant(@RequestBody Etudiant etudiant) {
            return etudiantService.saveEtudiant(etudiant);
        }

        // Delete Etudiant by ID
        @DeleteMapping("/{id}")
        public void deleteEtudiant(@PathVariable Long id) {
            etudiantService.deleteEtudiant(id);
        }

        // Find Etudiant by email (custom query)
        @GetMapping("/email/{email}")
        public Etudiant getEtudiantByEmail(@PathVariable String email) {
            return etudiantService.findEtudiantByEmail(email);
        }

}
