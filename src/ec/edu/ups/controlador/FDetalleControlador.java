/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;
import ec.edu.ups.modelo.FDetalle;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Domenica
 */
public class FDetalleControlador {
    
     /*public void createFacDet(FDetalle facDet) {

        String sql = "INSERT INTO \"Factura_Detalle\" VALUES(" + facDet.getCantidad() + "," + facDet.getTotalCP() + "," + facDet.getCodigo() + ");";

        System.out.println(sql);

        MiBaseDatos.conectar();
        try {

            Statement sta = MiBaseDatos.getConexionBD().createStatement();
            sta.execute(sql);
            MiBaseDatos.desconectar();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public FDetalle BuscarFacCab(int codigo) {

        FDetalle facDet = new FDetalle();

        try {

            String sql = "SELECT * FROM \"Factura_Detalle\"WHERE\"codigo\"= " + codigo + ";";
            System.out.println("BASE" + sql);

            MiBaseDatos.conectar();
            Statement sta = MiBaseDatos.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                facDet.setCodigo(codigo);
                facDet.setCantidad(res.getInt("cantidad"));
                facDet.setTotalCP(res.getDouble("total"));

            }
            res.close();
            sta.close();
            MiBaseDatos.desconectar();

        } catch (SQLException error) {
            error.printStackTrace();
        }
        return facDet;

    }

    public void AnularFacDet(int codigo) {

        String sql = "DELETE FROM \"Factura_Detalle \"WHERE \"codigo \" = " + codigo + ";";
        System.out.println("Base eliminada " + sql);

        MiBaseDatos.conectar();
        try {

            Statement sta = MiBaseDatos.getConexionBD().createStatement();
            sta.execute(sql);
            MiBaseDatos.desconectar();

        } catch (SQLException error) {

            error.printStackTrace();

        }

    }

    public Set printFacCab() {

        Set<FDetalle> lista = new HashSet<>();

        try {

            String sql = "SELECT * FROM \"Factura_Cabecera\";";
            System.out.println("Base listar" + sql);

            MiBaseDatos.conectar();
            Statement sta = MiBaseDatos.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                FDetalle facDet = new FDetalle();
                facDet.setCodigo(res.getInt("codigo"));
                facDet.setCantidad(res.getInt("cantidad"));
                facDet.setTotalCP(res.getDouble("total"));

            }
            res.close();
            sta.close();
            MiBaseDatos.desconectar();
        } catch (SQLException error) {

            error.printStackTrace();

        }
        return lista;
    }*/

    
}
