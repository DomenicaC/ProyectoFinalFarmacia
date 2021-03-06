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
    private FCabeceraControlador cabeceraControlador;
    private ControladorProducto controladorProducto;

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
        this.cabeceraControlador = new FCabeceraControlador(url, user, password);
        this.controladorProducto = new ControladorProducto(url, user, password);
        

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

        //codigo++;
        facDet.setCodigo(buscarUltCodigo());
        lista.add(facDet);

    }

     public FDetalle BuscarFacDet(int codigo) {

        FDetalle facDet = new FDetalle();

        try {

            String sql = "SELECT * FROM \"SDF_FACTURAS_DETALLES\"WHERE sdf_factura_cabeceras_fac_id = " + codigo;
            System.out.println("BASE " + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

               // facDet.setCodigo(codigo);
                facDet.setCodPro(res.getInt("sdf_productos_pro_id"));
                facDet.setCant(res.getInt("fdt_cantidad"));
                //facDet.set
                //facDet.set
                facDet.setIvaPro(res.getDouble("fdt_precio_iva"));
                facDet.setTotalCP(res.getDouble("fdt_total"));

            }/*    fdt_precio_pro
            fdt_precio_iva
            fdt_total
            sdf_factura_cabeceras_fac_id*/
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {
            error.printStackTrace();
        }
        return facDet;

    }


    /*  public FDetalle BuscarFacCab1(int codigo) {

     for (FDetalle fac : lista) {
     if (fac.getCodigo() == codigo) {
     return fac;
     }
     }
     return null;

     }*/
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
    
    public Set<FDetalle> listarFacDet(int codigo) {
        Set<FDetalle> l = new HashSet<>();
        

        try {

            String sql = "SELECT * FROM \"SDF_FACTURAS_DETALLES\"WHERE sdf_factura_cabeceras_fac_id = " + codigo;
            System.out.println("BASE " + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {
                FDetalle facDet = new FDetalle();
                facDet.setCodigo(res.getInt("FDT_ID"));
                facDet.setCant(res.getInt("FDT_CANTIDAD"));
                facDet.setPrecioP(res.getDouble("FDT_PRECIO_PRO"));
                facDet.setIvaPro(res.getDouble("FDT_PRECIO_IVA"));
                facDet.setTotalCP(res.getDouble("FDT_TOTAL"));
                facDet.setFcab(cabeceraControlador.BuscarFacCab(res.getInt("SDF_FACTURA_CABECERAS_FAC_ID")));
                facDet.setPro(controladorProducto.Buscar(res.getInt("SDF_PRODUCTOS_PRO_ID")));
                facDet.setCodPro(res.getInt("SDF_PRODUCTOS_PRO_ID"));
                facDet.setRucFac(codigo);
                System.out.println(facDet.toString());
                l.add(facDet);

            }/*    fdt_precio_pro
            fdt_precio_iva
            fdt_total
            sdf_factura_cabeceras_fac_id*/
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {
            error.printStackTrace();
        }
        return l;

    }

}
