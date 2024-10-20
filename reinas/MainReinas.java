/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reinas;

import reinas.logica.OchoReinasLogica;
import reinas.vista.FrmTablero;

/**
 *
 * @author DYLAN
 */
public class MainReinas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FrmTablero frm = new FrmTablero();
        OchoReinasLogica logica = new OchoReinasLogica(frm);
        frm.setVisible(true);
        System.out.println(logica.resolver(0)? "":"No hay solucion");
        
    }
    
}
