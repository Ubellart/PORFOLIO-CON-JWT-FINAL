/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Controllers;

import Backend.Porfolio.Models.Estudio;
import Backend.Porfolio.Services.estudioServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudio")
@CrossOrigin(origins ={"https://porfolio-con-jwt-final-production.up.railway.app","http://localhost:4200"})
public class estudioController {
    
    
    @Autowired
    estudioServiceImpl estudioService;
    
    /// metodos
    @GetMapping("/lista")

    public List<Estudio> listar() {

        return estudioService.listar();
    }
    
    @PostMapping("/crear")
    @CrossOrigin(origins = "http://localhost:4200")
    public void crear(@RequestBody Estudio estudio) {
        estudioService.crear(estudio);
        System. out. println("se creo un estudio");

    }

    @GetMapping("/buscar/{id}")
    public Optional<Estudio> buscar(@PathVariable long id) {

        return estudioService.buscar(id);

    }
   
    
    @DeleteMapping("/eliminar/{id}")
     @CrossOrigin(origins = "http://localhost:4200")
    public void eliminar(@PathVariable long id) {

        estudioService.eliminar(id);
    }

    @PutMapping("/modificar")

    public void modificar(@RequestBody Estudio estudio) {
        estudioService.modificar(estudio);
    }

    
}
