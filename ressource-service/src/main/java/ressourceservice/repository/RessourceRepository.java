package ressourceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ressourceservice.model.Ressource;

import java.util.List;

public interface RessourceRepository extends JpaRepository<Ressource, Long> {
    List<Ressource> findByIdTache(int idTache);
}
