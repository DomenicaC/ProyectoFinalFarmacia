/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Personas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author ByronPC
 */
public class PersonaControlador {
     private BaseDeDatos db;

    public PersonaControlador (String url ,String user, String password) {
        db = new BaseDeDatos(url,user,password);
    }

    public void create(Personas persona) {
        String sql = "INSERT INTO \"SDF_PERSONAS\" VALUES('" + persona.getCedula() + "',"
                + "'" + persona.getNombres() + "',"
                + "'"+ persona.getApellidos() + "',"
                + "'"+persona.getDireccion()+ "',"               
                + "'"+persona.getTelefono()+ "',"
                + "'"+persona.getUsername() + "',"
                + "'"+persona.getContrasenia() + "',"
                +persona.getRol_id()+         
                ")";
        //System.out.println(sql);
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            sta.execute(sql);
            db.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Personas BuscaarPersona(String cedula)  {
        Personas per = new Personas();
        try {
            String sql = "SELECT * FROM \"SDF_PERSONAS\" WHERE per_cedula ='" + cedula + "'";
            System.out.println("Base " + sql);
            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

          res.next();
                per.setCedula(cedula);
                per.setNombres(res.getString("PER_NOMBRES"));
                per.setApellidos(res.getString("PER_APELLIDOS"));
                per.setDireccion(res.getString("PER_DIRECCION"));
                per.setTelefono(res.getString("PER_TELEFONO"));
                per.setUsername(res.getString("PER_USERNAME"));
                per.setContrasenia(res.getString("PER_CONTRASENIA"));
                per.setRol_id(res.getInt("SDF_ROLES_ROL_ID")); 
                System.out.println(per.toString());              
            
                res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {

            error.printStackTrace();

        }
      
        return per;
    }

    public void modificar(Personas p) throws SQLException {
        String sql = "UPDATE\"SDF_PERSONAS\" SET "
                + "\"PER_NOMBRES\"='" + p.getNombres() + "',"
                + "\"PER_APELLIDOS\"='"+ p.getApellidos() + "',"
                + "\"PER_DIRECCION\"='" + p.getDireccion() + "',"
                + "\"PER_TELEFONO\"='" + p.getTelefono() + "',"
                + "\"PER_CONTRASENIA\"='" + p.getContrasenia()+ "',"
                + "\"SDF_ROLES_ROL_ID\"='" + p.getRol_id() +"' "
                + "WHERE \"PER_CEDULA\" = '" + p.getCedula()+ "'";
        System.out.println(sql);
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            sta.execute(sql);
            db.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void deletePer(String cedula) {
        
        String sql = "DELETE FROM \"SDF_PERSONAS\"WHERE \"PER_CEDULA\" = '" + cedula + "'";
        System.out.println("Persona Eliminada eliminada " + sql);

  
        db.conectar();
        try {

            Statement sta = db.getConexionBD().createStatement();
            sta.execute(sql);
            db.desconectar();

        } catch (SQLException error) {

            error.printStackTrace();

        }

    }
    /**
        * Retorna la lista de Personas en la base de Datos
     *
     * @return
     * @throws Exception
     */
    
    public void anularPer(String cedula){
        String sql = "UPDATE \"SDF_PERSONAS\" SET \"PER_ESTADO\" = 'I' WHERE \"PER_CEDULA\" = '" + cedula + "'";
        System.out.println("Persona Eliminada eliminada " + sql);
         db.conectar();
        try {

            Statement sta = db.getConexionBD().createStatement();
            sta.execute(sql);
            db.desconectar();

        } catch (SQLException error) {

            error.printStackTrace();

        }
    }
    
    public void contar(String cedula){
       
        String sql = "SELECT COUNT(PER_CEDULA) FROM sdf_personas a, sdf_factura_cabeceras b WHERE a.per_cedula= b.sdf_personas_per_cedula AND a.per_cedula= '" + cedula + "'";
        System.out.println("Consulta " + sql);   

        db.conectar();
        try {

            Statement sta = db.getConexionBD().createStatement();
            sta.execute(sql);
            db.desconectar();

        } catch (SQLException error) {

            error.printStackTrace();

        }
    }
   public Set<Personas> listaPersonas() throws Exception {
        Set<Personas> listaPersonas = new HashSet<Personas>();
        String sentenciaSQL = "SELECT * FROM \"SDF_PERSONAS\" ";
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet rs = sta.executeQuery(sentenciaSQL);
            while (rs.next()) {
                Personas p = new Personas();
                p.setCedula(rs.getString("PER_CEDULA"));
                p.setNombres(rs.getString("PER_NOMBRES"));
                p.setApellidos(rs.getString("PER_APELLIDOS"));
                p.setDireccion(rs.getString("PER_DIRECCION"));
                p.setTelefono(rs.getString("PER_TELEFONO"));
                p.setUsername(rs.getString("PER_USERNAME"));
                p.setContrasenia(rs.getString("PER_CONTRASENIA"));
                p.setRol_id(rs.getInt("SDF_ROLES_ROL_ID")); 
                //System.out.println(p.toString());
                listaPersonas.add(p);
                
            }
            sta.close();
            rs.close();
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error Listar Personas: " + ex);
        }
        return listaPersonas;
    } 
}