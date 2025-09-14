/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen_poo1;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class ListadoColaboradores{
    
    ArrayList<Colaborador> listaColaboradores = new ArrayList<>();
    
    
    
    public void insertarColaborador(String RUT, String Nombre, String Genero, String Cargo, String Departamento, double sueldoBase, int estado, String fechaTexto1, String fechaTexto){
        Colaborador nuevo = new Colaborador (RUT, Nombre, Genero, Cargo, Departamento, sueldoBase, estado, fechaTexto1, fechaTexto);
        listaColaboradores.add(nuevo);
        System.out.println("Colaborador agregado a la lista. " + Nombre);
       
    }
    
    public void mostrasLista(){
        if(listaColaboradores.isEmpty()){
            System.out.println("No hay colaboradores registrados");
        }else{
        System.out.println("Lista colaboradores: ");
        for(Colaborador c : listaColaboradores){
            c.mostrar();
            System.out.println("--------------------------------------");
        }
        }
    }
}
