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
    
     public void createFacDet(FDetalle facDet) {

         codigo++;
         facDet.setCodigo(codigo);
         
        String sql = "INSERT INTO \"Factura_Detalle\" VALUES(" + facDet.getCant()+ "," 
                                                                + facDet.getIvaPro() + "," 
                                                                + facDet.getCodigo() + ");";

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
        
        codigo ++;
        facDet.setCodigo(codigo);
        lista.add(facDet);
        
    }

    public FDetalle BuscarFacCab(int codigo) {

        FDetalle facDet = new FDetalle();

        try {

            String sql = "SELECT * FROM \"Factura_Detalle\"WHERE\"codigo\"= " + codigo + ";";
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
            if (fac.getCodigo()== codigo) {
                return fac;
            }
        }
        return null;
        
    }

    public Set printFacCab() {

        Set<FDetalle> lista = new HashSet<>();

        try {

            String sql = "SELECT * FROM \"Factura_Cabecera\";";
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
