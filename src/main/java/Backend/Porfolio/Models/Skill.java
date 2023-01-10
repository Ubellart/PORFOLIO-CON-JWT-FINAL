
package Backend.Porfolio.Models;

import javax.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "tecnologia", nullable = false)
    private String tecnologia;
    
    @Column(name = "porcentaje", nullable = false)
    private int porcentaje;
    
    @Lob 
    @Column(name = "logo")
    private String logo;
    
    @Column(name = "color")
    private String color;
    
    
    
    
    

}
