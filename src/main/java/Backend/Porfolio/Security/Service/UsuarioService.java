/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Security.Service;

import Backend.Porfolio.Security.Entity.Usuario;
import Backend.Porfolio.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
@Transactional

public class UsuarioService {
    
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
    
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    
    public boolean existsByNombreUsuario(String nombreUsuario){
    
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    
//     public boolean existsByEmail(String email){
//    
//        return iusuarioRepository.existsByEmail(email);
//    }
    
     public void save(Usuario usuario){
     iusuarioRepository.save(usuario);
     }
     
     public void borrar(int id){
         iusuarioRepository.deleteById(id);
     }
}
