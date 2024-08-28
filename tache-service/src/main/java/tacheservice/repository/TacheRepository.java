package tacheservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tacheservice.model.Tache;

public interface TacheRepository extends JpaRepository<Tache, Long> {
}
