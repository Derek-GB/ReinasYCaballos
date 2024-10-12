/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reinas.controlador;

import reinas.modelo.OchoReinasModel;
import reinas.vista.OchoReinasView;

/**
 *
 * @author d2tod
 */
public class OchoReinasControl {
    private OchoReinasModel modelo;
    private OchoReinasView vista;

    public OchoReinasControl(OchoReinasModel modelo, OchoReinasView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void resolverProblema() {
        if (modelo.resolver(1)) {
            vista.imprimirTablero(modelo.getTablero());
        } else {
            vista.mostrarMensaje("No hay solución");
        }
    }
}
