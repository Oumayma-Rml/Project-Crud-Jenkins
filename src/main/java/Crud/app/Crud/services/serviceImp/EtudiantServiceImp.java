package Crud.app.Crud.services.serviceImp;

import Crud.app.Crud.entity.Etudiant;
import Crud.app.Crud.repository.EtudiantRepository;
import Crud.app.Crud.services.IEtudiantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EtudiantServiceImp implements IEtudiantService {


    private final EtudiantRepository etudiantRepository;

    public EtudiantServiceImp(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }


    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Optional<Etudiant> getEtudiantById(Long id) {

        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        return etudiant;

    }

    @Override
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant findEtudiantByEmail(String email) {
        return null;
    }
}
