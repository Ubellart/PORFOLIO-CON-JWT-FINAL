
package Backend.Porfolio.Controllers;

import Backend.Porfolio.Models.Datos;
import Backend.Porfolio.Services.datosServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/datos")
@CrossOrigin(origins ={"https://porfolio-con-jwt-final-production.up.railway.app","http://localhost:4200"})
public class datosController {
    @Autowired
    datosServiceImpl datosService;
    
    
    
    /// metodos
    @GetMapping("/lista")

    public List<Datos> listar() {
        
        

        return datosService.listar();
    }

    @PostMapping("/crear")
    public void crear(@RequestBody Datos datos) {
        datosService.crear(datos);

    }

    @GetMapping("/buscar/{id}")
    public Optional<Datos> buscar(@PathVariable long id) {

        return datosService.buscar(id);

    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable long id) {

        datosService.eliminar(id);
    }

    @PutMapping("/modificar")

    public void modificar(@RequestBody Datos datos) {
        datosService.modificar(datos);
    }

}
