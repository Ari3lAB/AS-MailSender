
package Mailsender;

import Datos.AccesoDatos;
import Interfaces.ISender;
import Interfaces.ImailSender;
import Negocio.Servidor;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
/**
 *
 * @author eduardo
 */
public class MailSender extends UnicastRemoteObject implements ImailSender{
    Servidor serv;
private ExtensionLoader<ISender> loader = new ExtensionLoader<>();
ISender senderAPI;
public MailSender(){
    
}
public static void main(String[] args){
		try {
			Naming.rebind("//localhost/MailSender", new MailSender());            
            System.err.println("Servidor MailSender listo!");
            
        } catch (Exception e) {
        	System.err.println("Error en el servidor: " + e.toString());
          e.printStackTrace();
        }
	}
    @Override
    public void setServidor(Servidor servidor) {
    serv = new Servidor(servidor);
    }

    @Override
    public void enviarCorreo(String para, String asunto, String msg) throws Exception {
         
    loader = new ExtensionLoader<>();
     try {
        senderAPI = loader.LoadClass("senderAPI.Sender", ISender.class);
        senderAPI.setServidor(serv);
        senderAPI.enviarCorreo(para, asunto, msg);
    } catch (ClassNotFoundException ex) {
        throw new Exception("Podría haber un error de configuración con la API.");
    }catch(Exception ex){
         throw new Exception("Asegurese de que la configuración del servidor es correcta.");
    } 
    }

    @Override
    public ArrayList<Servidor> getServidores() {
        return AccesoDatos.getServidores();
    }
}

   
