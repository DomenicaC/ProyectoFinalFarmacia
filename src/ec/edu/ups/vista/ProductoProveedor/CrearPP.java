/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista.ProductoProveedor;

import ec.edu.ups.controlador.CategoriaControlador;
import ec.edu.ups.controlador.ControladorProducto;
import ec.edu.ups.controlador.ProvProdControlador;
import ec.edu.ups.controlador.ProveedorControlador;
import ec.edu.ups.controlador.UnidadesControlador;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.ProductoProveedor;
import ec.edu.ups.modelo.Proveedor;
import ec.edu.ups.vista.Principal.Administrador;
import static ec.edu.ups.vista.Principal.Administrador.desktop;
import ec.edu.ups.vista.Producto.CrearProducto;
import ec.edu.ups.vista.Proveedor.CrearProveedor;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Guillermo Quinde
 */
public class CrearPP extends javax.swing.JInternalFrame {

    /**
     * Creates new form CrearPP
     */
    public static String x;
    private static ControladorProducto controladorProducto;
    private static ProveedorControlador proveedorControlador;
    private UnidadesControlador unidadesControlador;
    private CategoriaControlador categoriaControlador;
    private ProvProdControlador provProdControlador;
    private CrearProveedor  crearProveedor;
    private CrearProducto crearProducto;
    String proveedor;
    public CrearPP(ControladorProducto controladorProducto,ProveedorControlador proveedorControlador,ProvProdControlador provProdControlador,CategoriaControlador categoriaControlador,UnidadesControlador unidadesControlador) throws Exception {
        initComponents();
        x = "x";
        int a = Administrador.desktop.getWidth() - this.getWidth();
        int b = Administrador.desktop.getHeight() - this.getHeight();

        setLocation(a / 2, b / 2);
        setVisible(true);
        
        this.controladorProducto=controladorProducto;
        this.proveedorControlador=proveedorControlador;
        this.provProdControlador=provProdControlador;
        this.unidadesControlador=unidadesControlador;
        this.categoriaControlador=categoriaControlador;
        mostrarProveedores();
        habilitar();
        
        
        
    }
    public static String fechaActual() {

        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYY");
        return formatoFecha.format(fecha);

    }
    public void habilitar() throws Exception{
        int codigo=provProdControlador.buscarUltimoCodigo()+1;
        txtId.setText(String.valueOf(codigo));
        txtFecha.setText(fechaActual());
        txtCant.enable(true);
        txtNumFac.enable(true);
        mostrarProductos();
    }
    public static void mostrarProveedores() throws Exception{
        Set<Proveedor> list = proveedorControlador.listaProveedor();
        for (Proveedor p: list) {
            ComboProveedores.addItem(p.getNombre());
        }  
    }
     public static void mostrarProductos() throws Exception{
        Set<Producto> list = controladorProducto.listaProductos();
        for (Producto p: list) {
            ComboProductor.addItem(p.getNombre());
        }  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JToggleButton();
        btnCancelar = new javax.swing.JToggleButton();
        txtId = new javax.swing.JTextField();
        txtNumFac = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtCant = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ComboProveedores = new javax.swing.JComboBox();
        btnCrearProveedor = new javax.swing.JToggleButton();
        ComboProductor = new javax.swing.JComboBox();
        btnCrearProdudcto = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REGISTRO DE LLEGADA DE PRODUCTOS");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel4.setText("REGISTRO DE PROVEEDOR-PRODUCTO");

        jLabel5.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel5.setText("Id:");

        jLabel6.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel6.setText("Numero Factura:");

        jLabel7.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel7.setText("Cantidad:");

        jLabel8.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel8.setText("Fecha llegada:");

        btnCrear.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        btnCrear.setText("Registrar ");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtId.setEditable(false);

        txtNumFac.setEnabled(false);
        txtNumFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumFacActionPerformed(evt);
            }
        });

        txtFecha.setEnabled(false);

        txtCant.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel9.setText("Producto:");

        jLabel10.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel10.setText("Proveedor:");

        ComboProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboProveedoresActionPerformed(evt);
            }
        });

        btnCrearProveedor.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        btnCrearProveedor.setText("Crear Proveedor");
        btnCrearProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProveedorActionPerformed(evt);
            }
        });

        btnCrearProdudcto.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        btnCrearProdudcto.setText("Crear Producto");
        btnCrearProdudcto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProdudctoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel5))
                                    .addGap(52, 52, 52)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNumFac, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(64, 64, 64)
                                    .addComponent(ComboProductor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(287, 287, 287)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ComboProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnCrearProdudcto, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnCrearProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(btnCrear)
                        .addGap(61, 61, 61)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ComboProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearProveedor))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNumFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ComboProductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearProdudcto))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        ProductoProveedor  pp=new ProductoProveedor();
        pp.setId(Integer.parseInt(txtId.getText()));
        String fecha = txtFecha.getText();
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        Date f = null;
        try {
            f = sf.parse(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        pp.setFechaLlegada(f);
        pp.setNroFActura(txtNumFac.getText());
        pp.setCantidad(Integer.parseInt(txtCant.getText()));
        String producto=(String) ComboProductor.getSelectedItem();
        proveedor=(String) ComboProveedores.getSelectedItem();
        Proveedor p=proveedorControlador.BuscarProveedorNombre(proveedor);
        Producto pr=controladorProducto.BuscarNombre(producto);
        pp.setProducto(pr);
        pp.setProveedor(p);
        
        provProdControlador.createProvProd(pp);
        int cantidad=Integer.parseInt(txtCant.getText());
         try {
             controladorProducto.modificarStock(pr,cantidad);
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
         JOptionPane.showMessageDialog(this, "Registro Producto-Proveedor Satisfactorio", "Registrar Producto-Proveedor", JOptionPane.OK_OPTION);
        
         try {
             habilitar();
         } catch (Exception ex) {
             ex.printStackTrace();
         }
        txtCant.setText("");
        txtNumFac.setText("");
        
      
        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnCrearProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProveedorActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
             String x = crearProveedor.x;
        try {
            if (x == null) {
                if (crearProveedor == null || crearProveedor.isVisible() == false) {
                    crearProveedor = new CrearProveedor(proveedorControlador);
                    desktop.add(crearProveedor);
                    crearProveedor.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnCrearProveedorActionPerformed

    private void btnCrearProdudctoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProdudctoActionPerformed
        // TODO add your handling code here:
              String x = crearProducto.x;
        try {
            if (x == null) {
                if (crearProducto == null || crearProducto.isVisible() == false) {
                    crearProducto = new CrearProducto(controladorProducto, categoriaControlador,unidadesControlador);
                    desktop.add(crearProducto);
                    crearProducto.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCrearProdudctoActionPerformed

    private void txtNumFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumFacActionPerformed

    private void ComboProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboProveedoresActionPerformed
        // TODO add your handling code here:
        
         
    }//GEN-LAST:event_ComboProveedoresActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        x = null;
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox ComboProductor;
    public static javax.swing.JComboBox ComboProveedores;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnCrear;
    private javax.swing.JToggleButton btnCrearProdudcto;
    private javax.swing.JToggleButton btnCrearProveedor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNumFac;
    // End of variables declaration//GEN-END:variables
}
