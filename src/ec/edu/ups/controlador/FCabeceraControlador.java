/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.FCabecera;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Domenica
 */
public class FCabeceraControlador {
    
    private BaseDeDatos db;

    public FCabeceraControlador(String url ,String user, String password) {
        
        db = new BaseDeDatos(url,user,password);
        
    }

    
    
    
    
     public void createFacCab(FCabecera facCab) {

        String sql = "INSERT INTO \"SDF_FACTURA_CABECERA\" VALUES(" + facCab.getRuc()+ "," 
                + facCab.getFecha() + "," 
                + facCab.getSubtotal() + "," 
                + facCab.getIva()+"," 
                + facCab.getTotal()
                +");";

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
    
    public FCabecera BuscarFacCab(int ruc) {

        FCabecera facCab = new FCabecera();

        try {

            String sql = "SELECT * FROM \"SDF_FACTURA_CABECERA\"WHERE\"ruc\"= " + ruc + ";";
            System.out.println("BASE" + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                facCab.setRuc(ruc);
                facCab.setFecha(res.getDate("fecha"));
                facCab.setSubtotal(res.getDouble("subtotal"));
                facCab.setIva(res.getDouble("iva"));
                facCab.setTotal(res.getDouble("total"));

            }
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {
            error.printStackTrace();
        }
        return facCab;

    }
    
    public Set printFacCab() {

        Set<FCabecera> lista = new HashSet<>();

        try {

            String sql = "SELECT * FROM \"Factura_Cabecera\";";
            System.out.println("Base listar" + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                FCabecera facCab = new FCabecera();
                facCab.setRuc(res.getInt("fCab_ruc"));
                facCab.setFecha(res.getDate("fCab_fecha"));
                facCab.setSubtotal(res.getDouble("fCab_subtotal"));
                facCab.setIva(res.getDouble("fCab_iva"));
                facCab.setTotal(res.getDouble("fCab_total"));

            }
            
            res.close();
            sta.close();
            db.desconectar();
        } catch (SQLException error) {

            error.printStackTrace();

        }
        return lista;
    }
    
}
