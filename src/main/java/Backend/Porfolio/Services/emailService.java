/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Services;

import Backend.Porfolio.Models.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class emailService {
    
    
    @Autowired
    private JavaMailSender emailSender;

    public void enviarCorreo(Mail mail) {
        
        SimpleMailMessage email = new SimpleMailMessage(); 
        email.setFrom("victor.ubellart@gmail.com");
        email.setTo("victor.ubellart@gmail.com"); 
        email.setSubject( mail.getEmailDe()+ " Asunto: " +mail.getAsunto() ); 
        email.setText(mail.getMensaje());
        emailSender.send(email);
       
    }
    
    
    
    
}
