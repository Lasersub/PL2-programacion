
package poo.PL2;

import java.awt.List;
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

    private static final long serialVersionUID = 1L;

    // Almacenes
    private Map<String, Cliente> clientes; // clave = email
    private ArrayList<Evento> eventos;
    private ArrayList<Reserva> reservas;

    public DataBase() {
        clientes = new HashMap<>();
        eventos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    
    public void addCliente(Cliente cliente) {
        clientes.put(cliente.getCorreo(), cliente);
    }

    public Cliente getCliente(String correo) {
        return clientes.get(correo);
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

    
    public static void guardar(DataBase db, String archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(db);
        }
    }

    public static DataBase cargar(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (DataBase) ois.readObject();
        }
    }
}
