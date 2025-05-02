
package poo.PL2.Clases;
/*
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
    
    public ArrayList<Evento> filterEvent(String titulo, String tipo, String ciudad, int precioMin, int precioMax , ArrayList<Evento> eventos){
        List<Object> filtros = new ArrayList<>();
        filtros.add(titulo);
        filtros.add(tipo);
        filtros.add(ciudad);
        filtros.add(precioMin);
        
        if ()
        
    
    }
    
    
    // Filtros precio
        
    public static List<Evento> eventosDesdePrecio(ArrayList<Evento> eventos, double precioMinimo) {
        List<Evento> resultado = new ArrayList<>();
        Collections.sort(eventos, Comparator.comparingDouble(Evento::getPrecioEntrada)); 

        int inicio = encontrarPrimerEventoPrecio(eventos, precioMinimo);
        if (inicio == -1) return resultado; 

        for (int i = inicio; i < eventos.size(); i++) {
            resultado.add(eventos.get(i));
        }
        return resultado;
        }

    
    public static List<Evento> eventosEnRangoPrecio(ArrayList<Evento> eventos, double precioMin, double precioMax) {
        
        //if ((precioMin == null ) && (precioMax == null)){
            
        
        List<Evento> resultado = new ArrayList<>();
        Collections.sort(eventos, Comparator.comparingDouble(Evento::getPrecioEntrada)); 

        int inicio = encontrarPrimerEventoPrecio(eventos, precioMin);
        if (inicio == -1) return resultado; 

        for (int i = inicio; i < eventos.size(); i++) {
            Evento e = eventos.get(i);
            if (e.getPrecioEntrada() <= precioMax) {
                resultado.add(e);
            } else {
                break; 
            }
        }
        return resultado;
    }

    
    private static int encontrarPrimerEventoPrecio(ArrayList<Evento> eventos, double precioMinimo) {
        int izquierda = 0;
        int derecha = eventos.size() - 1;
        int indice = -1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (eventos.get(medio).getPrecioEntrada() >= precioMinimo) {
                indice = medio;
                derecha = medio - 1; 
            } else {
                izquierda = medio + 1;
            }
        }
        return indice;
    }
    
    // Filtros ciudad
    
    public static List<Evento> eventosEnCiudad(ArrayList<Evento> eventos, String ciudad){
        
        ArrayList<Evento> resultado = new ArrayList<>();
        Collections.sort(eventos, Comparator.comparing(Evento::getCiudad));
        
        int inicio = encontrarPrimerEventoCiudad(eventos, ciudad);
        if (inicio == -1) return resultado; 

        for (int i = inicio; i < eventos.size(); i++) {
            if(eventos.get(i).getCiudad().equalsIgnoreCase(ciudad)){
                resultado.add(eventos.get(i));  
            }
            else{
                break;
            }
        }
        return resultado;  
    }
    
    private static int encontrarPrimerEventoCiudad(ArrayList<Evento> eventos, String ciudad) {
        
        // se da por hecho lista ordenada por ciudad
        
        int izquierda = 0;
        int derecha = eventos.size() - 1;
        int indice = -1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if(eventos.get(medio).getCiudad().equalsIgnoreCase(ciudad)){
                indice = medio;
                derecha = medio - 1; 
            } else {
                izquierda = medio + 1;
            }
        }
        return indice;
    }
    
    // Filtros titulo
    
    private static int encontrarPrimerEventoTitulo(ArrayList<Evento> eventos, String titulo) {
        
        // se da por hecho lista ordenada por titulo
        
        int izquierda = 0;
        int derecha = eventos.size() - 1;
        int indice = -1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if(eventos.get(medio).getTitulo().equalsIgnoreCase(titulo)){
                indice = medio;
                derecha = medio - 1; 
            } else {
                izquierda = medio + 1;
            }   
        }
        return indice;
    }
    
    public static List<Evento> eventosConTitulo(ArrayList<Evento> eventos, String ciudad){
        
        ArrayList<Evento> resultado = new ArrayList<>();
        Collections.sort(eventos, Comparator.comparing(Evento::getTitulo));
        
        int inicio = encontrarPrimerEventoTitulo(eventos, ciudad);
        if (inicio == -1) return resultado; 

        for (int i = inicio; i < eventos.size(); i++) {
            if(eventos.get(i).getCiudad().equalsIgnoreCase(ciudad)){
                resultado.add(eventos.get(i));  
            }
            else{
                break;
            }
        }
        return resultado;  
    }
    
    // Filtros tipo
    
    private static int encontrarPrimerEventoTipo(ArrayList<Evento> eventos, String tipo) {
        
        // se da por hecho lista ordenada por ciudad
        
        int izquierda = 0;
        int derecha = eventos.size() - 1;
        int indice = -1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if(eventos.get(medio).getTipo().equalsIgnoreCase(tipo)){
                indice = medio;
                derecha = medio - 1; 
            } else {
                izquierda = medio + 1;
            }
        }
        return indice;
    }
    
    public static List<Evento> eventosDeTipo(ArrayList<Evento> eventos, String tipo){
        
        ArrayList<Evento> resultado = new ArrayList<>();
        Collections.sort(eventos, Comparator.comparing(Evento::getTipo));
        
        int inicio = encontrarPrimerEventoTipo(eventos, tipo);
        if (inicio == -1) return resultado; 

        for (int i = inicio; i < eventos.size(); i++) {
            if(eventos.get(i).getCiudad().equalsIgnoreCase(tipo)){
                resultado.add(eventos.get(i));  
            }
            else{
                break;
            }
        }
        return resultado;  
    }
    
    
    
        
        
        
        
}
    */
