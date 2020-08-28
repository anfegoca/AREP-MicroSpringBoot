/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.microspring.componenttests;

import co.edu.escuelaing.microspring.RequestMapping;

/**
 *
 * @author Manolo
 */
public class HelloController {
    @RequestMapping("/hello")
    public static String greetings(){
        return "Greetings from SpringBoot";
    }
    @RequestMapping("/pi")
    public static String theValueOfPi(){
        return "PI: "+Math.PI;
    }
    
}
