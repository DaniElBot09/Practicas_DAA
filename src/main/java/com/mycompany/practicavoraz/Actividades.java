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
    private ArrayList <int[]> lista = new ArrayList<int[]>();

public Actividades(ArrayList<int[]> Lista_new){
    for(int i = 0;i<Lista_new.size();i++){
        int[] aux ={i,Lista_new.get(i)[0],Lista_new.get(i)[1]};
        lista.add(aux);
    }   
}
public void ordenar(){
    
    Comparator<int[]> PorFin = new Comparator<int[]>() {
    @Override
    public int compare(int[] L1, int[] L2) {
        return Integer.compare(L1[2],L2[2]);
        
    
        }
    };
    Collections.sort(lista, PorFin); 
}

public int length(){
    return lista.size();
}
public int[] getLista(int ind){
    for (int i=0; i<lista.size();i++){
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
