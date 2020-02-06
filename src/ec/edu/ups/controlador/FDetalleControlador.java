/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.FDetalle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Domenica
 */
public class FDetalleControlador {

    private BaseDeDatos db;
    private int codigo;
    private Set<FDetalle> lista;

    public int getCodigo() {
        return codigo;
    }

    public Set<FDetalle> getLista() {
        return lista;
    }

    public FDetalleControlador() {

        lista = new HashSet<>();
        codigo = 0;

    }

    public FDetalleControlador(String url, String user, String password) {

        db = new BaseDeDatos(url, user, password);

    }

    public int buscarUltCodigo() {

        int rest = 0;
        db.conectar();
        try {

            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery("SELECT MAX (\"FDT_ID\") FROM \"SDF_FACTURAS_DETALLES\"");
            res.next();
            rest = res.getInt(1);
            db.desconectar();

        } catch (SQLException ex) {
            System.out.println("Error en buscar el ultimo codigo de la factura detalle " + ex);
        }
        return rest;
    }

    public void createFacDet(FDetalle facDet) {

        String sql = "INSERT INTO \"SDF_FACTURAS_DETALLES\" VALUES("
                + facDet.getCodigo() + ","
                + facDet.getCant() + ","
                + facDet.getPrecioP() + ","
                + facDet.getIvaPro() + ","
                + facDet.getTotalCP() + ","
                + facDet.getRucFac() + ","
                + facDet.getCodPro() + ")";

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

    public void createFacDet1(FDetalle facDet) {

        codigo++;
        facDet.setCodigo(codigo);
        lista.add(facDet);

    }

    public FDetalle BuscarFacDet(int codigo) {

        FDetalle facDet = new FDetalle();

        try {

            String sql = "SELECT * FROM \"SDF_FACTURAS_DETALLES\"WHERE\"codigo\"= " + codigo + "";
            System.out.println("BASE" + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                facDet.setCodigo(codigo);
                facDet.setCant(res.getInt("cantidad"));
                facDet.setTotalCP(res.getDouble("total"));

            }
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {
            error.printStackTrace();
        }
        return facDet;

    }

    public FDetalle BuscarFacCab1(int codigo) {

        for (FDetalle fac : lista) {
            if (fac.getCodigo() == codigo) {
                return fac;
            }
        }
        return null;

    }

    public Set printFacDet() {

        Set<FDetalle> lista = new HashSet<>();

        try {

            String sql = "SELECT * FROM \"SDF_FACTURAS_DETALLES\"";
            System.out.println("Base listar" + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                FDetalle facDet = new FDetalle();
                facDet.setCodigo(res.getInt("codigo"));
                facDet.setCant(res.getInt("cantidad"));
                facDet.setTotalCP(res.getDouble("total"));

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
