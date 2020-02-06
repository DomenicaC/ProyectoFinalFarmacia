/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Objects;

/**
 *
 * @author ByronPC
 */
public class Personas {
    
    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String username;
    private String contrasenia;
    private int rol_id;
    private char estado;

    public Personas() {
    }

    public Personas(String cedula, String nombres, String apellidos, String direccion, String telefono, String username, String contrasenia, int rol_id, char estado) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.username = username;
        this.contrasenia = contrasenia;
        this.rol_id = rol_id;
        this.estado = estado;
    }

  

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.cedula);
        hash = 89 * hash + Objects.hashCode(this.nombres);
        hash = 89 * hash + Objects.hashCode(this.apellidos);
        hash = 89 * hash + Objects.hashCode(this.direccion);
        hash = 89 * hash + Objects.hashCode(this.telefono);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personas other = (Personas) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Personas{" + "cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono=" + telefono + ", username=" + username + ", contrasenia=" + contrasenia + ", rol_id=" + rol_id + '}';
    }

   
    
}
