/*
 * Esta es la clase que se encarga de implementar ImailSender y usa la API javaMail. 
 */
package mailsender;

import Datos.AccesoDatos;
import Interfaces.ImailSender;
import Negocio.Servidor;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Eduardo Ramírez
 */
public class MailSenderImpl implements ImailSender{
private  Servidor servidor;
    @Override
    public void setServidor(Servidor servidor) {
         this.servidor = new Servidor(servidor);
    }

    @Override
    public void enviarCorreo(String para, String asunto, String msg) {
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", servidor.getServer());
      props.put("mail.smtp.port", ""+servidor.getPuerto());

      
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(servidor.getCuenta().getCorreo(), servidor.getCuenta().getPass());
         }
      });

      try {
         
         Message message = new MimeMessage(session);

        
         message.setFrom(new InternetAddress(servidor.getCuenta().getCorreo()));

         
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(para));

         message.setSubject(asunto);

       
         message.setText(msg);

        
         Transport.send(message);

         System.out.println("¡Correo enviado!");

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
    }

    @Override
    public ArrayList<Servidor> getServidores() {
        return AccesoDatos.getServidores();
    }

    
}
