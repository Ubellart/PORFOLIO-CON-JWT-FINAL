/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Services;

import Backend.Porfolio.Models.Contacto;

import Backend.Porfolio.Repositories.ContactoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class contactoService  {
    @Autowired
    ContactoRepository contactoRepository;
    
    public List<Contacto> listar() {

        return contactoRepository.findAll();
    }

    public Contacto crear(Contacto contacto) {

        return contactoRepository.save(contacto);

    }

    public void eliminar(long id) {

        contactoRepository.deleteById(id);
    }

    public Optional<Contacto> buscar(long id) {

        return contactoRepository.findById(id);

    }

    public Contacto modificar(Contacto contacto) {

        return contactoRepository.save(contacto);

    }
    
}
