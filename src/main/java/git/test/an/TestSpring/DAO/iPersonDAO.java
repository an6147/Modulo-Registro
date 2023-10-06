package git.test.an.TestSpring.DAO;

import git.test.an.TestSpring.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iPersonDAO extends JpaRepository<Persona, Long>{
    
}
