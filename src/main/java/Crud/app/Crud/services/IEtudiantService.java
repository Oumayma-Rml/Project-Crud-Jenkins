package Crud.app.Crud.services;

import Crud.app.Crud.entity.Etudiant;

import java.util.List;
import java.util.Optional;

public interface IEtudiantService {

    Etudiant saveEtudiant(Etudiant etudiant);

    // Get all Etudiants
    List<Etudiant> getAllEtudiants();

    // Get an Etudiant by its ID
    Optional<Etudiant> getEtudiantById(Long id);

    // Delete an Etudiant by its ID
    void deleteEtudiant(Long id);

    // Find an Etudiant by email (custom query example)
    Etudiant findEtudiantByEmail(String email);
}



