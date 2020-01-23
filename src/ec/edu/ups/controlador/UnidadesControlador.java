/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.UnidadMedida;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Edison
 */
public class UnidadesControlador {
    
    private BaseDeDatos db;

    public UnidadesControlador(String url ,String user, String password) {
        db = new BaseDeDatos(url,user,password);
    }
     
    public UnidadMedida Buscaar(int id)  {
        UnidadMedida un = new UnidadMedida();
        try {

            String sql = "SELECT * FROM \"SDF_UNIDADES_MEDIDAS\" WHERE med_id =" + id + "";
            System.out.println("Base " + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

          res.next();

                un.setId(id);
                un.setNombre(res.getString("med_nombre")); 
                System.out.println(un.toString());
                
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {

            error.printStackTrace();

        }
      
        return un;
    }
}