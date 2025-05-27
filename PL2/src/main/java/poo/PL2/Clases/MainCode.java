
package poo.PL2.Clases;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
        
        
        
        
        // 1. Concierto en Madrid (precio medio)
        dataBase.guardarEvento(new Evento(
            "Concierto Rock 2023",
            "CONCIERTO",
            ValidadorUtilidades.crearFechas("15/11/2023 20:00", "16/11/2023 20:00"),
            new Direccion("Calle Gran Vía", "1", "Madrid", "28013"),
            25.50,
            "data/imagenesEventos/rock.png"
        ));

        // 2. Teatro clásico en Barcelona (precio alto)
        dataBase.guardarEvento(new Evento(
            "Don Juan Tenorio",
            "TEATRO",
            ValidadorUtilidades.crearFechas("20/10/2023 19:30", "21/10/2023 19:30", "22/10/2023 18:00"),
            new Direccion("Plaza Catalunya", "5", "Barcelona", "08002"),
            45.00,
            "data/imagenesEventos/teatro.png"
        ));

        // 3. Festival gastronómico en Sevilla (precio bajo)
        dataBase.guardarEvento(new Evento(
            "Feria de Abril",
            "FESTIVAL CULTURAL",
            ValidadorUtilidades.crearFechas("01/04/2024 12:00", "07/04/2024 12:00"),
            new Direccion("Calle del Infierno", "s/n", "Sevilla", "41001"),
            10.00,
            "data/imagenesEventos/feria.png"
        ));

        // 4. Taller tecnológico en Valencia (gratis)
        dataBase.guardarEvento(new Evento(
            "Taller de Inteligencia Artificial",
            "TALLER",
            ValidadorUtilidades.crearFechas("05/12/2023 16:00"),
            new Direccion("Avenida Blasco Ibáñez", "13", "Valencia", "46010"),
            0.00,
            "data/imagenesEventos/taller.png"
        ));

        // 5. Partido de fútbol en Madrid (precio alto)
        dataBase.guardarEvento(new Evento(
            "Real Madrid vs Barcelona",
            "DEPORTE",
            ValidadorUtilidades.crearFechas("12/11/2023 21:00"),
            new Direccion("Avda. Concha Espina", "1", "Madrid", "28036"),
            120.00,
            "data/imagenesEventos/futbol.png"
        ));

        // 6. Concierto jazz en Bilbao (precio medio)
        dataBase.guardarEvento(new Evento(
            "Jazz en la Ría",
            "CONCIERTO",
            ValidadorUtilidades.crearFechas("30/09/2023 22:00"),
            new Direccion("Plaza Arriaga", "1", "Bilbao", "48005"),
            35.00,
            "data/imagenesEventos/jazz.png"
        ));

        // 7. Cine al aire libre en Málaga (precio simbólico)
        dataBase.guardarEvento(new Evento(
            "Cine de Verano",
            "CINE",
            ValidadorUtilidades.crearFechas("15/07/2023 22:30", "16/07/2023 22:30"),
            new Direccion("Paseo Marítimo", "s/n", "Málaga", "29016"),
            5.50,
            "data/imagenesEventos/cine.png"
        ));

        // 8. Musical en Madrid (precio alto)
        dataBase.guardarEvento(new Evento(
            "El Rey León",
            "MUSICAL",
            ValidadorUtilidades.crearFechas("01/12/2023 18:00", "02/12/2023 18:00", "03/12/2023 12:00"),
            new Direccion("Calle Jorge Juan", "5", "Madrid", "28009"),
            65.00,
            "data/imagenesEventos/musical.png"
        ));

        // 9. Evento con nombre compuesto y ciudad con acento
        dataBase.guardarEvento(new Evento(
            "Feria del Libro Antiguo",
            "FESTIVAL CULTURAL",
            ValidadorUtilidades.crearFechas("10/11/2023 10:00", "11/11/2023 10:00"),
            new Direccion("Plaza Mayor", "s/n", "Valladolid", "47001"),
            8.00,
            "data/imagenesEventos/libros.png"
        ));

        // 10. Evento con múltiples palabras en título
        dataBase.guardarEvento(new Evento(
            "Exposición de Arte Contemporáneo Internacional",
            "FESTIVAL CULTURAL",
            ValidadorUtilidades.crearFechas("05/10/2023 09:00", "30/10/2023 21:00"),
            new Direccion("Calle Bailén", "12", "Zaragoza", "50001"),
            12.00,
            "data/imagenesEventos/arte.png"
        ));
        
        
        */
        

        // TEST: Verificar si hay eventos (solo para depuración)
        System.out.println("Eventos en la base: " + dataBase.getEventos().size());
        
        /*
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
        
        */
        
        List<Reserva> reservas = dataBase.getReservasPorCliente("genocida@gmail.com");
        Reserva reserva = reservas.getFirst();
        System.out.println(reserva.getEvento().getTitulo());
        System.out.println(reserva.getCodigoFactura());
        
        
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
            
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainCode.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(MainCode.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(MainCode.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(MainCode.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            mainMenu.setVisible(true);
            
        });
        
        
    }
}
    

