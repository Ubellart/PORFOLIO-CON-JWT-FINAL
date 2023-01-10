
package Backend.Porfolio.Models;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "estudios")
public class Estudio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "institucion", nullable = false)
    private String institucion;
    
    @Lob   
    @Column(name = "img_insti")
    private String img_insti;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "fecha_egre", nullable = false)
    private String fecha_egre;

 
}
