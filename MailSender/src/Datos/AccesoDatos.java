/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Negocio.Cuenta;
import Negocio.Servidor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo Ramírez
 */
public class AccesoDatos {
    public static ArrayList<Servidor> getServidores() throws Exception {
        
        ArrayList<Servidor> servers = new  ArrayList<>();
        File file = new File("config.conf");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
        String st;     
            while ((st = br.readLine()) != null) {
                List<String> lineaDividida = Arrays.asList(st.split(","));
                int pppp = Integer.parseInt(lineaDividida.get(4));
            Cuenta cuenta = new Cuenta(lineaDividida.get(1),lineaDividida.get(2));
                Servidor ser = new Servidor(lineaDividida.get(0),
                cuenta, lineaDividida.get(3), 587, lineaDividida.get(5));
                servers.add(ser);                                        
        }
        }catch (IOException ex ) {
            throw new Exception("Ocurrió un problema al procesar los datos de configuración de los servidores.");
        }
        return servers;
    }
    public static String getApi() throws Exception {
        
        
        File file = new File("APIconfig.conf");
        BufferedReader br;
        String st;
        try {
            br = new BufferedReader(new FileReader(file));
        st= br.readLine();     
        }catch (IOException ex ) {
            throw new Exception("Ocurrió un problema al procesar los datos de configuración de la API");
        }
      return st;
    }
}


