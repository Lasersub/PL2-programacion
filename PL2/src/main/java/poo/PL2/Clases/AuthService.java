
package poo.PL2.Clases;

import java.io.IOException;
import java.util.Map;

public class AuthService {
    
    private DataBase dataBase;

    public AuthService() {
        this.dataBase = DataBase.getInstance();
    }

    // Registro: Verifica correo único y añade cliente
    public boolean registrarCliente(Cliente cliente) throws IOException {
        Map<String, Cliente> clientes = dataBase.getClientes();
        
        // Validación de correo único (O(1) gracias al HashMap)
        if (clientes.containsKey(cliente.getCorreo())) {
            return false;  // Correo ya registrado
        }

        // Validación adicional (ej: contraseña segura)
        if (!ValidadorUtilidades.esContrasenaSegura(cliente.getContrasena())) {
            throw new IllegalArgumentException("La contraseña debe tener 8+ caracteres, un número y una letra mayúscula");
        }

        // Guardar cliente
        dataBase.getClientes().put(cliente.getCorreo(), cliente);
        return true;
    }

    // Login: Busca cliente por correo y contraseña
    public Cliente iniciarSesion(String correo, String contrasena) {
        Cliente cliente = dataBase.getClientes().get(correo);  // O(1)
        if (cliente != null && cliente.getContrasena().equals(contrasena)) {
            return cliente;
        }
        return null;
    }

    
}