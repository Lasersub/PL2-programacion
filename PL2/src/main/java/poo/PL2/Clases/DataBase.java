
package poo.PL2.Clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DataBase implements Serializable {
    
    private static DataBase dataBase = new DataBase();

    // Almacenes
    private Map<String, Cliente> clientes; // clave = email
    private ArrayList<Evento> eventos;
    private ArrayList<Reserva> reservas;
    
    
    private DataBase() {
        this.clientes = new HashMap<>();
        this.eventos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }
    
    public static DataBase getInstance() {
        return dataBase; 
    }
  
    public void addCliente(Cliente cliente) {
        clientes.put(cliente.getCorreo(), cliente);
    }

    public Cliente getCliente(String correo) {
        return clientes.get(correo);
    }

    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Map<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean existeCliente(String correo) {
        return clientes.containsKey(correo);
    }

    
    public void addEvento(Evento evento) {
        eventos.add(evento);
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    
    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    
    public static void guardar(String archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(dataBase);
        }
    }

    public static void cargar(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            dataBase = (DataBase) ois.readObject();
        }
    }
}
