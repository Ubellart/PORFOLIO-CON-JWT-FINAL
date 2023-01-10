/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Backend.Porfolio.Services;

import java.util.List;
import org.w3c.dom.Entity;

/**
 *
 * @author victo
 */
public interface iService {
    
     public List< Entity > listar();
    
    public Entity crear(Entity entity);
    
    public void eliminar(long id);
    
    public Entity buscar (long id);
    
    public Entity modificar (long id);
    
}
