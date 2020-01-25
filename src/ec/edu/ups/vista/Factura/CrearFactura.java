/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista.Factura;

import ec.edu.ups.controlador.FCabeceraControlador;
import ec.edu.ups.controlador.PersonaControlador;
import ec.edu.ups.modelo.FCabecera;
import ec.edu.ups.modelo.Personas;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.vista.Principal.Administrador;
import static ec.edu.ups.vista.Producto.CrearProducto.x;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Domenica
 */
public class CrearFactura extends javax.swing.JInternalFrame {

    public static String x;
    private FCabeceraControlador fCabeceraControlador;
    /**
     * Creates new form NewJInternalFramepublic static String x; private
     * FCabeceraControlador fCabeceraControlador;
     */

    private Date fecha;
    private int contador;
    private double totalCP, subtotal, iva, ivaPro, total;
    private DefaultTableModel tablaF;

    //clases
    private Personas per;
    private Producto pro;
    private FCabecera fcab;
    
    //Controladores
    private PersonaControlador personaControlador;

    //Controladores
    public CrearFactura(FCabeceraControlador fCabeceraControlador) {
        initComponents();

        this.fcab = new FCabecera();

        totalCP = 0;
        subtotal = 0;
        iva = 0;
        total = 0;
        tablaF = null;
        pro = null;
        contador = 0;
        ivaPro = 0;

        x = "x";
        int a = Administrador.desktop.getWidth() - this.getWidth();
        int b = Administrador.desktop.getHeight() - this.getHeight();

        setLocation(a / 2, b / 2);
        setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblCedC5 = new javax.swing.JLabel();
        txtCedC = new javax.swing.JTextField();
        btnBuscarCF = new javax.swing.JButton();
        lblCodC5 = new javax.swing.JLabel();
        txtCodC = new javax.swing.JTextField();
        lblNomC5 = new javax.swing.JLabel();
        txtNomC = new javax.swing.JTextField();
        lblTelC5 = new javax.swing.JLabel();
        txtTelC = new javax.swing.JTextField();
        txtApeC = new javax.swing.JTextField();
        lblApeC5 = new javax.swing.JLabel();
        lblDirC5 = new javax.swing.JLabel();
        txtDirC = new javax.swing.JTextField();
        lblRuc = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        lblTot = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        btnCancelarF = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblServF = new javax.swing.JTable();
        btnCrear = new javax.swing.JButton();
        lblSub = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        lblIva = new javax.swing.JLabel();
        lblCodC6 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        lblCedC6 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        txtRol = new javax.swing.JTextField();
        txtNomPro = new javax.swing.JTextField();
        lblCodC7 = new javax.swing.JLabel();
        txtStock2 = new javax.swing.JTextField();
        lblCodC8 = new javax.swing.JLabel();
        btbnBusPro = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel1.setMinimumSize(new java.awt.Dimension(450, 500));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblCedC5.setBackground(new java.awt.Color(255, 255, 255));
        lblCedC5.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblCedC5.setText("Cedula Cliente");

        txtCedC.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N

        btnBuscarCF.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        btnBuscarCF.setText("Buscar");
        btnBuscarCF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCFActionPerformed(evt);
            }
        });

        lblCodC5.setBackground(new java.awt.Color(255, 255, 255));
        lblCodC5.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblCodC5.setText("Codigo Cliente");

        txtCodC.setEditable(false);
        txtCodC.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        txtCodC.setEnabled(false);

        lblNomC5.setBackground(new java.awt.Color(255, 255, 255));
        lblNomC5.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblNomC5.setText("Nombre Cliente");

        txtNomC.setEditable(false);
        txtNomC.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        txtNomC.setEnabled(false);

        lblTelC5.setBackground(new java.awt.Color(255, 255, 255));
        lblTelC5.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblTelC5.setText("Telefono Cliente");

        txtTelC.setEditable(false);
        txtTelC.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        txtTelC.setEnabled(false);

        txtApeC.setEditable(false);
        txtApeC.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        txtApeC.setEnabled(false);

        lblApeC5.setBackground(new java.awt.Color(255, 255, 255));
        lblApeC5.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblApeC5.setText("Apellido Cliente");

        lblDirC5.setBackground(new java.awt.Color(255, 255, 255));
        lblDirC5.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblDirC5.setText("Direccion Cliente");

        txtDirC.setEditable(false);
        txtDirC.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        txtDirC.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTelC5)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelC, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblNomC5)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomC, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblCedC5)
                        .addGap(18, 18, 18)
                        .addComponent(txtCedC, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnBuscarCF)
                        .addGap(18, 18, 18)
                        .addComponent(lblCodC5)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodC, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(lblApeC5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtApeC, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(lblDirC5)
                            .addGap(18, 18, 18)
                            .addComponent(txtDirC, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedC5)
                    .addComponent(txtCedC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCF)
                    .addComponent(lblCodC5)
                    .addComponent(txtCodC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblApeC5)
                        .addComponent(txtApeC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNomC5)
                        .addComponent(txtNomC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDirC5)
                        .addComponent(txtDirC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTelC5)
                        .addComponent(txtTelC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblRuc.setBackground(new java.awt.Color(255, 255, 255));
        lblRuc.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblRuc.setText("RUC Factura");

        txtIva.setEditable(false);
        txtIva.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        txtIva.setEnabled(false);

        txtRuc.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N

        lblTot.setBackground(new java.awt.Color(255, 255, 255));
        lblTot.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblTot.setText("Total");

        lblFecha.setBackground(new java.awt.Color(255, 255, 255));
        lblFecha.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblFecha.setText("Fecha");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        txtTotal.setEnabled(false);

        lblTitulo.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lblTitulo.setText("Crear Factura");

        btnCancelarF.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        btnCancelarF.setText("Cancelar");
        btnCancelarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarFActionPerformed(evt);
            }
        });

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        txtFecha.setEnabled(false);

        tblServF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "0", null, null, null, null}
            },
            new String [] {
                "codigo", "cantidad", "nombre", "precio u", "IvaProducto", "totalIP"
            }
        ));
        tblServF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblServFKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblServF);

        btnCrear.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        lblSub.setBackground(new java.awt.Color(255, 255, 255));
        lblSub.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblSub.setText("Subtotal");

        txtSubtotal.setEditable(false);
        txtSubtotal.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        txtSubtotal.setEnabled(false);

        lblIva.setBackground(new java.awt.Color(255, 255, 255));
        lblIva.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblIva.setText("I.V.A");

        lblCodC6.setBackground(new java.awt.Color(255, 255, 255));
        lblCodC6.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblCodC6.setText("Stock");

        txtStock.setEditable(false);
        txtStock.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        txtStock.setEnabled(false);

        lblCedC6.setBackground(new java.awt.Color(255, 255, 255));
        lblCedC6.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblCedC6.setText("Estado Factura");

        txtEstado.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N

        txtRol.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N

        txtNomPro.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N

        lblCodC7.setBackground(new java.awt.Color(255, 255, 255));
        lblCodC7.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblCodC7.setText("Nombre:");

        txtStock2.setEditable(false);
        txtStock2.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        txtStock2.setEnabled(false);

        lblCodC8.setBackground(new java.awt.Color(255, 255, 255));
        lblCodC8.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblCodC8.setText("Codigo:");

        btbnBusPro.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        btbnBusPro.setText("Buscar");
        btbnBusPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbnBusProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(257, 257, 257))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCedC6)
                                .addGap(18, 18, 18)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCrear)
                                        .addGap(34, 34, 34)
                                        .addComponent(btnCancelarF))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(209, 209, 209)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblSub)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(lblIva)
                                                        .addGap(16, 16, 16)
                                                        .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(lblTot)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addGap(6, 6, 6))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(lblCodC7)
                            .addGap(18, 18, 18)
                            .addComponent(txtNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btbnBusPro)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodC8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtStock2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblCodC6)
                            .addGap(18, 18, 18)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addComponent(lblRuc)
                            .addGap(18, 18, 18)
                            .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblFecha)
                            .addGap(18, 18, 18)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblTitulo)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRuc)
                            .addComponent(lblFecha))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodC6)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodC7)
                    .addComponent(txtNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodC8)
                    .addComponent(txtStock2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btbnBusPro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSub)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblTot))
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCedC6)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrear)
                            .addComponent(btnCancelarF))))
                .addGap(77, 77, 77))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarCFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCFActionPerformed

       
        Personas p = new Personas();
        p = personaControlador.BuscaarPersona(txtCedC.getText());
        
        if (p.getCedula() != null) {
            txtNomC.setText(p.getNombres());
            txtApeC.setText(p.getApellidos());
            txtDirC.setText(p.getDireccion());  
            txtTelC.setText(p.getTelefono());
            txtRol.setText(String.valueOf(p.getRol_id()));
        }else{
            
            JOptionPane.showMessageDialog(this, "La cedula ingresada no esta registrada", "Buscar cedula de persona", JOptionPane.OK_OPTION);
        }
         
    }//GEN-LAST:event_btnBuscarCFActionPerformed

    private void btnCancelarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarFActionPerformed
      
        this.setVisible(false);
        this.dispose();
        x = null;
        
    }//GEN-LAST:event_btnCancelarFActionPerformed

    private void tblServFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblServFKeyReleased

        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            int fila = tblServF.getSelectedRow();
            int columna = tblServF.getSelectedColumn();
            int codigoServ = 0;

            Object[] datos1 = {"", 0, "", "", ""};

            if (columna == 0) {
                codigoServ = Integer.parseInt(tblServF.getValueAt(fila, columna).toString());
                //pro = controladorServicio.read(codigoServ);

                int cant = Integer.parseInt(tblServF.getValueAt(fila, 1).toString());

                tablaF = (DefaultTableModel) tblServF.getModel();
                tablaF.removeRow(fila);

                if (pro.getIva() == 'S') {

                    ivaPro = pro.getPrecio() * 0.12;

                    totalCP = cant * ivaPro;

                    Object[] datos = {codigoServ,
                        cant,
                        pro.getNombre(),
                        pro.getPrecio(),
                        ivaPro,
                        totalCP
                    };

                    tablaF.addRow(datos);
                    tablaF.addRow(datos1);

                } else {
                    ivaPro = 0;
                    totalCP = cant * pro.getPrecio();

                    Object[] datos = {codigoServ,
                        cant,
                        pro.getNombre(),
                        pro.getPrecio(),
                        ivaPro,
                        totalCP
                    };

                    tablaF.addRow(datos);
                    tablaF.addRow(datos1);
                }

            } else if (columna == 1) {

                codigoServ = Integer.parseInt(tblServF.getValueAt(fila, columna - 1).toString());
                int cant = Integer.parseInt(tblServF.getValueAt(fila, columna).toString());
                tablaF.removeRow(fila);
                tablaF.removeRow(tblServF.getRowCount() - 1);

                if (pro.getIva() == 'S') {

                    ivaPro = pro.getPrecio() * 0.12;

                    totalCP = cant * ivaPro;

                    Object[] datos = {codigoServ,
                        cant,
                        pro.getNombre(),
                        pro.getPrecio(),
                        ivaPro,
                        totalCP
                    };

                    tablaF.addRow(datos);
                    tablaF.addRow(datos1);

                } else {
                    ivaPro = 0;
                    totalCP = cant * pro.getPrecio();

                    Object[] datos = {codigoServ,
                        cant,
                        pro.getNombre(),
                        pro.getPrecio(),
                        ivaPro,
                        totalCP
                    };

                    tablaF.addRow(datos);
                    tablaF.addRow(datos1);
                }

            }

            subtotal = subtotal + totalCP;
            txtSubtotal.setText(String.valueOf(subtotal));

            iva = subtotal * 0.12;
            txtIva.setText(String.valueOf(iva));

            total = subtotal + iva;
            txtTotal.setText(String.valueOf(total));

        }

    }//GEN-LAST:event_tblServFKeyReleased

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        /*//obtener fecha
         fecha = new Date();

         //obtener clases
         String cedulaC = txtCedC.getText();
         cliente = controladorCliente.readCedula(cedulaC);

         String cedulaV = txtCedV.getText();
         veterinario = controladorVeterinario.readCedula(cedulaV);

         int codigoM = Integer.parseInt(txtCodM.getText());
         mascota = controladorMascota.read(codigoM);

         //agregarDatos
         factura.setFecha(fecha);

         //clases
         factura.setVet(veterinario);
         factura.setCli(cliente);
         factura.setMasc(mascota);

         //facDetalle
         for (int i = 0; i < tblServF.getRowCount() - 1; i++) {
         System.out.println("i " + i);
         facDet = new FDetalle();

         double cant = Integer.parseInt(tblServF.getValueAt(i, 1).toString());
         int cant1 = (int) cant;
         facDet.setCantidad(cant1);

         //facDet.setCodigo(Integer.parseInt(tblServF.getValueAt(i, 0).toString()));
         //int codigoS = ;
         //facDet.setServ(controladorServicio.read(Integer.parseInt(tblServF.getValueAt(i, 0).toString())));
         facDet.setServ(controladorServicio.read(Integer.parseInt(tblServF.getValueAt(i, 0).toString())));
         factura.añadirFacDetalle(facDet);
         //            controladorFDetalle.create(facDet);

         }

         llenarDatos();
         //factura
         factura.setSubtotal(subtotal);
         factura.setIva(iva);
         factura.setTotal(total);

         controladorFactura.create(factura);
         JOptionPane.showMessageDialog(this, "Factura Creada");
         System.out.println("factura \n" + factura.toString());
         /*
         txtRuc.setText(Integer.toString(controladorFactura.getCodigo()));
         factura.setRuc(Integer.parseInt(txtRuc.getText()));

         int ruc = this.controladorFactura.getCodigo() + 1;
         txtRuc.setText(String.valueOf(ruc));
         txtFecha.setText(controladorFactura.getFecha());

         contador = 0;

         vaciarDatos();
         vaciarTabla();*/
    }//GEN-LAST:event_btnCrearActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btbnBusProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbnBusProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btbnBusProActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbnBusPro;
    private javax.swing.JButton btnBuscarCF;
    private javax.swing.JButton btnCancelarF;
    private javax.swing.JButton btnCrear;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblApeC5;
    private javax.swing.JLabel lblCedC5;
    private javax.swing.JLabel lblCedC6;
    private javax.swing.JLabel lblCodC5;
    private javax.swing.JLabel lblCodC6;
    private javax.swing.JLabel lblCodC7;
    private javax.swing.JLabel lblCodC8;
    private javax.swing.JLabel lblDirC5;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblNomC5;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JLabel lblSub;
    private javax.swing.JLabel lblTelC5;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTot;
    private javax.swing.JTable tblServF;
    private javax.swing.JTextField txtApeC;
    private javax.swing.JTextField txtCedC;
    private javax.swing.JTextField txtCodC;
    private javax.swing.JTextField txtDirC;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNomC;
    private javax.swing.JTextField txtNomPro;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtStock2;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTelC;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
