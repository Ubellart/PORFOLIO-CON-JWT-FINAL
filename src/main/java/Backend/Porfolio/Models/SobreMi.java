package Backend.Porfolio.Models;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor


@Entity
@Table(name = "sobre_mi")
public class SobreMi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;
    
    @Lob
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    
    @Lob
    @Column(name = "url_cv", nullable = false)
    private String url_cv;

    @Lob
    @Column(name = "url_foto", nullable = false)
    private String url_foto;

    

    

    public SobreMi() {
    }
}
