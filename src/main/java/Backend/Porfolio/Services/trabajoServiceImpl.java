/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Services;

import Backend.Porfolio.Models.Trabajo;
import Backend.Porfolio.Repositories.trabajoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class trabajoServiceImpl {

    @Autowired
    trabajoRepository trabajorepository;

    public List<Trabajo> listar() {

        return trabajorepository.findAll();
    }

    public Trabajo crear(Trabajo trabajo) {

        return trabajorepository.save(trabajo);

    }

    public void eliminar(long id) {

        trabajorepository.deleteById(id);
    }

    public Optional<Trabajo> buscar(long id) {

        return trabajorepository.findById(id);

    }

    public Trabajo modificar(Trabajo trabajo) {

        return trabajorepository.save(trabajo);

    }
    
    

}
