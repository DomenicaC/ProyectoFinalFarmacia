/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author Edison
 */
public class Proveedor {

    private int id;
    private String nombre;
    private String numFactura;

    public Proveedor() {
    }

    public Proveedor(int id, String nombre, String numFactura) {
        this.id = id;
        this.nombre = nombre;
        this.numFactura = numFactura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", nombre=" + nombre + ", numFactura=" + numFactura + '}';
    }
    
}
