
package Mailsender;

import Datos.AccesoDatos;
import Interfaces.ISender;
import Interfaces.ImailSender;
import Negocio.Servidor;
import java.util.ArrayList;
/**
 *
 * @author eduardo
 */
public class MailSender implements ImailSender{
    Servidor serv;
private ExtensionLoader<ISender> loader = new ExtensionLoader<>();
ISender senderAPI;


    @Override
    public void setServidor(Servidor servidor) {
    serv = new Servidor(servidor);
    }

    @Override
    public void enviarCorreo(String para, String asunto, String msg) throws Exception {
         
    loader = new ExtensionLoader<>();
    String nombre = AccesoDatos.getApi();
     try {
        senderAPI = loader.LoadClass(nombre,"senderAPI.Sender", ISender.class);
        senderAPI.setServidor(serv);
        senderAPI.enviarCorreo(para, asunto, msg);
    } catch (ClassNotFoundException ex) {
        throw new Exception("Podría haber un error de configuración con la API.");
    }catch(Exception ex){
         throw new Exception("Podría haber un error de configuración con la API.");
    } 
    }

    @Override
    public ArrayList<Servidor> getServidores() throws Exception{
        return AccesoDatos.getServidores();
    }
}

   
