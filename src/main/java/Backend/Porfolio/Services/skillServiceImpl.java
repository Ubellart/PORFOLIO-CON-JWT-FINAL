/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Services;

import Backend.Porfolio.Models.Skill;
import Backend.Porfolio.Repositories.skillRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class skillServiceImpl  {

     @Autowired
     skillRepository skillrepository;
    
    
    public List<Skill> listar() {

        return skillrepository.findAll();
    }

    public Skill crear(Skill skill) {

        return skillrepository.save(skill);

    }

    public void eliminar(long id) {

        skillrepository.deleteById(id);
    }

    public Optional<Skill> buscar(long id) {

        return skillrepository.findById(id);

    }

    public Skill modificar(Skill skill) {

        return skillrepository.save(skill);

    }
}
