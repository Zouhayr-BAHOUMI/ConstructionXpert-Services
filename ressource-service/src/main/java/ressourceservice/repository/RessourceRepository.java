package ressourceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ressourceservice.model.Ressource;

public interface RessourceRepository extends JpaRepository<Ressource, Long> {
}
