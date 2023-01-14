/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Controllers;

import Backend.Porfolio.Models.Mail;
import Backend.Porfolio.Services.emailService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

@RequestMapping("/auth")
@CrossOrigin(origins ={"https://porfolio-ublellart.web.app","http://localhost:4200"})
public class emailController {
    
 @Autowired
   private emailService emailService;
 
 
  @PostMapping("/email")
    
    public void enviar(@RequestBody Mail mail){
   
    emailService.enviarCorreo(mail);
    
    
    }



 
 
 
 
 
 
}
