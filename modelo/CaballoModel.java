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
   
    private static final int[][] MOVIMIENTOS_CABALLO = {
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

    private int[][] tablero;
    private boolean[][] visitados;
    private int movimientos;

    public CaballoModel() {
        this.tablero = new int[8][8];
        this.visitados = new boolean[8][8];
        this.movimientos = 0;
    }

    public boolean moverCaballo(int x, int y, int pasos) {
        if (x < 0 || x >= 8|| y < 0 || y >= 8 || visitados[x][y]) {
            return false; 
        }

        visitados[x][y] = true;
        tablero[x][y] = pasos;

        if (pasos == 8 * 8 - 1) {
            return true;
        }

        for (int[] movimiento : MOVIMIENTOS_CABALLO) {
            int nuevaX = x + movimiento[0];
            int nuevaY = y + movimiento[1];

            if (moverCaballo(nuevaX, nuevaY, pasos + 1)) {
                return true; 
            }
        }
        visitados[x][y] = false;
        tablero[x][y] = 0;
        return false; 
    }

    public void mostrarTablero() {
        for (int[] fila : tablero) {
            System.out.println(Arrays.toString(fila));
        }
        System.out.println();
    }

  
}
