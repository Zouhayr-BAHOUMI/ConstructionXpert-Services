package projetservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetservice.model.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
}
