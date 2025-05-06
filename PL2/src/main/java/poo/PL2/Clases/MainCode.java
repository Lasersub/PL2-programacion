
package poo.PL2.Clases;

import java.io.IOException;
import java.time.LocalDate;


public class MainCode {

    
    public static void main(String[] args) throws ClassNotFoundException {
        
        Evento evento1 = new Evento("Pachanga","Deportivo","Chopera",LocalDate.now().plusDays(3),3.5,"Guadalajara");
        Direccion direccion1 = new Direccion("Calle txapote","12","Guadalajara","19005");
        TarjetaCredito tarjeta1 = new TarjetaCredito("Hitler","1234 5678 1234 5678",LocalDate.of(2024, 10, 12));
        Cliente cliente1 = new Cliente("Lasersub","666699669",direccion1,tarjeta1,true,"matajudios@gmail.com","mainEdgar");
        Reserva reserva1 = new Reserva(cliente1, evento1, evento1.getFecha(),2,7);
        
        DataBase miBaseDeDatos = new DataBase();
        miBaseDeDatos.addCliente(cliente1);
        miBaseDeDatos.addEvento(evento1);
        miBaseDeDatos.addReserva(reserva1);
        
        
        try {
            miBaseDeDatos = DataBase.cargar("C:\\Users\\User\\Documents\\NetBeansProjects\\PL2-programacion\\PL2\\src\\main\\java\\poo\\PL2\\Clases\\DataBase\\MiBaseDeDatos.ser");
        } catch (IOException e) {
            e.printStackTrace(); // o loguea el error o muestra un mensaje
        }
        
        System.out.println(miBaseDeDatos.getCliente("matajudios@gmail.com").getNombre());
    }   
}
