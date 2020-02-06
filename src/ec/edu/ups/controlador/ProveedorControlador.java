/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jose Guillermo Quinde
 */
public class ProveedorControlador {
    
 private BaseDeDatos db;
    private Set<Proveedor> lista;


    public ProveedorControlador(String url, String user, String password) {
        db = new BaseDeDatos(url, user, password);

    }
    /**
     * Te devuelve el ultimo codigo del ultimo registro de la base de datos
     * @return 
     */
     public int buscarUltimoCodigo() {
        int resultado = 0;
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery("SELECT MAX (\"PRV_ID\") FROM \"SDF_PROVEEDORES\"");
            res.next();
            resultado = res.getInt(1);
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error en la buscarUltimoCodigo " + ex);
        }
        return resultado;
    }

    public void createProveedor(Proveedor p) {

        String sql = "INSERT INTO \"SDF_PROVEEDORES\" VALUES("
                + p.getId() + ",'"
                + p.getNombre() + "'"
                + ")";

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

    public Proveedor BuscarProveedorNombre(String nombre) {

        Proveedor prov = new Proveedor();

        try {

            String sql = "SELECT * FROM \"SDF_PROVEEDORES\"WHERE\"PRV_NOMBRE\"= '" + nombre + "'";

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                prov.setId(res.getInt("PRV_ID"));
                prov.setNombre(nombre);
            }
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {
            error.printStackTrace();
        }

        return prov;

    }

    public Proveedor BuscarProveedorCodigo(int codigo) {

        Proveedor prov = new Proveedor();

        try {

            String sql = "SELECT * FROM \"SDF_PROVEEDORES\"WHERE\"PRV_ID\"= '" + codigo + "'";

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                prov.setId(codigo);
                prov.setNombre(res.getString("PRV_NOMBRE"));
            }
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {
            error.printStackTrace();
        }

        return prov;

    }

    public void modificarProveedor(Proveedor p) throws SQLException {

        String sql = "UPDATE\"SDF_PROVEEDORES\" SET "
                + "\"PRV_NOMBRE\"='" + p.getNombre() 
                + "WHERE \"PRV_ID\" = " + p.getId() + "";

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

      public Set<Proveedor> listaProveedor() throws Exception {
        Set<Proveedor> listaProv = new HashSet<Proveedor>();
        String sentenciaSQL = "SELECT * FROM \"SDF_PROVEEDORES\" ";
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sentenciaSQL);
            while (res.next()) {

                Proveedor prov = new Proveedor();
                prov.setId(res.getInt("PRV_ID"));
                prov.setNombre(res.getString("PRV_NOMBRE"));
                //System.out.println(p.toString());
                listaProv.add(prov);

            }
            sta.close();
            res.close();
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error Listar Proveedores: " + ex);
        }
        return listaProv;
    }
   

}
