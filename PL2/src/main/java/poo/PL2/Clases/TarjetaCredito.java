
package poo.PL2.Clases;

import java.time.LocalDate;


public class TarjetaCredito {
    
    
    private String titular;
    private String digitos;  
    private LocalDate fechaCaducidad;

    public TarjetaCredito(String titular, String digitos, LocalDate fechaCaducidad) {
        this.titular = titular;
        this.digitos = digitos;
        this.fechaCaducidad = fechaCaducidad;
    }
    
    
    
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }


    public String getDigitos() {
        return digitos;
    }

    public void setDigitos(String digitos) {
        this.digitos = digitos;
    }

    
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

}
