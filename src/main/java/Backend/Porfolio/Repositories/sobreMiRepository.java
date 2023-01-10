/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Backend.Porfolio.Repositories;

import Backend.Porfolio.Models.SobreMi;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author victo
 */
@Repository
public interface sobreMiRepository extends JpaRepository<SobreMi, Long> {


    
  
}