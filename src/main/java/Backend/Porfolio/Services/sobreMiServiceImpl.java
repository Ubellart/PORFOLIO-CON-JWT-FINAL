
package Backend.Porfolio.Services;



import Backend.Porfolio.Models.Datos;
import Backend.Porfolio.Models.SobreMi;
import Backend.Porfolio.Repositories.sobreMiRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class sobreMiServiceImpl {
    @Autowired
     sobreMiRepository sobreMiRepo;

     public List<SobreMi> listar() {

        return sobreMiRepo.findAll();
    }

    public SobreMi crear(SobreMi datos) {

        return sobreMiRepo.save(datos);

    }

    public void eliminar(long id) {

        sobreMiRepo.deleteById(id);
    }

    public Optional<SobreMi> buscar(long id) {

        return sobreMiRepo.findById(id);

    }

    public SobreMi modificar(SobreMi datos) {

        return sobreMiRepo.save(datos);

    }

    
    
    
    
    
}
