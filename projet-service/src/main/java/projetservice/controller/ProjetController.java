package projetservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetservice.model.Projet;
import projetservice.service.ProjetService;

import java.util.List;

@RestController
@RequestMapping("/projets")
public class ProjetController {

    @Autowired
    private ProjetService projetService;

    @PostMapping("/add")
    public ResponseEntity<String> ajouterProjet(@RequestBody Projet projet){
        try {
            projetService.addProjet(projet);
            return ResponseEntity.status(HttpStatus.CREATED).body("created successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not created" + e.getMessage());
        }
    }

    @GetMapping("/")
    public List<Projet> getAllProjets() {
        return projetService.getAllProjets();
    }

    @GetMapping("/idprojet")
    public Projet showsProjetById(@RequestParam Long idprojet){
        Projet projet = projetService.getProjet(idprojet);
        return projet;
    }

    @PutMapping("/update/{idprojet}")
    public ResponseEntity<Void> modifierProjet(@PathVariable int idprojet, @RequestBody Projet projet){
        projetService.updateProjet(idprojet, projet);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{idprojet}")
    public ResponseEntity<Void>  supprimerProjet(@PathVariable Long  idprojet){
        projetService.deleteProjet(idprojet);
        return ResponseEntity.noContent().build();
    }
}
