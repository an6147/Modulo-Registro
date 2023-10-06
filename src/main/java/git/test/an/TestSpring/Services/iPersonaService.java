
package git.test.an.TestSpring.Services;

import git.test.an.TestSpring.domain.Persona;
import java.util.List;


public interface iPersonaService {
    
    public List<Persona> listaPersona();
    
    public void guardar (Persona persona);
    
    public void eliminar(Persona persona);
    
    public Persona encontrarPersona(Persona persona);
 
}
