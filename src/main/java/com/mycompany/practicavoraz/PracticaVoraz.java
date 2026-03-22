/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practicavoraz;
import java.util.*;
import java.io.*;
/**
 *
 * @author diego
 */
public class PracticaVoraz {
    
    public static void main(String[] args){
        ArrayList<int[]> datos = new ArrayList<>();
        Scanner sc = null;
        boolean porTeclado = !(args.length > 0);
        try{
            if(!porTeclado){        // Desde un fichero
                File fichero = new File(args[0]);
                sc = new Scanner(fichero);
            }else{                      // Desde el teclado
                System.out.println("Introduzca el numero de tareas: ");
                sc = new Scanner(System.in);
            }
            if(sc.hasNextInt()){
                int n = sc.nextInt();
                for(int i = 0; i < n; i++){
                    if(porTeclado) {
                        System.out.println("Tarea número... " + i); 
                        System.out.print("Inicio: "); 
                    }
                    int inicio = sc.nextInt();
                    if(porTeclado) System.out.print("Fin: ");
                    int fin = sc.nextInt();
                    datos.add(new int[] {inicio, fin});
                }
            }

            ArrayList<Integer> sol = Algoritmo.voraz(new Actividades(datos));

            if(args.length > 1){
                File ficheroSalida = new File(args[1]);
                if(ficheroSalida.exists()){
                    System.err.println("Error: El fichero de salida '" + args[1] + "' ya existe.");
                    return; 
                }
                PrintWriter writer = new PrintWriter(ficheroSalida);
                writer.println("Tareas seleccionadas: " + sol);
                writer.close();
            }else{
                System.out.println("Selección de tamaño maximal: " + sol);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (sc != null) sc.close();
        }
    }
}
