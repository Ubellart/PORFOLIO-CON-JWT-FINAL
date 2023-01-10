package Backend.Porfolio.Models;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "datos")
public class Datos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "titulo")
    private String titulo;

    @Lob
    @Column(name = "img_fondo")
    private String img_fondo;
    
    @Lob
    @Column(name = "img_perfil")
    private String img_perfil;

 



    
}
