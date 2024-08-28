package tacheservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tacheservice.model.Tache;

import java.util.List;

public interface TacheRepository extends JpaRepository<Tache, Long> {
    List<Tache> findByIdProjet(int idProjet);
}
