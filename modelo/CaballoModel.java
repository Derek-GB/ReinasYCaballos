/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Arrays;

/**
 *
 * @author Fernando
 */
public class CaballoModel {
   
   protected int[][] tablero;
    private int[] movimientosX = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] movimientosY = {1, 2, 2, 1, -1, -2, -2, -1};

    public CaballoModel() {
        tablero = new int[8][8];
    }

    private boolean esValido(int x, int y) {
        return (x >= 0 && y >= 0 && x < 8 && y < 8 && tablero[x][y] == -1);
    }

    public boolean moverCaballo(int x, int y, int Contador) {
        
      //  System.out.println("Moviendo el caballo a (" + x + ", " + y + ") #Movimiento" + Contador);
        
        if (Contador == 64) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int X = x + movimientosX[i];
            int Y = y + movimientosY[i];
            if (esValido(X, Y)) {
                tablero[X][Y] = Contador;
                
              //  System.out.println("Posición válida. Colocando el caballo en (" + X + ", " + Y + ")");
                
                if (moverCaballo(X, Y, Contador + 1)) {
                    return true;
                }
                
                //System.out.println("Backtracking desde (" + X + ", " + Y + ")");
                
                tablero[X][Y] = -1;
            }
        }
        return false;
    }


    public void inicializarTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = -1;
            }
        }
    }


    public void mostrarTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(String.format("%2d ", tablero[i][j]));
            }
            System.out.println();
        }
    }

  
}
