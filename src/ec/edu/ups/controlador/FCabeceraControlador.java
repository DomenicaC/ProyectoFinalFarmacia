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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Domenica
 */
public class FCabeceraControlador {

    private BaseDeDatos db;
    private int ruc;
    private Set<FCabecera> lista;

    public int getCodigo() {
        return ruc;
    }

    public Set<FCabecera> getFFactura() {
        return lista;
    }

    public FCabeceraControlador() {

        lista = new HashSet<>();
        ruc = 0;

    }

    public String getFecha() {
        java.util.Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaT = formatoFecha.format(fecha.getTime());
        return fechaT;
    }

    public FCabeceraControlador(String url, String user, String password) {

        db = new BaseDeDatos(url, user, password);

    }

    public void createFacCab(FCabecera facCab) {

        ruc++;
        facCab.setRuc(ruc);
        String sql = "INSERT INTO \"SDF_FACTURA_CABECERAS\" VALUES("
                + facCab.getRuc() + ","
                + facCab.getFecha() + ","
                + facCab.getSubtotal() + ","
                + facCab.getIva() + ","
                + facCab.getTotal() + ",'"
                + facCab.getEstado() + "',"
                + ");";

        System.out.println(sql);

        db.conectar();
        try {

            Statement sta = db.getConexionBD().createStatement();
            sta.execute(sql);
            db.desconectar();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        lista.add(facCab);

    }
    
    public void createFacCab1(FCabecera facCab) {
        
        ruc++;
        facCab.setRuc(ruc);
        lista.add(facCab);
        
    }

    public FCabecera BuscarFacCab(int ruc) {

        FCabecera facCab = new FCabecera();

        try {

            String sql = "SELECT * FROM \"SDF_FACTURA_CABECERAS\"WHERE\"fac_id\"= " + ruc + ";";
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

    public FCabecera BuscarFacCab1(int ruc) {

        FCabecera facCab = new FCabecera();
        for (FCabecera fac : lista) {

            if (fac.getRuc() == ruc) {

                return facCab;

            }

        }
        return null;
    }

    public Set printFacCab() {

        //Set<FCabecera> lista = new HashSet<>();

        try {

            String sql = "SELECT * FROM \"FACTURA_CABECERAS\";";
            System.out.println("Base listar" + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                FCabecera facCab = new FCabecera();
                facCab.setRuc(res.getInt("fac_ruc"));
                facCab.setFecha(res.getDate("fac_fecha"));
                facCab.setSubtotal(res.getDouble("fac_subtotal"));
                facCab.setIva(res.getDouble("fac_iva"));
                facCab.setTotal(res.getDouble("fac_total"));

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
