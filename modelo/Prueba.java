/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

import java.util.Scanner;

/**
 *
 * @author Fernando
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        CaballoModel caballo;

        while (true) {
            caballo = new CaballoModel(); // Reinicia el tablero para cada intento

            System.out.print("Ingrese la posición inicial del caballo (x) o un valor negativo para salir: ");
            int inicioX = scanner.nextInt();

            if (inicioX < 0) {
                break; // Sale del ciclo si se ingresa un valor negativo
            }

            System.out.print("Ingrese la posición inicial del caballo (y): ");
            int inicioY = scanner.nextInt();

            // Verifica que las posiciones estén dentro del rango permitido
            if (inicioX < 0 || inicioX >= 8 || inicioY < 0 || inicioY >= 8) {
                System.out.println("Las posiciones deben estar entre 0 y 7 .");
            } else {
                if (caballo.moverCaballo(inicioX, inicioY, 0)) {
                    System.out.println("Tablero final con el mejor resultado:");
                    caballo.mostrarTablero();
                } else {
                    System.out.println("No se encontró un camino para el caballo.");
                }
            }
        }
        scanner.close(); // Cierra el escáner
        System.out.println("Saliendo del programa.");
    }
}
