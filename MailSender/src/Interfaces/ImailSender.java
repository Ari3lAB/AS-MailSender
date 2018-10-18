
package Interfaces;

import Negocio.Servidor;
import java.rmi.Remote;
import java.util.ArrayList;

/**
 *
 * @author Ariel AB
 */
public interface ImailSender extends Remote {
   void  setServidor(Servidor servidor);
   void enviarCorreo(String para, String asunto, String msg) throws Exception;
   ArrayList<Servidor> getServidores();
}
