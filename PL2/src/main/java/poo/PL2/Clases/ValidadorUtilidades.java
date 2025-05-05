
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
    
}
