
package poo.PL2.Interface;

import java.awt.Font;
import javax.swing.UIManager;
import poo.PL2.Clases.Navegacion;


public class BuscarEvento extends javax.swing.JFrame {


    public BuscarEvento() {
        initComponents();
        configurarComponentes();
        
        this.setLocationRelativeTo(null); // Centra la ventana
       
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldFechaEvento = new javax.swing.JFormattedTextField();
        jComboBoxTipoEvento = new javax.swing.JComboBox<>();
        jCheckBoxTitulo = new javax.swing.JCheckBox();
        jCheckBoxCiudad = new javax.swing.JCheckBox();
        jComboBoxRangoPrecioEntrada = new javax.swing.JComboBox<>();
        jCheckBoxFechaEvento = new javax.swing.JCheckBox();
        jCheckBoxTipoEvento = new javax.swing.JCheckBox();
        jTextFieldTitulo = new javax.swing.JTextField();
        jCheckBoxPrecioEntrada = new javax.swing.JCheckBox();
        jTextFieldCiudad = new javax.swing.JTextField();
        jButtonVolver = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBoxRangoPrecioEntrada1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEventos = new javax.swing.JTable();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BUSCADOR");

        try {
            jFormattedTextFieldFechaEvento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldFechaEvento.setText("00/00/0000 00:00");
        jFormattedTextFieldFechaEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldFechaEventoActionPerformed(evt);
            }
        });

        jComboBoxTipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONCIERTO", "DEPORTE", "MUSICAL", "TEATRO", "FESTIVAL CULTURAL", "CINE", "TALLER" }));
        jComboBoxTipoEvento.setToolTipText("");
        jComboBoxTipoEvento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxTipoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoEventoActionPerformed(evt);
            }
        });

        jCheckBoxTitulo.setText("TÍTULO");
        jCheckBoxTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxTituloActionPerformed(evt);
            }
        });

        jCheckBoxCiudad.setText("CIUDAD");
        jCheckBoxCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCiudadActionPerformed(evt);
            }
        });

        jComboBoxRangoPrecioEntrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 - 10€", "11 - 20€", "21 - 30€", "+ 30€" }));

        jCheckBoxFechaEvento.setText("FECHA");

        jCheckBoxTipoEvento.setText("TIPO");
        jCheckBoxTipoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxTipoEventoActionPerformed(evt);
            }
        });

        jTextFieldTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTituloActionPerformed(evt);
            }
        });

        jCheckBoxPrecioEntrada.setText("PRECIO");
        jCheckBoxPrecioEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPrecioEntradaActionPerformed(evt);
            }
        });

        jTextFieldCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCiudadActionPerformed(evt);
            }
        });

        jButtonVolver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonVolver.setText("VOLVER");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jCheckBox1.setText("CALIFICACION");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jComboBoxRangoPrecioEntrada1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Más de 0", "Más de 1", "Más de 2", "Más de 3", "Más de 4" }));
        jComboBoxRangoPrecioEntrada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRangoPrecioEntrada1ActionPerformed(evt);
            }
        });

        jTableEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Titulo", "Calificación", "Ciudad", "Precio", "Fecha", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEventos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableEventos);
        if (jTableEventos.getColumnModel().getColumnCount() > 0) {
            jTableEventos.getColumnModel().getColumn(0).setResizable(false);
            jTableEventos.getColumnModel().getColumn(1).setResizable(false);
            jTableEventos.getColumnModel().getColumn(2).setResizable(false);
            jTableEventos.getColumnModel().getColumn(3).setResizable(false);
            jTableEventos.getColumnModel().getColumn(4).setResizable(false);
            jTableEventos.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxCiudad)
                            .addComponent(jCheckBoxTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(jComboBoxTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTitulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBoxPrecioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxFechaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 102, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldFechaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(96, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxRangoPrecioEntrada1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxRangoPrecioEntrada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonVolver)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxTitulo)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jComboBoxRangoPrecioEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxPrecioEntrada)
                    .addComponent(jComboBoxRangoPrecioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCiudad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxTipoEvento)
                    .addComponent(jCheckBoxFechaEvento)
                    .addComponent(jFormattedTextFieldFechaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButtonVolver)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configurarComponentes() {
        jTableEventos.setToolTipText("Haga doble click sobre un evento para más información"); 
        
        UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 12));  // Fuente personalizada
    }
    
    
    private void jCheckBoxTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxTituloActionPerformed

    private void jTextFieldTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTituloActionPerformed

    private void jCheckBoxPrecioEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPrecioEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxPrecioEntradaActionPerformed

    private void jCheckBoxCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxCiudadActionPerformed

    private void jTextFieldCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCiudadActionPerformed

    private void jCheckBoxTipoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxTipoEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxTipoEventoActionPerformed

    private void jFormattedTextFieldFechaEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldFechaEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldFechaEventoActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        // TODO add your handling code here:
        // Navegacion.cambiarVentana(this, new PortalCliente()); // Volver
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jComboBoxTipoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoEventoActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jComboBoxRangoPrecioEntrada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRangoPrecioEntrada1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRangoPrecioEntrada1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxCiudad;
    private javax.swing.JCheckBox jCheckBoxFechaEvento;
    private javax.swing.JCheckBox jCheckBoxPrecioEntrada;
    private javax.swing.JCheckBox jCheckBoxTipoEvento;
    private javax.swing.JCheckBox jCheckBoxTitulo;
    private javax.swing.JComboBox<String> jComboBoxRangoPrecioEntrada;
    private javax.swing.JComboBox<String> jComboBoxRangoPrecioEntrada1;
    private javax.swing.JComboBox<String> jComboBoxTipoEvento;
    private javax.swing.JFormattedTextField jFormattedTextFieldFechaEvento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEventos;
    private javax.swing.JTextField jTextFieldCiudad;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
