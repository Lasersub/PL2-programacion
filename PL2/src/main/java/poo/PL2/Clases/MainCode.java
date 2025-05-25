
package poo.PL2.Clases;

import java.io.File;
import java.io.IOException;
import java.time.YearMonth;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import poo.PL2.Interface.*;


public class MainCode {

    
    public static void main(String[] args) throws ClassNotFoundException {
        
        //CARGA LA BASE DE DATOS
        
        // Crear carpetas si no existen
        new File("data/database").mkdirs();
        new File("data/facturas").mkdirs();
        new File("data/imagenesEventos").mkdirs();

        String dbPath = System.getProperty("user.dir") + "/data/database/MiBaseDeDatos.ser";

        // Cargar o inicializar la base de datos
        DataBase dataBase;
        try {
            DataBase.cargar(dbPath);
            System.out.println("Base de datos cargada exitosamente.");
        } catch (IOException e) {
            System.out.println("Creando nueva base de datos...");
            // No necesitamos hacer nada más, el singleton ya está inicializado
        }

        dataBase = DataBase.getInstance();
        
        /*
        Direccion direccion1 = new Direccion("Calle txapote","12","Guadalajara","19005");
        TarjetaCredito tarjeta1 = new TarjetaCredito("Hitler","1234 5678 1234 5678",YearMonth.of(2024, 10));
        Cliente cliente1 = new Cliente("Lasersub","666699669",direccion1,tarjeta1,true,"matajudios@gmail.com","mainEdgar");
        
        
        
        Direccion direccion2 = new Direccion("Calle PerroSanchez","69","Madrid","91110");
        TarjetaCredito tarjeta2 = new TarjetaCredito("Benito Mussolini","1234 5678 1234 5678",YearMonth.of(2025, 10));
        Cliente cliente2 = new Cliente("HappyMerchant","666699669",direccion2,tarjeta2,false,"genocida@gmail.com","AdamVieneAPorTi");
        
        dataBase.addCliente(cliente1);
        dataBase.addCliente(cliente2);
        */
        
        // TEST: Verificar si hay eventos (solo para depuración)
        System.out.println("Eventos en la base: " + dataBase.getEventos().size());

        // Prueba de obtener evento (solo si existe)
        Evento evento = dataBase.getEventoPorTitulo("historia");
        if (evento != null) {
            System.out.println("Evento encontrado: " + evento.getTipo());

            // Mostrar imagen del evento
            ImageIcon icono = evento.cargarImagenPortada(500, 300);

            JFrame frame = new JFrame("Prueba de Imagen");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel label = new JLabel();
            if (icono != null) {
                label.setIcon(icono);
            } else {
                label.setIcon(new ImageIcon("src/main/resources/imagenes/placeholder.png"));
                label.setText("Imagen no encontrada");
            }

            frame.add(label);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            System.out.println("Ruta completa: " + evento.obtenerRutaAbsolutaPortada());
        } else {
            System.out.println("El evento 'historia' no existe en la base de datos.");
        }
        
        
        
        
         Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                DataBase.guardar(dbPath);
                System.out.println("Base de datos guardada al cerrar la aplicación.");
            } catch (IOException ex) {
                System.err.println("Error guardando la base de datos: " + ex.getMessage());
            }
        }));
         
         
        // Iniciar la interfaz (sin WindowListener en MainMenu)
        java.awt.EventQueue.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // ¡Importante!
            mainMenu.setVisible(true);
        });
        
        
    }
}
    

