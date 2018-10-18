/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author eduardo
 */
public class prueba {
    public static void main(String[] args) throws Exception{
        File file = new File("APIconfig.conf");
        BufferedReader br;
        String st;
        try {
            br = new BufferedReader(new FileReader(file));
        st= br.readLine();
            System.out.println(st);
        }catch (IOException ex ) {
            throw new Exception("Ocurrió un problema al procesar los datos de configuración de la API");
        }
      
    }
}
