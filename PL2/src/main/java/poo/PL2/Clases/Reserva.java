
package poo.PL2.Clases;

import java.io.Serializable;
import java.time.LocalDate;


public class Reserva implements Serializable {
    private Cliente cliente;
    private Evento evento;
    private LocalDate fechaReserva;
    private LocalDate fechaEvento;
    private int numeroEntradas;
    private double precioFinal;
    private int descuentoAplicado;

    public Reserva(Cliente cliente, Evento evento, LocalDate fechaEvento, int numeroEntradas, double precioFinal) {
        this.cliente = cliente;
        this.evento = evento;
        this.fechaReserva = LocalDate.now();
        this.fechaEvento = fechaEvento;
        this.numeroEntradas = numeroEntradas;
        this.precioFinal = precioFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public int getNumeroEntradas() {
        return numeroEntradas;
    }

    public void setNumeroEntradas(int numeroEntradas) {
        this.numeroEntradas = numeroEntradas;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public int getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(int descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public String generarFactura() {
    StringBuilder sb = new StringBuilder();
    sb.append("===== FACTURA DE RESERVA =====\n");
    sb.append("Fecha de reserva: ").append(fechaReserva).append("\n");
    sb.append("Cliente: ").append(cliente.getNombre()).append(" (").append(cliente.getCorreo()).append(")\n");
    sb.append("Evento: ").append(evento.getTitulo()).append("\n");
    sb.append("Fecha del evento: ").append(fechaEvento).append("\n");
    sb.append("Entradas: ").append(numeroEntradas).append("\n");
    sb.append("Precio final: ").append(precioFinal).append("€\n");
    return sb.toString();
    }

}
