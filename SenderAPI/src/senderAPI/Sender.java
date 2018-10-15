package senderAPI;

import Interfaces.ISender;
import Negocio.Servidor;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Sender implements ISender{

    private Servidor servidor;
    @Override
    public void setServidor(Servidor servidor) {
        this.servidor = new Servidor(servidor);
    }
    @Override
    public void enviarCorreo(String para, String asunto, String msg) throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", servidor.getServer());
        props.put("mail.smtp.port", "" + servidor.getPuerto());
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(servidor.getCuenta().getCorreo(), servidor.getCuenta().getPass());
            }
        });
        
            Message message = new MimeMessage(session);
            try{
            message.setFrom(new InternetAddress(servidor.getCuenta().getCorreo()));
            message.setRecipients(Message.RecipientType.TO,
                   InternetAddress.parse(para));
            message.setSubject(asunto);
            message.setText(msg);
            Transport.send(message);
            }
            catch(AddressException ex){
               throw new Exception("Por favor, asegurese de que los datos introducidos sean correctos.");
            }
            
            
       
    }

    
}
