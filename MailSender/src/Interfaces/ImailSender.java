/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Negocio.Servidor;

/**
 *
 * @author Ariel AB
 */
public interface ImailSender {
    void setServidor(Servidor servidor);
    void enviarCorreo(String Para, String Msg);
}
