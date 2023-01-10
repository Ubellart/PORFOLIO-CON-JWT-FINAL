/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Services;

import Backend.Porfolio.Models.Estudio;
import Backend.Porfolio.Repositories.estudioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class estudioServiceImpl  {

     @Autowired
     estudioRepository estudiorepository;
    
    
     public List<Estudio> listar() {

        return estudiorepository.findAll();
    }

    public Estudio crear(Estudio estudio) {

        return estudiorepository.save(estudio);

    }

    public void eliminar(long id) {

        estudiorepository.deleteById(id);
    }

    public Optional<Estudio> buscar(long id) {

        return estudiorepository.findById(id);

    }

    public Estudio modificar(Estudio estudio) {

        return estudiorepository.save(estudio);

    }
}
