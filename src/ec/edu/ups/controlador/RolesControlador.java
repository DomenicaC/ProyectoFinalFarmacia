/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

/**
 *
 * @author Edison
 */
public class RolesControlador {
    
      /*public Set Listar() {
        return null;

        Set<Rol> lista = new HashSet<>();
        try {
            String sql = "SELECT * FROM \"ROL\";";
            System.out.println(sql);

            DataBaseConnection.conectar();
            Statement sta =DataBaseConnection.getConexionBD().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                Rol r = new Rol();
                r.setCodigo(rs.getInt("ROL_ID"));
                r.setDescripcion(rs.getString("ROL_DESCRIPCION"));                
                lista.add(r);
            }

            DataBaseConnection.desconectar();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    
    }*/
}
