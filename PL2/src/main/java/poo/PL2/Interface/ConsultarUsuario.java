/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package poo.PL2.Interface;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import poo.PL2.Clases.Cliente;
import poo.PL2.Clases.DataBase;
import poo.PL2.Clases.Navegacion;


public class ConsultarUsuario extends javax.swing.JFrame {
    
    private DefaultTableModel tableModel;
    private List<Cliente> clientesMostrados;

    /**
     * Creates new form ConsultarUsuario
     */
    public ConsultarUsuario() {
        initComponents();
        configurarVentana();
        inicializarTabla();
        cargarTodosClientes();
        configurarComponentes();
        agregarListeners();
        configurarDobleClickTabla();
    }
    
    private void configurarVentana() {
        this.setLocationRelativeTo(null); // Centra la ventana
        bloquearCampos();
    }
    
    private void configurarComponentes() {
        jTableUsuarios.setToolTipText("Haga doble click sobre un cliente para más información");
        jCheckBoxNombre.setToolTipText("Dejar vacío para ignorar este filtro");
        jCheckBoxCorreo.setToolTipText("Dejar vacío para ignorar este filtro");
        
        UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 12));
    }
    
    private void bloquearCampos() {
        jTextFieldNombre.setEnabled(false);
        jTextFieldCorreo.setEnabled(false);
        jCheckBoxUsuarios.setEnabled(false);
        
        jCheckBoxNombre.setSelected(false);
        jCheckBoxCorreo.setSelected(false);
        jCheckBoxUsuarios.setSelected(false);
    }
    
    private void resetearFiltros() {
        jTextFieldNombre.setText("");
        jTextFieldCorreo.setText("");
        jCheckBoxUsuarios.setSelected(false);
        
        bloquearCampos();
        cargarTodosClientes();
    }
    
    private void inicializarTabla() {
        tableModel = (DefaultTableModel) jTableUsuarios.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new String[]{"Correo", "Nombre", "VIP"});
        jTableUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void cargarTodosClientes() {
        DataBase db = DataBase.getInstance();
        clientesMostrados = new ArrayList<>(db.getClientes().values());
        actualizarTabla();
    }
    
    private void actualizarTabla() {
        tableModel.setRowCount(0);
        
        for (Cliente cliente : clientesMostrados) {
            Object[] fila = {
                cliente.getCorreo(),
                cliente.getNombre(),
                cliente.isVip() ? "Sí" : "No"
            };
            tableModel.addRow(fila);
        }
    }
    
    private void agregarListeners() {
        // Listener para campos de texto
        DocumentListener documentListener = new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { aplicarFiltros(); }
            @Override public void removeUpdate(DocumentEvent e) { aplicarFiltros(); }
            @Override public void changedUpdate(DocumentEvent e) { aplicarFiltros(); }
        };
        
        jTextFieldNombre.getDocument().addDocumentListener(documentListener);
        jTextFieldCorreo.getDocument().addDocumentListener(documentListener);
        
        // Listeners para checkboxes
        jCheckBoxNombre.addActionListener(e -> toggleFiltro(jTextFieldNombre, jCheckBoxNombre));
        jCheckBoxCorreo.addActionListener(e -> toggleFiltro(jTextFieldCorreo, jCheckBoxCorreo));
        jCheckBoxUsuarios.addActionListener(e -> {
            jCheckBoxUsuarios.setEnabled(jCheckBoxUsuarios.isSelected());
            aplicarFiltros();
        });
    }
    
    private void configurarDobleClickTabla() {
        jTableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int filaSeleccionada = jTableUsuarios.getSelectedRow();
                    if (filaSeleccionada >= 0) {
                        abrirDetalleCliente(filaSeleccionada);
                    }
                }
            }
        });
    }
    
    private void abrirDetalleCliente(int fila) {
        String correoCliente = (String) tableModel.getValueAt(fila, 0);
        Cliente cliente = DataBase.getInstance().getCliente(correoCliente);

        if (cliente != null) {
            // Aquí abres tu ventana de detalle del cliente
            // COMENTADO DE MOMENTO new MasDatosCliente(cliente).setVisible(true); 
            // O si prefieres mantener esta ventana:
            // this.dispose();
        }
    }
    
    private void toggleFiltro(javax.swing.JTextField componente, javax.swing.JCheckBox checkBox) {
        boolean estaActivo = checkBox.isSelected();
        componente.setEnabled(estaActivo);

        if (!estaActivo) {
            componente.setText("");
        }
        aplicarFiltros();
    }
    
    private void aplicarFiltros() {
        DataBase db = DataBase.getInstance();
        clientesMostrados = new ArrayList<>(db.getClientes().values());
        
        // Filtro por nombre
        if (jCheckBoxNombre.isSelected()) {
            String busqueda = jTextFieldNombre.getText().trim().toLowerCase();
            if (!busqueda.isEmpty()) {
                clientesMostrados.removeIf(c -> 
                    !c.getNombre().toLowerCase().contains(busqueda)
                );
            }
        }
        
        // Filtro por correo
        if (jCheckBoxCorreo.isSelected()) {
            String busqueda = jTextFieldCorreo.getText().trim().toLowerCase();
            if (!busqueda.isEmpty()) {
                clientesMostrados.removeIf(c -> 
                    !c.getCorreo().toLowerCase().contains(busqueda)
                );
            }
        }
        
        // Filtro por VIP
        if (jCheckBoxUsuarios.isSelected()) {
            clientesMostrados.removeIf(c -> !c.isVip());
        }
        
        actualizarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldCorreo = new javax.swing.JTextField();
        jCheckBoxCorreo = new javax.swing.JCheckBox();
        jCheckBoxNombre = new javax.swing.JCheckBox();
        jCheckBoxUsuarios = new javax.swing.JCheckBox();
        jButtonVolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jButtonReiniciarFiltros = new javax.swing.JButton();
        jComboBoxTipoUsuario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTA DE USUARIOS");

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jTextFieldCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCorreoActionPerformed(evt);
            }
        });

        jCheckBoxCorreo.setText("Correo");
        jCheckBoxCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCorreoActionPerformed(evt);
            }
        });

        jCheckBoxNombre.setText("Nombre");
        jCheckBoxNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNombreActionPerformed(evt);
            }
        });

        jCheckBoxUsuarios.setText("Usuarios");
        jCheckBoxUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxUsuariosActionPerformed(evt);
            }
        });

        jButtonVolver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonVolver.setText("VOLVER");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Correo", "Nombre", "VIP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUsuarios.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTableUsuarios);
        jTableUsuarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableUsuarios.getColumnModel().getColumnCount() > 0) {
            jTableUsuarios.getColumnModel().getColumn(0).setResizable(false);
            jTableUsuarios.getColumnModel().getColumn(1).setResizable(false);
            jTableUsuarios.getColumnModel().getColumn(2).setResizable(false);
        }

        jButtonReiniciarFiltros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonReiniciarFiltros.setText("REINICIAR FILTROS");
        jButtonReiniciarFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReiniciarFiltrosActionPerformed(evt);
            }
        });

        jComboBoxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Solo VIP", "Solo no VIP" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonVolver)
                        .addGap(204, 204, 204)
                        .addComponent(jButtonReiniciarFiltros))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(jTextFieldCorreo)
                            .addComponent(jComboBoxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxCorreo)
                    .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxUsuarios)
                    .addComponent(jComboBoxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVolver)
                    .addComponent(jButtonReiniciarFiltros))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxCorreoActionPerformed

    private void jCheckBoxNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxNombreActionPerformed

    private void jTextFieldCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCorreoActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        // TODO add your handling code here:
        Navegacion.cambiarVentana(this, new PortalAdministrador()); // Volver
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jButtonReiniciarFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReiniciarFiltrosActionPerformed
        // TODO add your handling code here:
        resetearFiltros();
        JOptionPane.showMessageDialog(this, "Todos los filtros han sido restablecidos");
    }//GEN-LAST:event_jButtonReiniciarFiltrosActionPerformed

    private void jCheckBoxUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReiniciarFiltros;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JCheckBox jCheckBoxCorreo;
    private javax.swing.JCheckBox jCheckBoxNombre;
    private javax.swing.JCheckBox jCheckBoxUsuarios;
    private javax.swing.JComboBox<String> jComboBoxTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField jTextFieldCorreo;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
