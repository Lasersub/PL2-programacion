
package poo.PL2.Clases;


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
        return numero != null && numero.matches("^\\d+[A-Za-z]$");
    }
}
