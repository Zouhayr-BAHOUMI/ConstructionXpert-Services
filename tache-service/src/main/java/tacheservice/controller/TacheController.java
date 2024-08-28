package tacheservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacheservice.model.Tache;
import tacheservice.service.TacheService;

import java.util.List;

@RestController
@RequestMapping("/taches")
public class TacheController {

    @Autowired
    private TacheService tacheService;

    @PostMapping("/add/{idProjet}")
    public ResponseEntity<String> ajouterProjet(@RequestBody Tache tache,@PathVariable int idProjet){
        try {
            tacheService.addTache(tache, idProjet);
            return ResponseEntity.status(HttpStatus.CREATED).body("created successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not created" + e.getMessage());
        }
    }

    @GetMapping("/")
    public List<Tache> getAllTaches() {
        return tacheService.getAllTaches();
    }

    @GetMapping("/idTache")
    public Tache showsTacheById(@RequestParam Long idTache){
        Tache tache = tacheService.getTache(idTache);
        return tache;
    }

    @GetMapping("/projet/idProjet")
    public List<Tache> showsTachesByProjet(@RequestParam int idProjet){
        return tacheService.getTachesByProjet(idProjet);
    }

    @PutMapping("/update/{idTache}")
    public ResponseEntity<Void> modifierTache(@PathVariable int idTache, @RequestBody Tache tache){
        tacheService.updateTache(idTache, tache);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{idTache}")
    public ResponseEntity<Void>  supprimerTache(@PathVariable Long  idTache){
        tacheService.deleteTache(idTache);
        return ResponseEntity.noContent().build();
    }

}
