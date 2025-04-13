package poo.PL2;

import java.awt.Font;
import javax.swing.*;

public class SesionErrorHandler {
    
    // DECLARACIÓN DE LOS ERRORES
    public enum ErrorTipo {
        // Generales
        USUARIO_VACIO,
        CONTRASENA_VACIA,
        
        
        // Crear una cuenta
        USUARIO_EXISTENTE,
        USUARIO_NO_VALIDO,
        CONTRASENA_NO_VALIDA,
        CONTRASENA_MAL_REESCRITA,
        
        // Iniciar sesión
        USUARIO_NO_EXISTE,
        CONTRASENA_INCORRECTA
    
    
    }
    
    
    // ABRIMOS UNA VENTANA DIFERENTE DEPENDIENDO DEL ERROR
    public static void mostrarError(ErrorTipo tipo) {
        switch(tipo) {
            // General
            case USUARIO_VACIO:
                mostrarVentana("El campo de usuario está vacío.");
                break;
            case CONTRASENA_VACIA:
                mostrarVentana("El campo de contraseña está vacío.");
                break;
            
            // Crear una cuenta
            case USUARIO_EXISTENTE:
                mostrarVentana("El usuario escrito ya existe.");
                break;
            case USUARIO_NO_VALIDO:
                mostrarVentana("El usuario escrito no es válido.");
                break;
            case CONTRASENA_NO_VALIDA:
                mostrarVentana("La contraseña utilizada no es válida.");
                break;
            case CONTRASENA_MAL_REESCRITA:
                mostrarVentana("La contraseña ha sido mal reescrita.");
                break;
                
            // Iniciar sesión
            case USUARIO_NO_EXISTE:
                mostrarVentana("El usuario no existe.");
                break;
            case CONTRASENA_INCORRECTA:
                mostrarVentana("La contraseña es incorrecta.");
                break;
        }
    }

    
    private static void mostrarVentana(String mensaje) {
        // VOID ENCARGADO DE CREAR LA VENTANA
        JFrame ventana = new JFrame("Error de Inicio de Sesión");
        JLabel label = new JLabel(mensaje, SwingConstants.CENTER);
        
        // Cambiar el tipo de letra y ponerla en "negrita"
        label.setFont(new Font("Arial", Font.BOLD, 18));
        
        ventana.add(label);
        ventana.setSize(400, 250);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setVisible(true);
    }

}


