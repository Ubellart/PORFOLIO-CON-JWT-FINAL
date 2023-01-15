/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Controllers;

import Backend.Porfolio.Models.Contacto;

import Backend.Porfolio.Services.contactoService;
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
@RequestMapping("/contacto")
@CrossOrigin(origins ={"https://victor-ubellart.web.app/","http://localhost:4200"})

public class contactoController {
    
@Autowired 
contactoService contactoService;
    
 /// metodos
    @GetMapping("/lista")

    public List<Contacto> listar() {

        return contactoService.listar();
    }
    
    @PostMapping("/crear")
    @CrossOrigin(origins = "http://localhost:4200")
    public void crear(@RequestBody Contacto contacto) {
        contactoService.crear(contacto);
        System. out. println("se creo un nuevo contacto");

    }

    @GetMapping("/buscar/{id}")
        public Optional<Contacto> buscar(@PathVariable long id) {

        return contactoService.buscar(id);

    }
   
    
    @DeleteMapping("/eliminar/{id}")
     @CrossOrigin(origins = "http://localhost:4200")
    public void eliminar(@PathVariable long id) {

        contactoService.eliminar(id);
    }

    @PutMapping("/modificar")

    public void modificar(@RequestBody Contacto contacto) {
        contactoService.modificar(contacto);
    }





}
