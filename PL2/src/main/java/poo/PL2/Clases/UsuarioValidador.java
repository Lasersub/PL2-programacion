
package poo.PL2.Clases;




public class UsuarioValidador {
    
    public static boolean EsNombreValido(String nombre){
        return nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñüÜ\\s]+$");
    }
    
    public static boolean EsTelefonoValido(String telefono){
        return telefono.matches("^\\d{9}$");
    }
    
    public static boolean EsDireccionValido(String direccion){
        return ValidadorUtilidades.noEsVacio(direccion);
    }
    
    public static boolean EsTarjetaValida(String tarjeta){
        return !tarjeta.matches("^\\d{13,19}$");
    }
    
    
}
