
package Interfaces;

import Negocio.Servidor;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ariel AB
 */
public interface ImailSender extends Remote {
   void  setServidor(Servidor servidor) throws RemoteException;
   void enviarCorreo(String para, String asunto, String msg) throws RemoteException;
   ArrayList<Servidor> getServidores() throws RemoteException;
}
