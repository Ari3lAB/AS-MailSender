/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Eduardo Ramírez
 */
public class Servidor {
    private String server;
    private Cuenta cuenta;
    private String protocolo;
    private short puerto;
    public Servidor(String server, Cuenta cuenta, String protocolo, short puerto){
        this.server= server;
        this.cuenta = new Cuenta(cuenta);
        this.protocolo = protocolo;
        this.server = server;
    }
    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public short getPuerto() {
        return puerto;
    }

    public void setPuerto(short puerto) {
        this.puerto = puerto;
    }
    
    
}
