package git.test.an.TestSpring.DAO;

import git.test.an.TestSpring.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iUsuarioDAO extends JpaRepository<Usuario, Long>{
    
    Usuario findByUsername(String username);
    
 
}
