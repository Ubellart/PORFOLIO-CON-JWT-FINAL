/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Controllers;

import Backend.Porfolio.Models.Datos;
import Backend.Porfolio.Models.SobreMi;
import Backend.Porfolio.Services.sobreMiServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author victo
 */

@RestController
@RequestMapping("/sobreMi")
@CrossOrigin(origins ={"https://porfolio-con-jwt-final-production.up.railway.app","http://localhost:4200"})
public class sobreMiController {
    
    @Autowired
    sobreMiServiceImpl sobreMiService;
    
    
     /// metodos
    @GetMapping("/lista")

    public List<SobreMi> listar() {
        
        

        return sobreMiService.listar();
    }

    @PostMapping("/crear")
    public void crear(@RequestBody SobreMi datos) {
        sobreMiService.crear(datos);

    }

    @GetMapping("/buscar/{id}")
    public Optional<SobreMi> buscar(@PathVariable long id) {

        return sobreMiService.buscar(id);

    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable long id) {

        sobreMiService.eliminar(id);
    }

    @PutMapping("/modificar")

    public void modificar(@RequestBody SobreMi datos) {
        sobreMiService.modificar(datos);
    }

    
    
    
}
