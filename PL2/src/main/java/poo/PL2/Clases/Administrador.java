
package poo.PL2.Clases;


public class Administrador extends Usuario {

    private static final String ADMIN_EMAIL = "admin@javaevents.com";
    private static final String ADMIN_PASSWORD = "admin";

    public Administrador() {
        super(ADMIN_EMAIL, ADMIN_PASSWORD);
    }

    public static boolean esAdmin(String correo, String contrasena) {
        return ADMIN_EMAIL.equals(correo) && ADMIN_PASSWORD.equals(contrasena);
    }

    // Métodos exclusivos del administrador
    public void gestionarEventos() {
        // implementar
    }

    public void consultarUsuarios() {
        // implementar
    }

    public void consultarReservas() {
        // implementar
    }

}
