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
        /*Personas per = new Personas();
        try {

            String sql = "SELECT * FROM \"PERSONA\"WHERE\"PER_CEDULA\"='" + cedula + "';";
            System.out.println("Base " + sql);

            MiBaseDatos.conectar();
            Statement sta = MiBaseDatos.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                per.setCedula(cedula);
                per.setNombre(res.getString("PER_NOMBRE"));
                per.setApellido(res.getString("PER_APELLIDO"));
                per.setEdad(res.getInt("PER_EDAD"));
                per.setDireccion(res.getString("PER_DIRECCION"));
            }
            res.close();
            sta.close();
            MiBaseDatos.desconectar();

        } catch (SQLException error) {

            error.printStackTrace();

        }*/
      
        return null;
    }

    public void modificar(Personas p) throws SQLException {
        String sql = "UPDATE\"PERSONA\" SET \"PER_NOMBRE\" = '" 
                + p.getNombres() + "',\"PER_APELLIDO\" = '" 
                + p.getApellidos() + "',\"PER_EDAD\" = " 
                + ",\"PER_DIRECCION\" = '" 
                + p.getDireccion() +"' WHERE \"PER_CEDULA\" = '" + p.getCedula()+ "';";
        
        System.out.println(sql);
        /*MiBaseDatos.conectar();
        try {
            Statement sta = MiBaseDatos.getConexionBD().createStatement();
            sta.execute(sql);
            MiBaseDatos.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }*/
    }
    public void deletePer(String cedula) {
        String sql = "DELETE FROM \"PERSONA\"WHERE \"PER_CEDULA\" = '" + cedula + "';";
        System.out.println("Base eliminada " + sql);

       /*MiBaseDatos.conectar();
        try {

            Statement sta = MiBaseDatos.getConexionBD().createStatement();
            sta.execute(sql);
            MiBaseDatos.desconectar();

        } catch (SQLException error) {

            error.printStackTrace();

        }*/

    }
    /**
        * Retorna la lista de Personas en la base de Datos
     *
     * @return
     * @throws Exception
     */
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