
package poo.PL2.Clases;


public class Navegacion {
    
    // Abre la ventana destino y cierra la ventana actual.
    public static void cambiarVentana(javax.swing.JFrame actual, javax.swing.JFrame destino) {
        destino.setVisible(true);
        actual.dispose();
    }
}
