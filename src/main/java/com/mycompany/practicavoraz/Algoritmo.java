/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicavoraz;
import java.util.*;
/**
 *
 * @author diego
 */

public abstract class Algoritmo {
    private static boolean compatibles(Actividades opciones, int i, int j){
        int[] actividad1 = opciones.getActividad(i);
        int[] actividad2 = opciones.getActividad(j);
        //Si la actividad 1 termina más tarde que empieza la actividad 2, no son compatibles
        boolean sol = !(actividad2[1] < actividad1[2]);  
        return sol;
    }
    public static ArrayList<Integer> voraz(Actividades opciones){
       opciones.ordenar();
       ArrayList <Integer> listaIndex = new ArrayList<>();
        listaIndex.add(0); 
        for(int i = 1; i<opciones.length(); i++){
           if(compatibles(opciones, listaIndex.get(listaIndex.size()-1), i)){
               listaIndex.add(i);
           }
       }
        ArrayList <Integer> listaIndexEntrada = new ArrayList<>();
        //Cambiamos por los índices de entrada
       for(int i = 0; i<listaIndex.size(); i++){
           int[] actividad = opciones.getActividad((int)listaIndex.get(i));
           listaIndexEntrada.add(actividad[0]);
       }
       return listaIndexEntrada;
    }    
}