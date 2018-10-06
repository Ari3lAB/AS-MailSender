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
public class Cuenta {
    private String correo;
    private String pass;
    public Cuenta(String correo, String pass){
        this.correo= correo;
        this.pass = pass;
    }
    public Cuenta(Cuenta cuenta){
        this.correo = cuenta.getCorreo();
        this.pass = cuenta.getPass();
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPass() {
        return pass;
    }
    
}
