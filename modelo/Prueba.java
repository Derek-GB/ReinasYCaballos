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
       CaballoModel modelo = new CaballoModel();
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar al usuario las coordenadas iniciales
        System.out.print("Ingrese la posición inicial en X (0-7): ");
        int xInicial = scanner.nextInt();
        
        System.out.print("Ingrese la posición inicial en Y (0-7): ");
        int yInicial = scanner.nextInt();
        
        // Iniciar el recorrido del caballo
        boolean resuelto = modelo.resolverRecorridoCaballo(xInicial, yInicial);
        
        // Mostrar el resultado
        if (resuelto) {
            System.out.println("Se ha encontrado un recorrido:");
            imprimirTablero(modelo.getTablero());
        } else {
            System.out.println("No se encontró un recorrido válido desde la posición (" + xInicial + ", " + yInicial + ").");
        }

        scanner.close();
    }

    // Método para imprimir el tablero en la consola
    private static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
}
