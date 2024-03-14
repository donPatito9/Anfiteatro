/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anfiteatro;

import java.util.Scanner;

/**
 *
 * @author RobinsonConcha
 * Caso Anfiteatro : 
 * Suponer un sistema de reserva de asientos para un anfiteatro.
 * El teatro cuenta con 10 filas de 10 asientos cada una. Se necesita desarrollar
 * un sistema sin uso de base de datos, únicamente de forma lógica  que permita 
 * llevar a cabo lo siguiente:
 * - Cargar el mapa de las filas y asientos, indicando con una X los asientos ocupados
 * y con una L los asientos libres, al iniciar el programa todos los asientos deben 
 * estar libres.
 * 
 * - Manejar la reserva de asientos contemplando que un asiento solo puede ser reservado
 * si se encuentra en estao L, en caso que se encuentre en estado X, se debera permitir 
 * al comprador elegir otro asiento, si se encuentra en estado L debera pasar
 * automaticamente a estado X.
 * 
 * - Para finalizar el programa se debera ingresar un valor en particular, contemplar que
 * no existe una cantidad exacta de veces que el programa se pueda ejecutar.
 * 
 * - Contemplar que solo existen 10 filas de 10 asientos no se pueden vender asientos
 * fuera de esas numeraciones, no se permite sobreventa.
 * 
 * - Consideraciones: no es necesario implementar GUI ni base de datos se evaluará 100%
 * el manejo lógico en el desarrollo de la aplicación.
 * 
 * - Extra : En caso que un cliente solicite visualizar cuales son los asientos disponibles
 * el sistema debe permitir mostrar en forma grafica por consola el mapa de asientos
 * recuerde no utilizar GUI para este caso, utilizar unicamente lógica y salida por consola.
 * este caso fue desarrollado libremente en un curso de java gratuito por youtube.
 * 
 */
public class Anfiteatro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char asientos [][] = new char[10][10];
        
        boolean bandera= false;
        
        Scanner sc = new Scanner(System.in);
        //importante inicializar fila y asiento
        int fila=0 , asiento=0;
        String respuesta;
        String verMapa;
            
        for (int f=0;f<10;f++) {
           for(int c=0;c<10;c++) {
               asientos[f][c]='L';
                 
           } 
        }
    
        System.out.println("Bienvenido al sistema de Reservas");
        
        while(bandera !=true){  
        System.out.println("Desea ver asientos disponible?S: si. N: no.");
        verMapa = sc.next();
        
        if (verMapa.equalsIgnoreCase("S")){
        dibujarMapa(asientos);
        }
        
        //reserva
        boolean ok=false;
        while(ok!=true) {
        System.out.println("\nSeleccione fila y asiento ---------------");
        System.out.print("----------- Fila entre 0 y 9 ------------");
        fila=sc.nextInt();
        
        System.out.print("---------- Asiento entre 0 y 9 ----------");
        asiento=sc.nextInt();
        
        if (fila<=9 && fila>=0){
             if (asiento<=9 && asiento>=0){
            ok=true;
        }
        else {
            System.out.println("El numero de asiento no es valido");
        }
        }
        else{
             System.out.println("El número de fila no es valido");   
                
            }
        }
        if (asientos[fila][asiento]=='L') {
            asientos[fila][asiento]='X';
        System.out.println("Asiento reservado correctamente");
                
        }
        else {
        System.out.println("Asiento ocupado por favor seleccione uno libre");
        }
   
        System.out.println("¿Desea finalizar la reserva? S: si N: no.");
            respuesta = sc.next();
        
            if (respuesta.equalsIgnoreCase("S")){
            bandera = true;
            }
        }
        
    }
    
        static void dibujarMapa(char asientos[][]) {
         
        for (int f=0;f<10;f++) {
            
            System.out.print(f+ "");
            
           for(int c=0;c<10;c++) { 
        
            System.out.print(" ["+asientos[f][c] +"]");
            }
            System.out.println("");
        }
    }
}
