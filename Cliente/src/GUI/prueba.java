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
        String nombre="SenderAPI.jar";
         File jar = new File(/*System.getProperty("user.dir") + File.separator +*/ "API" + File.separator + nombre);
        System.out.println(jar.getAbsoluteFile());
      
    }
}
