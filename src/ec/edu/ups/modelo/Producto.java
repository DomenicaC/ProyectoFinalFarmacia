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
public class Producto {

    private int id;
    private String codBarra;
    private String nombre;
    private Double precio;
    private int stock;
    private char nacionalidad;
    private boolean iva;
    private UnidadMedida um;
    private CategoriaProducto cp;

    public Producto() {
    }

    public Producto(int id, String codBarra, String nombre, Double precio, int stock, char nacionalidad, boolean iva, UnidadMedida um, CategoriaProducto cp) {
        this.id = id;
        this.codBarra = codBarra;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.nacionalidad = nacionalidad;
        this.iva = iva;
        this.um = um;
        this.cp = cp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public char getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(char nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public boolean isIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    public UnidadMedida getUm() {
        return um;
    }

    public void setUm(UnidadMedida um) {
        this.um = um;
    }

    public CategoriaProducto getCp() {
        return cp;
    }

    public void setCp(CategoriaProducto cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", codBarra=" + codBarra + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", nacionalidad=" + nacionalidad + ", iva=" + iva + ", um=" + um + ", cp=" + cp + '}';
    }
    
}
