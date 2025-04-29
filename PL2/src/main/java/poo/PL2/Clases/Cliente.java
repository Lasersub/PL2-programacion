
package poo.PL2.Clases;

import java.util.ArrayList;
import java.util.*;


public class Cliente extends Usuario {
    
    private String nombre;
    private String telefono;
    private String direccion;
    private String tarjetaCredito;
    private boolean vip;

    public Cliente(String nombre, String telefono, String direccion, String tarjetaCredito, boolean vip, String correo, String contrasena) {
        super(correo, contrasena);
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tarjetaCredito = tarjetaCredito;
        this.vip = vip;
    }
    
    
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
    
    public ArrayList<Evento> filterEvent(String titulo, String tipo, String ciudad, int precio, ArrayList<Evento> eventos){
        List<Object> filtros = new ArrayList<>();
        filtros.add(titulo);
        filtros.add(tipo);
        filtros.add(ciudad);
        filtros.add(precio);
        
        // Filtro precio
        
        int n = eventos.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (eventos.get(j).getPrecioEntrada() > eventos.get(j + 1).getPrecioEntrada()) {
                    // Intercambiar eventos
                    Evento temp = eventos.get(j);
                    eventos.set(j, eventos.get(j + 1));
                    eventos.set(j + 1, temp);
                    swapped = true;
                }
            }    
            if (!swapped) break;
        }
        // esto esta mal, solo para que no haya el missing return statement
        ArrayList<Evento> resultado = new ArrayList<>();
        resultado.add(eventos.get(4));
        resultado.add(eventos.get(5));
        return resultado; 
        // esto esta mal, solo para que no haya el missing return statement
    }
        
        public static List<Evento> eventosDesdePrecio(ArrayList<Evento> eventos, double precioMinimo) {
        List<Evento> resultado = new ArrayList<>();
        Collections.sort(eventos, Comparator.comparingDouble(Evento::getPrecioEntrada)); // Ordenar ASC

        int inicio = encontrarPrimerEvento(eventos, precioMinimo);
        if (inicio == -1) return resultado; // No hay eventos

        for (int i = inicio; i < eventos.size(); i++) {
            resultado.add(eventos.get(i));
        }
        return resultado;
    }

    // Devuelve eventos con precio entre [precioMin, precioMax]
    public static List<Evento> eventosEnRango(ArrayList<Evento> eventos, double precioMin, double precioMax) {
        List<Evento> resultado = new ArrayList<>();
        Collections.sort(eventos, Comparator.comparingDouble(Evento::getPrecioEntrada)); // Ordenar ASC

        int inicio = encontrarPrimerEvento(eventos, precioMin);
        if (inicio == -1) return resultado; // No hay eventos

        for (int i = inicio; i < eventos.size(); i++) {
            Evento e = eventos.get(i);
            if (e.getPrecioEntrada() <= precioMax) {
                resultado.add(e);
            } else {
                break; // Los siguientes serán más caros (array ordenado)
            }
        }
        return resultado;
    }

    // Búsqueda binaria para encontrar el primer evento con precio >= precioMinimo
    private static int encontrarPrimerEvento(ArrayList<Evento> eventos, double precioMinimo) {
        int izquierda = 0;
        int derecha = eventos.size() - 1;
        int indice = -1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (eventos.get(medio).getPrecioEntrada() >= precioMinimo) {
                indice = medio;
                derecha = medio - 1; // Seguir buscando a la izquierda (para encontrar el primero)
            } else {
                izquierda = medio + 1;
            }
        }
        return indice;
    }
    
    
        
        
        
        
}
    
