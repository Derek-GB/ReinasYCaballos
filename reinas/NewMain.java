/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reinas;

import reinas.controlador.OchoReinasControl;
import reinas.modelo.OchoReinasModel;
import reinas.vista.OchoReinasView;

/**
 *
 * @author d2tod
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OchoReinasModel modelo = new OchoReinasModel();
        OchoReinasView vista = new OchoReinasView();
        OchoReinasControl controlador = new OchoReinasControl(modelo, vista);

        controlador.resolverProblema();
    }
    
}
