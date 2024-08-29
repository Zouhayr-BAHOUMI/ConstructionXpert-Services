package ressourceservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ressourceservice.exception.RessourceNotFoundException;
import ressourceservice.model.Ressource;
import ressourceservice.repository.RessourceRepository;

import java.util.List;

@Service
public class RessourceService {

    @Autowired
    private RessourceRepository ressourceRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void addRessource(Ressource ressource, int idTache){

        try {
            restTemplate.getForObject("http://localhost:8083/taches/idTache?idTache=" + idTache, Object.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Tache non trouvé : " + idTache);
        }

        ressource.setIdTache(idTache);
        ressourceRepository.save(ressource);
    }

    public Ressource getRessource(Long idRessource) {

        Ressource ressource = ressourceRepository
                .findById(idRessource)
                .orElseThrow(RessourceNotFoundException::new);
        return ressource;
    }

    public List<Ressource> getAllRessources() {
        return ressourceRepository.findAll();
    }

    public List<Ressource> getRessourcesByTache(int idTache){
        return ressourceRepository.findByIdTache(idTache);
    }

    public void updateRessource(int idRessource, Ressource ressource) {
        ressourceRepository
                .findById((long) idRessource)
                .orElseThrow(RessourceNotFoundException::new);

        ressource.setIdRessource(idRessource);

        ressourceRepository.save(ressource);
    }

    public void deleteRessource(Long idRessource) {
        Ressource ressourceSupprime = ressourceRepository
                .findById(idRessource)
                .orElseThrow(RessourceNotFoundException::new);

        ressourceRepository.delete(ressourceSupprime);
    }


}
