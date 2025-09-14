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
        this.RUT = formatearRUT(RUT);
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
            this.edad = (int) ChronoUnit.YEARS.between(LocalDate.now(), fechaNacimiento);
    } catch (Exception e) {
        System.out.println("Error al parsear fechas: " + e.getMessage());
        this.edad = -1;
    }
}

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFechaTexto() {
        return fechaTexto;
    }

    public void setFechaTexto(String fechaTexto) {
        this.fechaTexto = fechaTexto;
    }

    public String getFechaTexto1() {
        return fechaTexto1;
    }

    public void setFechaTexto1(String fechaTexto1) {
        this.fechaTexto1 = fechaTexto1;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaHoy() {
        return fechaHoy;
    }

    public void setFechaHoy(LocalDate fechaHoy) {
        this.fechaHoy = fechaHoy;
    }
    
    public void mostrar(){
        System.out.printf("Fecha de registro: " + fechaHoy);
        System.out.printf(" RUT : " + RUT + " || ");
        System.out.printf(" Nombre : " + Nombre + " || ");
        System.out.printf(" Edad : " + edad + " || ");
        System.out.printf(" Genero : " + Genero + " || ");
        System.out.printf(" Departamento : " + Departamento + " || ");
        System.out.printf(" Sueldo : " + sueldoLiquido() + " || ");
    }
    
    public double sueldoLiquido(){
        int gratificacion = 75000;
        int colacion  = 20000;
        int locomocion = 35000;
        double SueldoLiquido = sueldoBase + gratificacion + colacion + locomocion - (sueldoBase*0.1) - (sueldoBase*0.07);
        
        return SueldoLiquido;
    }
    
    public void buscarColaborador(String RutIngresado){
        if(limpiarRut(RutIngresado).equals(limpiarRut(this.RUT))){
            mostrar();
                    }else{
            System.out.println("Ingrese un RUT valido");
        }
    }
    
    private String limpiarRut(String Rut){
        return Rut.replace(".", "").replace("-", "").replace(" ", "").toUpperCase();
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
        if(RutIngresado == null || this.RUT == null){
            System.out.println("RUT no puede ser nulo");
            return;
        }
        if(limpiarRut(RutIngresado).equals(limpiarRut(this.RUT))){
            System.out.println("Desea eliminar a: " + Nombre + "?");
            System.out.println("Ingrese (1) para Si/ (2) para No");
            if(leer == null){
                leer = new Scanner (System.in);
            }
            decision = leer.nextInt();
            if(decision == 1){
                estado = 0;
                System.out.println("colaborador eliminado.");
            }else{
                System.out.println("operacion cancelada");
            }
        }else{
            System.out.println("Ingrese un RUT valido");
        }
    }
    
    public static String formatearRUT(String RutSinFormato){
            String Cuerpo = RutSinFormato.substring(0, RutSinFormato.length()-1);
            String dv = RutSinFormato.substring(RutSinFormato.length()-1);
            
            StringBuilder cuerpoFormateado = new StringBuilder();   
            int contador = 0;
            for (int i= Cuerpo.length()-1;i>=0; i--){
                cuerpoFormateado.insert(0, Cuerpo.charAt(i));
                contador ++;
                if(contador == 3 && i!=0){
                    cuerpoFormateado.insert(0,".");
                    contador = 0;
                }
            }
            return cuerpoFormateado.toString() + "-" + dv;
    }
    
}
