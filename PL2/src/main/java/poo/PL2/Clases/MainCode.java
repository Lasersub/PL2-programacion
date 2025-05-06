
package poo.PL2.Clases;

import java.io.IOException;
import java.time.LocalDate;


public class MainCode {

    
    public static void main(String[] args) throws ClassNotFoundException {
        
        //CARGA LA BASE DE DATOS
        
        DataBase miBaseDeDatos = new DataBase();
        
        try {
            // Intenta cargar la base de datos existente
            miBaseDeDatos = DataBase.cargar("C:\\Users\\User\\Documents\\NetBeansProjects\\PL2-programacion\\PL2\\src\\main\\java\\poo\\PL2\\Clases\\DataBase\\MiBaseDeDatos.ser");
        } catch (IOException e) {
            // Si falla (primera ejecución o archivo no existe), crea una nueva
            System.out.println("Creando nueva base de datos...");
            miBaseDeDatos = new DataBase();
        }
        
        
        
        Evento evento1 = new Evento("Pachanga","Deportivo","Chopera",LocalDate.now().plusDays(3),3.5,"Guadalajara");
        Direccion direccion1 = new Direccion("Calle txapote","12","Guadalajara","19005");
        TarjetaCredito tarjeta1 = new TarjetaCredito("Hitler","1234 5678 1234 5678",LocalDate.of(2024, 10, 12));
        Cliente cliente1 = new Cliente("Lasersub","666699669",direccion1,tarjeta1,true,"matajudios@gmail.com","mainEdgar");
        Reserva reserva1 = new Reserva(cliente1, evento1, evento1.getFecha(),2,7);
        
        Evento evento2 = new Evento("QuemenRenfe","EventoCultural","Atocha",LocalDate.now().plusDays(9),0,"Madrid");
        Direccion direccion2 = new Direccion("Calle PerroSanchez","69","Madrid","91110");
        TarjetaCredito tarjeta2 = new TarjetaCredito("Benito Mussolini","1234 5678 1234 5678",LocalDate.of(2024, 10, 12));
        Cliente cliente2 = new Cliente("HappyMerchant","666699669",direccion2,tarjeta2,false,"genocida@gmail.com","AdamVieneAPorTi");
        Reserva reserva2 = new Reserva(cliente2, evento2, evento2.getFecha(),2,7);
        
        miBaseDeDatos.addCliente(cliente1);
        miBaseDeDatos.addEvento(evento1);
        miBaseDeDatos.addReserva(reserva1);
        
        miBaseDeDatos.addCliente(cliente2);
        miBaseDeDatos.addEvento(evento2);
        miBaseDeDatos.addReserva(reserva2);
        
        System.out.println(miBaseDeDatos.getCliente("matajudios@gmail.com").getNombre());
        System.out.println(miBaseDeDatos.getCliente("genocida@gmail.com").getNombre());
        
        
        //GUARDA LA BASE DE DATOS
        try {
            DataBase.guardar(miBaseDeDatos,"C:\\Users\\User\\Documents\\NetBeansProjects\\PL2-programacion\\PL2\\src\\main\\java\\poo\\PL2\\Clases\\DataBase\\MiBaseDeDatos.ser");
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        
        
    }   
}
