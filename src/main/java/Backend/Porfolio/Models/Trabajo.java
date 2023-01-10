
package Backend.Porfolio.Models;

import javax.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "trabajos")
public class Trabajo {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
   
   @Column(name = "empresa", nullable = false)
    private String empresa;
   
   @Column(name = "proyecto")
    private String proyecto;
   
   @Lob
   @Column(name = "img_url")
    private String img_url;
   
   @Lob 
    @Column(name = "descripcion")
    private String descripcion;
   
    @Lob 
    @Column(name = "link_proyecto")
    private String link_proyecto;
    
   @Column(name = "fecha_inicio")
    private String fecha_inicio;
   
   @Column(name = "fecha_fin")
    private String fecha_fin;
   
   
   
  
   
   
  
}
