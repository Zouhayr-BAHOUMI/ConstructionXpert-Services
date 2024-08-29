package ressourceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ressourceservice.model.Ressource;
import ressourceservice.service.RessourceService;

import java.util.List;


@RestController
@RequestMapping("/ressources")
public class RessourceController {

    @Autowired
    private RessourceService ressourceService;

    @PostMapping("/add/{idTache}")
    public ResponseEntity<String> ajouterRessource(@RequestBody Ressource ressource, @PathVariable int idTache){
        try {
            ressourceService.addRessource(ressource,idTache);
            return ResponseEntity.status(HttpStatus.CREATED).body("created successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not created" + e.getMessage());
        }
    }

    @GetMapping("/")
    public List<Ressource> getAllRessource() {
        return ressourceService.getAllRessources();
    }

    @GetMapping("/idRessource")
    public Ressource showsTacheById(@RequestParam Long idRessource){
        Ressource ressource = ressourceService.getRessource(idRessource);
        return ressource;
    }

    @GetMapping("/tache/idTache")
    public List<Ressource> showsRessourcesByTache(@RequestParam int idTache){
        return ressourceService.getRessourcesByTache(idTache);
    }

    @PutMapping("/update/{idRessource}")
    public ResponseEntity<Void> modifierRessource(@PathVariable int idRessource, @RequestBody Ressource ressource){
        ressourceService.updateRessource(idRessource, ressource);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{idRessource}")
    public ResponseEntity<Void>  supprimerRessource(@PathVariable Long  idRessource){
        ressourceService.deleteRessource(idRessource);
        return ResponseEntity.noContent().build();
    }
}
