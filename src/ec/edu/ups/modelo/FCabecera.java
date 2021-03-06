/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Domenica
 */
public class FCabecera {
    
    private int ruc;
    private Date fecha;
    private double subtotal;
    private double iva;
    private double total;
    private char estado;
    private String CedPer;
    
    //Clases
    private Personas per;
    private Producto pro;
    private List<FDetalle> detalle;

    public FCabecera() {
        
        detalle = new ArrayList<>();
        fecha = new Date();
        iva = 0.12;
        
    }

    public void añadirFacDetalle(FDetalle fDet){
        detalle.add(fDet);
    }

    public FCabecera(int ruc, Date fecha, double subtotal, double iva, double total, char estado, String CedPer, Personas per, Producto pro, List<FDetalle> detalle) {
        this.ruc = ruc;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.estado = estado;
        this.CedPer = CedPer;
        this.per = per;
        this.pro = pro;
        this.detalle = detalle;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getCedPer() {
        return CedPer;
    }

    public void setCedPer(String CedPer) {
        this.CedPer = CedPer;
    }

    public Personas getPer() {
        return per;
    }

    public void setPer(Personas per) {
        this.per = per;
    }

    public Producto getPro() {
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    public List<FDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<FDetalle> detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "FCabecera{" + "ruc=" + ruc + ", fecha=" + fecha + ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + ", estado=" + estado + ", CedPer=" + CedPer + ", per=" + per + ", pro=" + pro + ", detalle=" + detalle + '}';
    }

    
}
