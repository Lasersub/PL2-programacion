
package poo.PL2.Clases;

import java.time.LocalDate;
import java.io.Serializable;


public class Evento implements Serializable {
    
    private String titulo;
    private String tipo;
    private String direccion;
    private LocalDate fecha;
    private String ciudad;

   

    
    public Evento(String titulo, String tipo, String direccion, LocalDate fecha, double precioEntrada, String ciudad) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = direccion;                 //FALTA IMAGEN Y CALIFICACIÓN
        this.fecha = fecha;
        this.precioEntrada = precioEntrada;
        this.ciudad = ciudad;
    }
    
    
    
     public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

        private double precioEntrada;

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }
    
}
