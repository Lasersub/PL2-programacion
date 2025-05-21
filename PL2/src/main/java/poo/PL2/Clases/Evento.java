
package poo.PL2.Clases;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Evento implements Serializable {
    
    private String titulo;
    private String tipo;
    private ArrayList<LocalDateTime> fechas;
    private Direccion direccion;
    private double calificacion;
    private double precio;
    private String rutaPortada;
    private ArrayList<Resena> resenas;
    
    // la ruta tiene que tener la estructura: "/poo/PL2/Clases/imagenes/nombreImagen.jpg" 
    public Evento(String titulo, String tipo, ArrayList<LocalDateTime> fechas, Direccion direccion, double calificacion, 
                        double precio, String rutaPortada, ArrayList<Resena> resenas) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.fechas = fechas;
        this.direccion = direccion;
        this.calificacion = calificacion;
        this.precio = precio;
        this.rutaPortada = rutaPortada;
        this.resenas = resenas;
    }
    
    public Evento(String titulo, String tipo, ArrayList<LocalDateTime> fechas, Direccion direccion,
                        double precio, String rutaPortada) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.fechas = fechas;
        this.direccion = direccion;
        this.calificacion = 0.0;
        this.precio = precio;
        this.rutaPortada = rutaPortada;
        this.resenas = new ArrayList<Resena>();
    }
    
    
    public ArrayList<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(ArrayList<Resena> resenas) {
        this.resenas = resenas;
    }
   
    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
  
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
 
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<LocalDateTime> getFechas() {
        return fechas;
    }

    public void setFechas(ArrayList<LocalDateTime> fechas) {
        this.fechas = fechas;
    }

     public ImageIcon getPortada() {
        if (rutaPortada == null || rutaPortada.isEmpty()) {
            return null;
        }
        return new ImageIcon(rutaPortada); // Carga desde ruta del sistema de archivos
    }
}
