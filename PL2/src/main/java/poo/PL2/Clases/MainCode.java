
package poo.PL2.Clases;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.YearMonth;
import poo.PL2.Interface.*;


public class MainCode {

    
    public static void main(String[] args) throws ClassNotFoundException {
        
        //CARGA LA BASE DE DATOS
        
        try {
            // Intenta cargar la base de datos existente
            DataBase.cargar("C:\\Users\\User\\Documents\\NetBeansProjects\\PL2-programacion\\PL2\\src\\main\\java\\poo\\PL2\\Clases\\DataBase\\MiBaseDeDatos.ser");
        } catch (IOException e) {
            // Si falla (primera ejecución o archivo no existe), crea una nueva
            System.out.println("Creando nueva base de datos...");
        }
             
        
        DataBase dataBase = DataBase.getInstance();

        /*
        //Evento evento1 = new Evento("Pachanga","Deportivo","Chopera",LocalDate.now().plusDays(3),3.5,"Guadalajara");
        Direccion direccion1 = new Direccion("Calle txapote","12","Guadalajara","19005");
        TarjetaCredito tarjeta1 = new TarjetaCredito("Hitler","1234 5678 1234 5678",YearMonth.of(2024, 10));
        Cliente cliente1 = new Cliente("Lasersub","666699669",direccion1,tarjeta1,true,"matajudios@gmail.com","mainEdgar");
        //Reserva reserva1 = new Reserva(cliente1, evento1, evento1.getFecha(),2,7);
        
        //Evento evento2 = new Evento("QuemenRenfe","EventoCultural","Atocha",LocalDate.now().plusDays(9),0,"Madrid");
        Direccion direccion2 = new Direccion("Calle PerroSanchez","69","Madrid","91110");
        TarjetaCredito tarjeta2 = new TarjetaCredito("Benito Mussolini","1234 5678 1234 5678",YearMonth.of(2025, 10));
        Cliente cliente2 = new Cliente("HappyMerchant","666699669",direccion2,tarjeta2,false,"genocida@gmail.com","AdamVieneAPorTi");
        //Reserva reserva2 = new Reserva(cliente2, evento2, evento2.getFecha(),2,7);
        
        dataBase.addCliente(cliente1);
        
        
        dataBase.addCliente(cliente2);
        
        */
        
        
        
         Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                DataBase.guardar("C:\\Users\\User\\Documents\\NetBeansProjects\\PL2-programacion\\PL2\\src\\main\\java\\poo\\PL2\\Clases\\DataBase\\MiBaseDeDatos.ser");
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
    

