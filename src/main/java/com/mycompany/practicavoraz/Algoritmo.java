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
    public static ArrayList<Integer> voraz(Actividades opciones){
    opciones.ordenar();
    ArrayList <Integer> listaIndex = new ArrayList<>();
    listaIndex.add(0); 
    for(int i = 1; i<opciones.size(); i++){
        if(opciones.compatibles(listaIndex.get(listaIndex.size()-1), i)){
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
