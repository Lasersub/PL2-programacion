
package poo.PL2.Clases;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;


public class ValidadorUtilidades {
    
    public static boolean esEmailValido(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(regex);
    }
    
    public static boolean esContrasenaSegura(String contrasena) {
        return contrasena.matches("^(?=.*[0-9])(?=.*[A-Z]).{8,}$");
    }
    
    public static boolean noEsVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }
    
    /**
     * Valida que un código postal español tenga exactamente 5 dígitos.
     * @param codigoPostal String a validar
     * @return true si es válido, false si no cumple el formato
     */
    public static boolean esCodigoPostalValido(String codigoPostal) {
        return codigoPostal != null && codigoPostal.matches("^\\d{5}$");
    }
    
    public static boolean esNumeroConLetra(String numero) {
        return numero != null && numero.matches("^(\\d{1,3}|\\d{1,2}[A-Za-z])$");
    }
    
    public static YearMonth parseFechaCaducidad(String fechaStr) {
        try {
            return YearMonth.parse(fechaStr, DateTimeFormatter.ofPattern("MM/yy"));
        } catch (DateTimeParseException e) {
            System.out.println("No se ha podido realizar la conversion efectivamente");
            return null;
        }
    }
    
    /**
     * Convierte YearMonth a String en formato MM/yy
     * @param fecha YearMonth a formatear
     * @return String en formato "MM/yy" o null si la fecha es null
     */
    public static String formatFechaCaducidad(YearMonth fecha) {
        if (fecha == null) return null;
        return fecha.format(DateTimeFormatter.ofPattern("MM/yy"));
    }
}
