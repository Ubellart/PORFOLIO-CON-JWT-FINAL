/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Controllers;

import Backend.Porfolio.Models.Trabajo;
import Backend.Porfolio.Services.trabajoServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trabajo")
@CrossOrigin(origins = "http://localhost:4200")
public class trabajoController {

    @Autowired
    trabajoServiceImpl trabajoService;

    /// metodos
    @GetMapping("/lista")

    public List<Trabajo> listar() {

        return trabajoService.listar();
    }

    @PostMapping("/crear")
    public void crear(@RequestBody Trabajo trabajo) {
        trabajoService.crear(trabajo);

    }

    @GetMapping("/buscar/{id}")
    public Optional<Trabajo> buscar(@PathVariable long id) {

        return trabajoService.buscar(id);

    }
    
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable long id) {

        trabajoService.eliminar(id);
    }

    @PutMapping("/modificar")

    public void modificar(@RequestBody Trabajo trabajo) {
        trabajoService.modificar(trabajo);
    }

}
