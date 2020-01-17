/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.CategoriaProducto;
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
    
    }
    
    //public void Buscar()
    
}
