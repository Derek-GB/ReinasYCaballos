/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reinas.modelo;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author d2tod
 */
public class Casilla {

    private Estado estado;
    private JLabel casilla;

    public Casilla(JLabel casilla) {
        this.casilla = casilla;
        this.estado = Estado.VACIO;
    }
    
    public Casilla() {
        this.casilla = new JLabel();
        this.estado = Estado.VACIO;
    }

    public Estado getEstado() {
        return estado;
    }

    public void chanceEstado(Estado estado) {
        this.estado = estado;

        switch (estado) {
            case (Estado.OCUPADO) -> {
                ajustarImagen("/imagenes/reina.png", casilla);
            }
            case (Estado.BLOQUEADO) -> {
                ajustarImagen("/imagenes/bloqueada.png", casilla);
            }
            case (Estado.VACIO) -> {
                casilla.setIcon(null);
            }
        }
    }

    private void ajustarImagen(String ubicacion, javax.swing.JLabel casilla) {
        ImageIcon image = new ImageIcon(getClass().getResource(ubicacion));
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(casilla.getWidth(), casilla.getHeight(), Image.SCALE_DEFAULT));
        casilla.setIcon(icon);
    }

}
