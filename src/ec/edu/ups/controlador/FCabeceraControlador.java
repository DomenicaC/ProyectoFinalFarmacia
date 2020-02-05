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

    public int getRuc() {
        return ruc;
    }

    public Set<FCabecera> getFFactura() {
        return lista;
    }

    public FCabeceraControlador() {

        lista = new HashSet<>();
        ruc = 0;

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
                + facCab.getEstado() + "','"
                + facCab.getPer().getCedula() + "'"
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
                String m = res.getString("FAC_ESTADO");
                facCab.setEstado(m.charAt(0));
               // facCab.setPer(res.getString("sdf_personas_per_cedula"));

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

    private void modificar(FCabecera faC) throws SQLException {

        String sql = "UPDATE\"SDF_FACTURA_CABECERAS\" SET "
                + "\"FAC_FECHA\"='" + faC.getFecha() + "',"
                + "\"FAC_SUBTOTAL\"=" + faC.getSubtotal() + ","
                + "\"FAC_IVA\"=" + faC.getIva() + ","
                + "\"FAC_TOTAL\"=" + faC.getTotal() + ","
                + "\"FAC_ESTADO\"='" + faC.getEstado() + "',"
                + "\"sdf_personas_per_cedula\"='" + faC.getPer().getCedula() + "' "
                + "WHERE \"FAC_ID\" = " + faC.getRuc() + ";";

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

    public Set printFacCab() {

        //Set<FCabecera> lista = new HashSet<>();
        try {

            String sql = "SELECT * FROM \"SDF_FACTURA_CABECERAS\";";
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
