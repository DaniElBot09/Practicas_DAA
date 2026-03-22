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
public class Actividades {
    // Atributos
    private ArrayList <int[]> lista = new ArrayList<int[]>();
    
    // Constructor
    public Actividades(ArrayList<int[]> lista_new){
        for(int i = 0; i<lista_new.size(); i++){
            int[] intervalo = lista_new.get(i);
            if (intervalo[0] <= 0 || intervalo[1] <= 0 || intervalo[1] < intervalo[0]) {
                throw new IllegalArgumentException("Intervalo inválido: [" + intervalo[0] + ", " + intervalo[1] + "]");
            }
            int[] aux = {i, intervalo[0], intervalo[1]};
            lista.add(aux);
        }   
    }
    
    // Métodos
    public void ordenar(){
        Comparator<int[]> PorFin = new Comparator <int[]>() {
            @Override
            public int compare(int[] l1, int[] l2) {
                return Integer.compare(l1[2],l2[2]);
            }
        };
        Collections.sort(lista, PorFin); 
    }
    public boolean compatibles(int i, int j){
        int[] actividad1 = lista.get(i);
        int[] actividad2 = lista.get(j);
        //Si la actividad 1 termina más tarde que empieza la actividad 2, no son compatibles
        boolean sol = !(actividad2[1] < actividad1[2]);  
        return sol;
    }
    
    public int size(){
        return lista.size();
    }
    public int[] getLista(int ind){
        for(int i=0; i<lista.size(); i++){
            if(ind==lista.get(i)[0]){
                return lista.get(i);
            }
        }
        return null;
    }
    public int[] getActividad(int i){
        return lista.get(i);
    }
}
