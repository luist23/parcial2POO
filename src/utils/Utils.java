/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author LuisT23
 */
public class Utils {
    private static Utils util;
    private Utils(){}
    public static Utils getInstance(){
        if (util == null)
            util=new Utils();
        return util;
    }
    /**
     * Validar pedido de un numero con mensaje personalizado
     * @param mensaje
     * @return 
     */
    
    
    public static int pedirEntero(String mensaje){
        int opcion = 0;
        Scanner leer = new Scanner(System.in);
        while(true) {
         try {
             System.out.println(mensaje);
        opcion = leer.nextInt();
        break;
        
        } catch (InputMismatchException e) {
                System.err.println("no ingreso un numero valido, vuelva a intentarlo");
                leer.nextLine();}}
        return opcion;
    }
    
    
    public static int pedirEntero(String mensaje,int menor,int mayor){
        int opcion = 0;
        Scanner leer = new Scanner(System.in);
        while(true) {
         try {
             System.out.println(mensaje);
        opcion = leer.nextInt();
        if (opcion<=mayor && opcion>=menor)
            return opcion;
        else{
            System.out.println("el numero seleccionado no es valido");
        }
        
        } catch (InputMismatchException e) {
                System.err.println("no ingreso un numero valido, vuelva a intentarlo");
                leer.nextLine();}
        
        }
        
        
    }
    
    
    public static int pedirEntero(){
        int opcion = 0;
        Scanner leer = new Scanner(System.in);
        while(true) {
         try {
        opcion = leer.nextInt();
        break;
        
        } catch (InputMismatchException e) {
                System.err.println("no ingreso un numero valido, vuelva a intentarlo");
                leer.nextLine();}}
        return opcion;
    }
    
    
    
    
    public static void clear(){
        for (int i=0;i<50;i++)
            System.out.println("");
    }
    
    
    public static void stop(){
        System.out.println("precione una 'ENTER' para continuar");
            Scanner leer=new Scanner(System.in);
            leer.nextLine();
    }
    
    public static double aleatorio(){
        //double azar=1;
        double[] azar={0,0.25,0.50,0.75,1};
        int aleatorio=(int)(Math.random()*4);
        
        return azar[aleatorio];
    }
}
