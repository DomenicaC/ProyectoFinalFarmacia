/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.CategoriaProducto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Edison
 */
public class CategoriaControlador {
    
    private int codigo;
    
    
    private BaseDeDatos db;

    public CategoriaControlador(String url ,String user, String password) {      
         db= new BaseDeDatos(url,user,password);
    }
    
    public void create(CategoriaProducto categoriaProducto){
        String sql = "INSERT INTO \"SDF_CATEGORIAS\" VALUES(" + categoriaProducto.getId() + ","
                + "'" + categoriaProducto.getNombre() + "')";
        System.out.println(sql);
        
         db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            sta.execute(sql);
            db.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }public CategoriaProducto Buscar(int id){
        CategoriaProducto cat = new CategoriaProducto();
        try {

            String sql = "SELECT * FROM \"SDF_CATEGORIAS\" WHERE cat_id =" + id;
            System.out.println("Base " + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

          res.next();

                cat.setId(id);
                cat.setNombre(res.getString("CAT_NOMBRE"));
                System.out.println(cat.toString());
                
            
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {

            error.printStackTrace();

        }
      
        return cat;
    }
    
    public void eliminar(int id){
        
    }
}
