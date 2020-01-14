/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;

/**
 *
 * @author Domenica
 */
public class FDetalle {
    
    private int codigo;
    private int cant;
    private double ivaPro;
    private double totalIP;
    
    //Clase
    private Producto pro;

    public FDetalle() {
    }

    public FDetalle(int codigo, int cant, double ivaPro, double totalIP, Producto pro) {
        this.codigo = codigo;
        this.cant = cant;
        this.ivaPro = ivaPro;
        this.totalIP = totalIP;
        this.pro = pro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getIvaPro() {
        return ivaPro;
    }

    public void setIvaPro(double ivaPro) {
        this.ivaPro = ivaPro;
    }

    public double getTotalIP() {
        return totalIP;
    }

    public void setTotalCP(double totalIP) {
        this.totalIP = totalIP;
    }

    public Producto getPro() {
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    @Override
    public String toString() {
        return "FDetalle{" + "codigo=" + codigo + ", cant=" + cant + ", ivaPro=" + ivaPro + ", totalCP=" + totalIP + ", pro=" + pro + '}';
    }

}
