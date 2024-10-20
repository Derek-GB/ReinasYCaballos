/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reinas.modelo;

/**
 *
 * @author d2tod
 */
public class Casilla {

    private Estado estado;
    
    public Casilla() {
        this.estado = Estado.VACIO;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
