/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Negocio.Servidor;

/**
 *
 * @author eduardo
 */
public interface ISender {
    void  setServidor(Servidor servidor);
   void enviarCorreo(String para, String asunto, String msg) throws Exception;
}
