
package poo.PL2.Clases;

import java.io.IOException;
import java.time.LocalDate;


public class MainCode {

    
    public static void main(String[] args) throws ClassNotFoundException {
        
        Evento evento1 = new Evento("Pachanga","Deportivo","Chopera",LocalDate.now().plusDays(3),3.5,"Guadalajara");
        Cliente cliente1 = new Cliente("Lasersub","666699669","BarrioVacioYPerdido","1234 5678 9876 5432",true,"matajudios@gmail.com","mainEdgar");
        Reserva reserva1 = new Reserva(cliente1, evento1, evento1.getFecha(),2,7);
        
        DataBase miBaseDeDatos = new DataBase();
        miBaseDeDatos.addCliente(cliente1);
        miBaseDeDatos.addEvento(evento1);
        miBaseDeDatos.addReserva(reserva1);
        
 
        try {
            DataBase.guardar(miBaseDeDatos,"C:\\Users\\User\\Documents\\NetBeansProjects\\PL2-programacion\\PL2\\src\\main\\java\\poo\\PL2\\Clases\\DataBase\\MiBaseDeDatos.ser");
        } catch (IOException e) {
            e.printStackTrace(); // o loguea el error o muestra un mensaje
        }
        
        try {
            miBaseDeDatos = DataBase.cargar("C:\\Users\\User\\Documents\\NetBeansProjects\\PL2-programacion\\PL2\\src\\main\\java\\poo\\PL2\\Clases\\DataBase\\MiBaseDeDatos.ser");
        } catch (IOException e) {
            e.printStackTrace(); // o loguea el error o muestra un mensaje
        }
    }   
}
