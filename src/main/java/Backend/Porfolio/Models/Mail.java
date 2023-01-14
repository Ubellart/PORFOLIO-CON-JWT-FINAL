/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Models;

/**
 *
 * @author victo
 */
public class Mail {
    
    private String emailDe ;
    
    private String asunto ;
    
    private String mensaje ;

    public Mail(String emailDe, String asunto, String mensaje) {
        this.emailDe = emailDe;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public String getEmailDe() {
        return emailDe;
    }

    public void setEmailDe(String emailDe) {
        this.emailDe = emailDe;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}
