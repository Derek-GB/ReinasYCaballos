/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reinas.modelo;

/**
 *
 * @author d2tod
 */
public class OchoReinasModel {

    private static final int N = 8;
    private int[][] tablero = new int[N][N];

    private boolean resolver(int fila) {
        return resolverColumna(fila, 0);  // Comenzamos en la fila actual y en la primera columna (col = 0)
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
            tablero[fila][col] = 1;  // Colocamos la reina en esta posición

            // Llamamos recursivamente para colocar la siguiente reina en la siguiente fila
            if (resolver(fila + 1)) {
                return true;  // Si encontramos una solución, devolvemos true
            }

            // Si no encontramos una solución, deshacemos la colocación de la reina (backtracking)
            tablero[fila][col] = 0;
        }

        // Si no fue posible en la columna actual, probamos con la siguiente columna
        return resolverColumna(fila, col + 1);
    }

}
