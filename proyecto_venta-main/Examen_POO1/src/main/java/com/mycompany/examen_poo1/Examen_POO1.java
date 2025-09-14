/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examen_poo1;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Examen_POO1 {

    public static void main(String[] args) {
        System.out.println("###############################");
        System.out.println("Administracion de colaboradores");
        System.out.println("###############################");
        
        Scanner leer = new Scanner (System.in);
        ListadoColaboradores arreglo = new ListadoColaboradores();
        
        
        int opciones;
        
        do{
            
            System.out.println("############################################");
            System.out.println("Bienvenido al administrador de colaboradores");
            System.out.println("############################################");
            System.out.println("Elige una opcion");
            System.out.println("1. Registrar un colaborador");
            System.out.println("2. Buscar un colaborador");
            System.out.println("3. Eliminar a un colaborador");
            System.out.println("4. Mostrar el estado de la empresa");
            System.out.println("5. Salir");
            
            opciones = leer.nextInt();
            leer.nextLine();
            try{
                switch(opciones){
                    case 1 -> {
                        System.out.println("Ingrese el RUT del colaborador: ");
                        String RUT = leer.nextLine();
                        System.out.println("Ingrese el nombre del colaborador: ");
                        String Nombre = leer.nextLine();
                        System.out.println("Ingrese el género del colaborador: ");
                        String Genero = leer.nextLine();
                        System.out.println("Ingrese la fecha de nacimiento del colaborador: ");
                        String fechaTexto = leer.nextLine();
                        System.out.println("Ingrese la fecha de ingreso del colaborador: ");
                        String fechaTexto1 = leer.nextLine();
                        System.out.println("Ingrese el cargo del colaborador: ");
                        String Cargo = leer.nextLine();
                        System.out.println("Ingrese el sueldo base del colaborador: ");
                        double sueldoBase = leer.nextDouble();
                        leer.nextLine();
                        int estado =1;
                        System.out.println("Ingrese el departamento del colaborador: ");
                        String Departamento = leer.nextLine();
                        System.out.println("Colaborador registrado correctamente!");
                        System.out.println("RUT: " + RUT + " || Nombre " + Nombre +  " || Genero:  " + Genero + " || Fecha de nacimiento: " + fechaTexto + " || Fecha de ingreso: " + fechaTexto1 + " || cargo: " + Cargo + " || Sueldo base: $" + sueldoBase);
                        System.out.println("Desea volver al menu? Si(1)/No(0)");
                        int eleccion=leer.nextInt();
                        if(eleccion ==1){
                            System.out.println("Retornando al menu");
                        }else if(eleccion==0){
                            System.out.println("Hasta pronto!");
                            opciones = 5;
                        }else{
                            System.out.println("Ingrese el simbolo solicitado");
                        }
                        Colaborador colab = new Colaborador(RUT, Nombre,Genero, Cargo, Departamento,sueldoBase, estado, fechaTexto1,fechaTexto);
                        arreglo.insertarColaborador(RUT, Nombre, Genero, Cargo, Departamento, sueldoBase, estado, fechaTexto1, fechaTexto);
                        break;
                    }
                    case 2 -> {
                        Colaborador colab1 = new Colaborador(); 
                        System.out.println("Ingrese el RUT del colaborador");
                        String RutIngresado = leer.nextLine();
                        
                        colab1.buscarColaborador(RutIngresado);
                        break;
                    }
                    case 3 -> {
                        Colaborador colab2 = new Colaborador(); 
                        System.out.println("Ingrese el RUT del colaborador");
                        String RutIngresado = leer.nextLine();
                        colab2.eliminarColaborador1(RutIngresado, opciones);
                        break;
                    }
                    case 4 -> {
                        System.out.println("Bienvenido a listado de colaboradores: ");
                        arreglo.mostrasLista();
                        break;
                    }
                
            }
            }catch(InputMismatchException letra){
                System.out.println("Ingrese el simbolos solicitado");
        }
            
            
        }while(opciones != 5);
    }
}
