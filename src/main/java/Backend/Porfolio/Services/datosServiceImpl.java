/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Services;

import Backend.Porfolio.Models.Datos;
import Backend.Porfolio.Repositories.datosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class datosServiceImpl {
    
    @Autowired
     datosRepository datosrepository;

     public List<Datos> listar() {

        return datosrepository.findAll();
    }

    public Datos crear(Datos datos) {

        return datosrepository.save(datos);

    }

    public void eliminar(long id) {

        datosrepository.deleteById(id);
    }

    public Optional<Datos> buscar(long id) {

        return datosrepository.findById(id);

    }

    public Datos modificar(Datos datos) {

        return datosrepository.save(datos);

    }
}
