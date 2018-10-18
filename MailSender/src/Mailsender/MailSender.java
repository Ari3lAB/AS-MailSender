
package Mailsender;

import Datos.AccesoDatos;
import Interfaces.ISender;
import Interfaces.ImailSender;
import Negocio.Servidor;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author eduardo
 */
public class MailSender extends UnicastRemoteObject implements ImailSender{
    Servidor serv;
private ExtensionLoader<ISender> loader = new ExtensionLoader<>();
ISender senderAPI;
private static final long serialVersionUID = 1L;

    protected MailSender() throws RemoteException {

        super();

    }
    @Override
    public void setServidor(Servidor servidor) throws RemoteException{
    serv = new Servidor(servidor);
    }

    @Override
    public void enviarCorreo(String para, String asunto, String msg) throws RemoteException{
         
    loader = new ExtensionLoader<>();
    
     try {
          String nombre = AccesoDatos.getApi();
        senderAPI = loader.LoadClass(nombre,"senderAPI.Sender", ISender.class);
        senderAPI.setServidor(serv);
        senderAPI.enviarCorreo(para, asunto, msg);
    } catch (ClassNotFoundException ex) {
        throw new RemoteException("Podría haber un error de configuración con la API.");
    }catch(Exception ex){
         throw new RemoteException("Podría haber un error de configuración con la API.");
    } 
    }

    @Override
    public ArrayList<Servidor> getServidores() throws RemoteException{
        try {
            return AccesoDatos.getServidores();
        } catch (Exception ex) {
           throw new RemoteException("Asegurese de que los servidores se configuraron correctamente.");
        }
    }
     public static void main(String[] args) throws RemoteException{

        try {

            Naming.rebind("//localhost/MailSender", new MailSender());            
            System.err.println("!MailSender listo¡");

        } catch (Exception e) {

            System.err.println("Error en el servidor: " + e.toString());
            

        }

    }
}

   
