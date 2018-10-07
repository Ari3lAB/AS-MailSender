
package Interfaces;

import Negocio.Servidor;
import java.util.ArrayList;

/**
 *
 * @author Ariel AB
 */
public interface ImailSender {
   void  setServidor(Servidor servidor);
   boolean enviarCorreo(String para, String asunto, String msg);
   ArrayList<Servidor> getServidores();
}
