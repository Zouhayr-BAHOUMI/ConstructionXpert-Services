package projetservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetservice.exception.ProjetNotFoundException;
import projetservice.model.Projet;
import projetservice.repository.ProjetRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    public void addProjet(Projet projet){
        projetRepository.save(projet);
    }

    public Projet getProjet(Long idProjet) {

        Projet projet = projetRepository
                .findById(idProjet)
                .orElseThrow(ProjetNotFoundException::new);
        return projet;
    }

    public List<Projet> getAllProjets() {
        return projetRepository.findAll();
    }

    public void updateProjet(int idProjet, Projet projet) {
        projetRepository
                .findById((long) idProjet)
                .orElseThrow(ProjetNotFoundException::new);

        projet.setIdProjet(idProjet);

        projetRepository.save(projet);
    }

    public void deleteProjet(Long idProjet) {
        Projet projetSupprime = projetRepository
                .findById(idProjet)
                .orElseThrow(ProjetNotFoundException::new);

        projetRepository.delete(projetSupprime);
    }


}
