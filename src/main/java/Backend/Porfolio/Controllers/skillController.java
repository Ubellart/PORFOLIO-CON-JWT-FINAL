/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Controllers;

import Backend.Porfolio.Models.Skill;
import Backend.Porfolio.Services.skillServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins ={"https://porfolio-con-jwt-final-production.up.railway.app","http://localhost:4200"})
public class skillController {
    
    @Autowired
    skillServiceImpl skillService;
    
    /// metodos
    
// @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/lista")

    public List<Skill> listar() {

        return skillService.listar();
    }

    @PostMapping("/crear")
     @CrossOrigin(origins = "http://localhost:4200")
    public void crear(@RequestBody Skill skill) {
        skillService.crear(skill);
        

    }

    @GetMapping("/buscar/{id}")
    public Optional<Skill> buscar(@PathVariable long id) {

        return skillService.buscar(id);

    }
    
    
  
    @DeleteMapping("/eliminar/{id}")
     @CrossOrigin(origins = "http://localhost:4200")
    public void eliminar(@PathVariable long id) {

        skillService.eliminar(id);
    }

    @PutMapping("/modificar")
     @CrossOrigin(origins = "http://localhost:4200")

    public void modificar(@RequestBody Skill skill) {
        skillService.modificar(skill);
    }

    
    
}
