/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reinas.logica;

import javax.swing.JToggleButton;
import reinas.modelo.Casilla;
import reinas.modelo.Estado;
import reinas.vista.FrmTablero;

/**
 *
 * @author d2tod
 */
public class OchoReinasLogica {

    private static final int N = 8;
    private int cont = 0;
    private Casilla[][] tablero;
    private JToggleButton botonF, botonC;
    private FrmTablero frm;

    public OchoReinasLogica(FrmTablero frm) {
        this.tablero = new Casilla[N][N];
        inicializarCasillas();
        this.botonF = frm.getBtn();
        this.botonC = frm.getBtnC();
        this.frm = frm;
    }
    
    private void inicializarCasillas() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = new Casilla();
            }
        }
    }

    public boolean resolver(int fila) {
        return resolverColumna(fila, 0) && cont == N;  // Retorna si al final la cantidad de reinas es 8
    }

    private boolean resolverColumna(int fila, int col) {
        // Caso base: si ya se colocó una reina en cada fila, el problema está resuelto
        if (fila >= N) {
            return true;
        }

        // Si se recorrió todas las columnas y no se encontró solución, devuelve falso
        if (col >= N) {
            return false;
        }

        dormir();

        // Se revisa si la casilla es segura
        if (esSeguro(fila, col)) {
            tablero[fila][col].setEstado(Estado.OCUPADO);  // Se coloca una reina en la posicion
            frm.chanceFicha(fila, col, Estado.OCUPADO);
            cont++;

            // Llamada recursiva para colocar una reina en la siguiente fila
            if (resolverColumna(fila + 1, 0)) {
                return true;  // Si se encuentra solucion, devolver true
            }

            // Si no encontra una solución, se quita de la reina (backtracking)
            finalizadoEn(fila, col);
            tablero[fila][col].setEstado(Estado.VACIO);
            frm.chanceFicha(fila, col, Estado.VACIO);
            cont--;
        }

        // Si no fue posible en la casilla actual, se prueba en la siguiente
        return resolverColumna(fila, col + 1);
    }

    private boolean esSeguro(int fila, int col) {
        return revisarColumna(fila, col) && revisarDiagonalIzquierda(fila, col) && revisarDiagonalDerecha(fila, col);
    }

    private boolean revisarColumna(int fila, int col) {
        if (fila < 0) {
            return true;  // Caso base: Se revisaron todas las filas
        }
        if (tablero[fila][col].getEstado() == Estado.OCUPADO) {
            return false;  // Hay una reina en la misma columna
        }
        {/*tablero[fila][col].chanceEstado(Estado.BLOQUEADO);*/
        }
        return revisarColumna(fila - 1, col);  // Llamada recursiva
    }

    private boolean revisarDiagonalIzquierda(int fila, int col) {
        if (fila < 0 || col < 0) {
            return true;  // Caso base: Fuera del tablero
        }
        if (tablero[fila][col].getEstado() == Estado.OCUPADO) {
            return false;  // Hay una reina
        }
        {/*tablero[fila][col].chanceEstado(Estado.BLOQUEADO);*/
        }
        return revisarDiagonalIzquierda(fila - 1, col - 1);  // Llamada recursiva
    }

    private boolean revisarDiagonalDerecha(int fila, int col) {
        if (fila < 0 || col >= N) {
            return true;  // Caso base: Fuera del tablero
        }
        if (tablero[fila][col].getEstado() == Estado.OCUPADO) {
            return false;  // Hay una reina
        }
        {/*tablero[fila][col].chanceEstado(Estado.BLOQUEADO);*/
        }
        return revisarDiagonalDerecha(fila - 1, col + 1);  // Llamada recursiva
    }

    private void finalizadoEn(int fila, int col) {
        botonF.setText(String.valueOf(fila + 1) + ':' + String.valueOf(col + 1));
        botonF.setSelected(false);
        do {
            dormir();
        } while (!botonF.isSelected() && !botonC.isSelected());
    }

    private void dormir() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Algo salio terriblemente mal");
        }
    }
}
