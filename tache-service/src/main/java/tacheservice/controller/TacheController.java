package tacheservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacheservice.model.Tache;
import tacheservice.service.TacheService;

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

}
