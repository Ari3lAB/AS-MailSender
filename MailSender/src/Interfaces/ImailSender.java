
package Interfaces;

import Negocio.Servidor;
import java.util.ArrayList;

/**
 *
 * @author Ariel AB
 */
public interface ImailSender {
   void  setServidor(Servidor servidor);
   void enviarCorreo(String para, String asunto, String msg) throws Exception;
   ArrayList<Servidor> getServidores() throws Exception;
}
