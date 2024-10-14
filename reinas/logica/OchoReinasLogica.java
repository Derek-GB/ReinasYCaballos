/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reinas.logica;

import reinas.modelo.Casilla;
import reinas.modelo.Estado;

/**
 *
 * @author d2tod
 */
public class OchoReinasLogica {

    private static final int N = 8;
    private int cont = 0;
    private Casilla [][] tablero;

    public Casilla[][] getTablero() {
        return tablero;
    }

    public OchoReinasLogica(Casilla[][] tablero) {
        this.tablero = tablero;
    }
    
    
    public boolean resolver(int fila) {
        return resolverColumna(fila, 0) && cont == 8;  // Comenzamos en la fila actual y en la primera columna (col = 0)
    }

    private boolean resolverColumna(int fila, int col) {
        // Caso base: si ya colocamos una reina en cada fila, el problema está resuelto
        if (fila >= N) {
            return true;
        }

        // Si hemos recorrido todas las columnas y no encontramos una solución, devolvemos falso
        if (col >= N) {
            return false;
        }

        // Intentamos colocar la reina en la posición (fila, col) si es seguro hacerlo
        if (esSeguro(fila, col)) {
            tablero[fila][col].chanceEstado(Estado.OCUPADO);  // Colocamos la reina en esta posición
            cont++;

            // Llamamos recursivamente para colocar la siguiente reina en la siguiente fila
            if (resolverColumna(fila + 1, 0)) {
                return true;  // Si encontramos una solución, devolvemos true
            }

            // Si no encontramos una solución, deshacemos la colocación de la reina (backtracking)
            tablero[fila][col].chanceEstado(Estado.VACIO);
            cont--;
        }

        // Si no fue posible en la columna actual, probamos con la siguiente columna
        return resolverColumna(fila, col + 1);
    }

    private boolean esSeguro(int fila, int col) {
        return revisarColumna(fila, col) && revisarDiagonalIzquierda(fila, col) && revisarDiagonalDerecha(fila, col);
    }

    private boolean revisarColumna(int fila, int col) {
        if (fila < 0) {
            return true;  // Caso base: Si hemos revisado todas las filas
        }
        if (tablero[fila][col].getEstado() == Estado.OCUPADO) {
            return false;  // Hay una reina en la misma columna
        }
        return revisarColumna(fila - 1, col);  // Llamada recursiva
    }

    private boolean revisarDiagonalIzquierda(int fila, int col) {
        if (fila < 0 || col < 0) {
            return true;  // Caso base: Fuera del tablero
        }
        if (tablero[fila][col].getEstado()== Estado.OCUPADO) {
            return false;  // Hay una reina en la diagonal izquierda
        }
        return revisarDiagonalIzquierda(fila - 1, col - 1);  // Llamada recursiva
    }

    private boolean revisarDiagonalDerecha(int fila, int col) {
        if (fila < 0 || col >= N) {
            return true;  // Caso base: Fuera del tablero
        }
        if (tablero[fila][col].getEstado()== Estado.OCUPADO) {
            return false;  // Hay una reina en la diagonal derecha
        }
        return revisarDiagonalDerecha(fila - 1, col + 1);  // Llamada recursiva
    }

}
