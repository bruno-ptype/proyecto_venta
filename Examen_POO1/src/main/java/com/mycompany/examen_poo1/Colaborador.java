/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen_poo1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Colaborador {
    
    Scanner leer = new Scanner(System.in);
    
    protected String RUT; 
    protected String Nombre; 
    protected String Genero; 
    protected String Cargo; 
    protected String Departamento; 
    
    protected double sueldoBase;
    protected int estado = 1;
    

    protected String fechaTexto;
    protected String fechaTexto1;
    LocalDate fechaIngreso;
    LocalDate fechaNacimiento;
    int edad; 
    
 
    
    
    
 
    LocalDate fechaHoy = LocalDate.now();
    
    public Colaborador(){
        
    }
    public Colaborador(String RUT, String Nombre, String Genero, String Cargo, String Departamento, double sueldoBase, int estado, String fechaTexto1, String fechaTexto) {
        this.RUT = RUT;
        this.Nombre = Nombre;
        this.Genero = Genero;
        this.Cargo = Cargo;
        this.Departamento = Departamento;
        this.sueldoBase = sueldoBase;
        this.estado = estado; 
        this.fechaTexto = fechaTexto;
        this.fechaTexto1 = fechaTexto1;
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaHoy.format(formatter);
        LocalDate parsedDate = LocalDate.parse(fechaFormateada, formatter);
        try{
            this.fechaIngreso= LocalDate.parse(fechaTexto1, formatter);
            this.fechaNacimiento = LocalDate.parse(fechaTexto, formatter);
            this.edad = (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
    } catch (Exception e) {
        System.out.println("Error al parsear fechas: " + e.getMessage());
        this.edad = -1;
    }
}

        
    
    
    public void mostrar(){
        System.out.println("Fecha de registro: " + fechaHoy);
        System.out.println("\n RUT : " + RUT + " || ");
        System.out.println("\n Nombre : " + Nombre + " || ");
        System.out.println("\n Edad : " + edad + " || ");
        System.out.println("\n Genero : " + Genero + " || ");
        System.out.println("\n Departamento : " + Departamento + " || ");
        System.out.println("\n Sueldo : " + sueldoLiquido() + " || ");
    }
    
    public double sueldoLiquido(){
        int gratificacion = 75000;
        int colacion  = 20000;
        int locomocion = 35000;
        double SueldoLiquido = sueldoBase + gratificacion + colacion + locomocion - (sueldoBase*0.1) - (sueldoBase*0.07);
        
        return SueldoLiquido;
    }
    
    public void buscarColaborador(String RutIngresado){
        if(RutIngresado.equals(RUT)){
            mostrar();
                    }else{
            System.out.println("Ingrese un RUT valido");
        }
    }
        
    /*public void eliminarColaborador(String RutIngresado, int decision){
        System.out.println("Ingrese el RUT del colaborador: ");
        if(RutIngresado == RUT){
            System.out.println("Desea eliminar a: " + Nombre + "?");
            leer.nextInt();
            System.out.println("Ingrese (1) para Si/ (2) para No");
            leer.nextInt();
            if(decision ==1){
                estado = 0;
            }
        }
    }
   */
    public void eliminarColaborador1(String RutIngresado, int decision){
        if(RutIngresado.equals(RUT)){
            System.out.println("Desea eliminar a: " + Nombre + "?");
            System.out.println("Ingrese (1) para Si/ (2) para No");
            decision = leer.nextInt();
            if(decision == 1){
                estado = 0;
            }
        }else{
            System.out.println("Ingrese un RUT valido");
        }
    }
    
}
