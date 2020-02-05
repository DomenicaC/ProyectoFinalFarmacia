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
    private double precioP;
    private double ivaPro;
    private double totalCP;
    private int rucFac;
    private int codPro;

    //Clase
    private Producto pro;
    private FCabecera fcab;

    public FDetalle() {
    }

    public FDetalle(int codigo, int cant, double precioP, double ivaPro, double totalCP, int rucFac, int codPro, Producto pro, FCabecera fcab) {
        this.codigo = codigo;
        this.cant = cant;
        this.precioP = precioP;
        this.ivaPro = ivaPro;
        this.totalCP = totalCP;
        this.rucFac = rucFac;
        this.codPro = codPro;
        this.pro = pro;
        this.fcab = fcab;
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

    public double getPrecioP() {
        return precioP;
    }

    public void setPrecioP(double precioP) {
        this.precioP = precioP;
    }

    public double getIvaPro() {
        return ivaPro;
    }

    public void setIvaPro(double ivaPro) {
        this.ivaPro = ivaPro;
    }

    public double getTotalCP() {
        return totalCP;
    }

    public void setTotalCP(double totalCP) {
        this.totalCP = totalCP;
    }

    public int getRucFac() {
        return rucFac;
    }

    public void setRucFac(int rucFac) {
        this.rucFac = rucFac;
    }

    public int getCodPro() {
        return codPro;
    }

    public void setCodPro(int codPro) {
        this.codPro = codPro;
    }

    public Producto getPro() {
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    public FCabecera getFcab() {
        return fcab;
    }

    public void setFcab(FCabecera fcab) {
        this.fcab = fcab;
    }

    @Override
    public String toString() {
        return "FDetalle{" + "codigo=" + codigo + ", cant=" + cant + ", precioP=" + precioP + ", ivaPro=" + ivaPro + ", totalCP=" + totalCP + ", rucFac=" + rucFac + ", codPro=" + codPro + ", pro=" + pro + ", fcab=" + fcab + '}';
    }

}
