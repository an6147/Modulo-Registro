package git.test.an.TestSpring.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

import lombok.Data;

@Data
@Entity
public class Persona implements Serializable{
   
   private static final long serialVersionUID = 1L;
   
   @Id  
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   private Long persons_pkey;
   
   @NotEmpty
   private String namee;
   
   @NotEmpty
   private String last_name;
   
   @NotEmpty
   @Email
   private String email;
   
   @NotEmpty
   private String tlf;
   
   @NotNull
   private Double saldo;
}
