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
         CaballoModel caballo = new CaballoModel();
        caballo.inicializarTablero();

        Scanner scannerX = new Scanner(System.in);
        Scanner scannerY = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese la ubicación inicial del caballo.");
            System.out.print("X (entre 0 y 7):");
            int x = scannerX.nextInt();
            
            System.out.print("Y (entre 0 y 7)");
            int y = scannerY.nextInt();

            if (x < 0 || y < 0) {
                System.out.println("Cerrando programa..");
                break;
            }

            caballo.inicializarTablero();
            caballo.tablero[x][y] = 0; 

            if (caballo.moverCaballo(x, y, 1)) {
                System.out.println("Solución encontrada:");
                System.out.print("   ");
                for (int col = 0; col < 8; col++) {
                    System.out.print("  " + col + " ");
                }
                System.out.println();

                System.out.println("  +" + "----".repeat(8) + "+");

                for (int i = 0; i < 8; i++) {
                    System.out.print(i + " |");
                    for (int j = 0; j < 8; j++) {
                        if (caballo.tablero[i][j] == -1) {
                            System.out.print("   |");
                        } else {
                            System.out.print(String.format("%2d |", caballo.tablero[i][j]));
                        }
                    }
                    System.out.println();
                    System.out.println("  +" + "----".repeat(8) + "+");
                }
            } else {
                System.out.println("No hay solución posible desde esta posición.");
            }
        }
        scannerX.close();
        scannerY.close();
    }
}
