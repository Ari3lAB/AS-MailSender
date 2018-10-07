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
    private int puerto;
    private String descripcion;
    public Servidor(){
        
    }
    public Servidor(Servidor servidor){
        this.server = servidor.getServer();
        this.cuenta = new Cuenta(servidor.getCuenta());
        this.protocolo = servidor.getProtocolo();
        this.puerto = servidor.getPuerto();
        this.descripcion = servidor.getDescripcion();
    }
    public Servidor(String server, Cuenta cuenta, String protocolo, int puerto, String descripcion){
        this.server= server;
        this.cuenta = new Cuenta(cuenta);
        this.protocolo = protocolo;
        this.puerto = puerto;
        this.descripcion = descripcion;
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

    public int getPuerto() {
        return this.puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString(){
        return this.descripcion;
    }
    
}
