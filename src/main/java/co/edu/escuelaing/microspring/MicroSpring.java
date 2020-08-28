/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.microspring;

import co.edu.escuelaing.httpserver.URIProcessor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manolo
 */
public class MicroSpring implements URIProcessor{
    
    
    Map<String, Method> webservices = new HashMap<>();

    public void mapService(String args) throws Exception {

        int nMethods = 0;

        for (Method m : Class.forName(args).getMethods()) {

            if (m.isAnnotationPresent(RequestMapping.class)) {

                    RequestMapping rm = m.getAnnotation(RequestMapping.class);
                    webservices.put(rm.value(), m);

                    nMethods++;

            }
        }

        System.out.printf("Passed: %d", nMethods);

    }
    public String executeService(String theuri){
        try {
            return webservices.get(theuri).invoke(null).toString();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MicroSpring.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(MicroSpring.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(MicroSpring.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error";
    }

}
