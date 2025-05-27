package poo.PL2.Interface;

import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import poo.PL2.Clases.Cliente;
import poo.PL2.Clases.DataBase;
import poo.PL2.Clases.Navegacion;
import poo.PL2.Clases.Reserva;
public class ConsultarEventosAtendidos extends javax.swing.JFrame {
    
    private Cliente cliente;
    private DefaultTableModel tableModel;
    
    /**
     * Creates new form ConsultarReserva
     */
    public ConsultarEventosAtendidos(Cliente cliente) {
        this.cliente = cliente;
        
        initComponents();
        configurarComponentes();
        
        this.setLocationRelativeTo(null); // Centra la ventana
        
        jTableEventosAtendidos.setEnabled(false);
        
        Navegacion.ponerLogo(jLabelJavaEvents, jLabelJavaEvents1);
        
        // Configurar el modelo de la tabla
        configurarTabla();
        
        // Configurar DocumentListener para el campo de fecha
        configurarDocumentListener();
        
        // Cargar todas las reservas inicialmente
        cargarReservas(null);
    
    }
    
    /**
     * Configura el DocumentListener para el campo de fecha
     */
    private void configurarDocumentListener() {
        jFormattedTextFieldFechaReserva.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                procesarCambioFecha();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                procesarCambioFecha();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                procesarCambioFecha();
            }
            
            private void procesarCambioFecha() {
                LocalDate fecha = parsearFecha();
                // Solo filtrar si la fecha es válida o es null (campo vacío)
                if (fecha != null || jFormattedTextFieldFechaReserva.getText().trim().isEmpty() || 
                    jFormattedTextFieldFechaReserva.getText().equals("00/00/0000")) {
                    cargarReservas(fecha);
                }
            }
        });
    }
    
        
    /**
     * Configura el modelo de la tabla
     */
    private void configurarTabla() {
        tableModel = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Título del evento", "Fecha", "Precio", "Código de la factura"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas no sean editables
            }
        };
        
        jTableEventosAtendidos.setModel(tableModel);
    }  
    
    /**
     * Carga las reservas del cliente, opcionalmente filtrando por fecha mínima
     * @param fechaMinima Fecha mínima para filtrar (null para no filtrar)
     */
    private void cargarReservas(LocalDate fechaMinima) {
        // Limpiar la tabla
        tableModel.setRowCount(0);

        // Obtener las reservas del cliente desde la base de datos
        List<Reserva> reservas = DataBase.getInstance().getReservasPorCliente(cliente.getCorreo());

        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No tienes reservas realizadas.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Formateador de fechas
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Fecha actual para comparar
        LocalDate fechaActual = LocalDate.now();

        // Filtrar y agregar reservas a la tabla
        for (Reserva reserva : reservas) {
            // Solo mostrar eventos PASADOS (fecha anterior a actual)
            if (reserva.getFechaEvento().toLocalDate().isAfter(fechaActual)) {
                continue;
            }

            // Si se especificó fecha mínima y la reserva es anterior a ella, saltarla
            if (fechaMinima != null && reserva.getFechaEvento().toLocalDate().isBefore(fechaMinima)) {
                continue;
            }

            // Agregar fila a la tabla
            tableModel.addRow(new Object[]{
                reserva.getEvento().getTitulo(),
                reserva.getFechaEvento().format(dateTimeFormatter),
                String.format("%.2f €", reserva.getPrecioFinal()),
                reserva.getCodigoFactura()
            });
        }
    }
    
    /**
     * Intenta parsear la fecha del campo de texto
     * @return LocalDate o null si no es válida
     */
    private LocalDate parsearFecha() {
        String fechaStr = jFormattedTextFieldFechaReserva.getText().trim();
    
        if (fechaStr.isEmpty() || fechaStr.equals("00/00/0000")) {
            return null;
        }

        try {
            LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate fechaActual = LocalDate.now();

            // Validar que la fecha no sea futura
            if (fecha.isAfter(fechaActual)) {
                JOptionPane.showMessageDialog(this, 
                    "No puede filtrar por fechas futuras. Introduzca una fecha pasada.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return null;
            }
            return fecha;
        } catch (DateTimeParseException e) {
            return null; // No mostrar mensaje mientras se escribe
        }
    }
    
    private void configurarComponentes() {
        jFormattedTextFieldFechaReserva.setToolTipText("Escriba la fecha mínima a buscar y presione actualizar (DD/MM/AAAA)"); 
        
        UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 12));  // Fuente personalizada
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
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextFieldFechaReserva = new javax.swing.JFormattedTextField();
        jButtonVolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEventosAtendidos = new javax.swing.JTable();
        jLabelJavaEvents = new javax.swing.JLabel();
        jLabelJavaEvents1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTA DE EVENTOS ATENDIDOS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("A partir del ...");

        try {
            jFormattedTextFieldFechaReserva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldFechaReserva.setText("00/00/0000");
        jFormattedTextFieldFechaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldFechaReservaActionPerformed(evt);
            }
        });

        jButtonVolver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonVolver.setText("VOLVER");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jTableEventosAtendidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Título del evento", "Fecha", "Precio", "Codigo de la factura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEventosAtendidos.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTableEventosAtendidos);
        jTableEventosAtendidos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableEventosAtendidos.getColumnModel().getColumnCount() > 0) {
            jTableEventosAtendidos.getColumnModel().getColumn(0).setResizable(false);
            jTableEventosAtendidos.getColumnModel().getColumn(1).setResizable(false);
            jTableEventosAtendidos.getColumnModel().getColumn(2).setResizable(false);
            jTableEventosAtendidos.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabelJavaEvents, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelJavaEvents1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonVolver)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jFormattedTextFieldFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelJavaEvents1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelJavaEvents, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedTextFieldFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 26, Short.MAX_VALUE)
                .addComponent(jButtonVolver)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void jFormattedTextFieldFechaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldFechaReservaActionPerformed
        // TODO add your handling code here:
        LocalDate fecha = parsearFecha();
        cargarReservas(fecha);
    }//GEN-LAST:event_jFormattedTextFieldFechaReservaActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        // TODO add your handling code here:
        Navegacion.cambiarVentana(this, new PortalCliente(cliente)); // Volver
    }//GEN-LAST:event_jButtonVolverActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JFormattedTextField jFormattedTextFieldFechaReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelJavaEvents;
    private javax.swing.JLabel jLabelJavaEvents1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEventosAtendidos;
    // End of variables declaration//GEN-END:variables
}
