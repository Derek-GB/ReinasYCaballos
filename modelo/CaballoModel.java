/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Fernando
 */
public class CaballoModel {
   
    private int[][] tablero;
    private int[] X = {2, 1, -1, -2, -2, -1, 1, 2};  
    private int[] Y = {1, 2, 2, 1, -1, -2, -2, -1};
    private boolean termina = false;
    
     public int[][] getTablero() {
        return tablero;
    }
     
    public CaballoModel() {
        tablero = new int[8][8];
        reiniciarTablero();
    }

    public void reiniciarTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = -1;  
            }
        }
    }

    public boolean resolverRecorridoCaballo(int x, int y) {
        if (!movimientoValido(x, y)) {
            throw new IllegalArgumentException("Posición inicial fuera de los límites del tablero.");
        }
        tablero[x][y] = 0;
        termina = resolver(x, y, 1);
        return termina;
    }

    private boolean resolver(int x, int y, int movimiento) {
        if (movimiento == 8 * 8) {
            return true;  
        }

        for (int i = 0; i < 8; i++) {
            int nuevoX = x + X[i];
            int nuevoY = y + Y[i];
            if (movimientoValido(nuevoX, nuevoY)) {
                tablero[nuevoX][nuevoY] = movimiento;
                if (resolver(nuevoX, nuevoY, movimiento + 1)) {
                    return true;
                }
                tablero[nuevoX][nuevoY] = -1;  
            }
        }
        return false;
    }

    private boolean movimientoValido(int x, int y) {
        return (x >= 0 && x < 8 && y >= 0 && y < 8 && tablero[x][y] == -1);
    }

    public boolean resuelto() {
        return termina;
    }

    
}
