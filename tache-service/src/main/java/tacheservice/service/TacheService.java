package tacheservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tacheservice.enums.Status;
import tacheservice.model.Tache;
import tacheservice.repository.TacheRepository;

@Service
public class TacheService {

    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void addTache(Tache tache, int idProjet){

        try {
            restTemplate.getForObject("http://localhost:8081/projets/" + idProjet, Object.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Projet non trouvé : " + idProjet);
        }

        tache.setIdProjet(idProjet);
        tache.setStatus(Status.A_FAIRE);
        tacheRepository.save(tache);
    }


}
