/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mailsender;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ExtensionLoader<C> {

    public C LoadClass(String nombre, String classpath, Class<C> parentClass) throws ClassNotFoundException {
        File jar = new File(/*System.getProperty("user.dir") + File.separator +*/ "API" + File.separator + nombre);

        try {
            ClassLoader loader = URLClassLoader.newInstance(
                    new URL[]{jar.toURL()},
                    getClass().getClassLoader()
            );
            Class<?> clazz = Class.forName(classpath, true, loader);
            Class<? extends C> newClass = clazz.asSubclass(parentClass);
            // Apparently its bad to use Class.newInstance, so we use 
            // newClass.getConstructor() instead
            Constructor<? extends C> constructor = newClass.getConstructor();
            return constructor.newInstance();

        } catch (ClassNotFoundException e) {
            // There might be multiple JARs in the directory,
            // so keep looking

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        throw new ClassNotFoundException("La clase" + classpath
                + " no se encontró en el directorio " + System.getProperty("user.dir"));
    }
}
