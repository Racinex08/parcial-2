import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 class RegistroUsuarios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de registro de usuarios.");

        // Pedir al usuario que ingrese los datos
        System.out.println("Por favor ingrese su nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Por favor ingrese su correo electrónico:");
        String correo = scanner.nextLine();

        System.out.println("Por favor ingrese su contraseña:");
        String contrasena = scanner.nextLine();

        // Crear un objeto Usuario con los datos ingresados
        Usuario usuario = new Usuario(nombre, correo, contrasena);

        // Validar la información del usuario
        if (usuario.validarDatos()) {
            System.out.println("¡Registro exitoso!");
            System.out.println("Bienvenido, " + usuario.getNombre() + ".");
        } else {
            System.out.println("Ha ocurrido un error en el registro. Por favor, verifique sus datos e intente nuevamente.");
        }

        scanner.close();
    }
}

class Usuario {
    private String nombre;
    private String correo;
    private String contrasena;

    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean validarDatos() {
        return validarNombre() && validarCorreo() && validarContrasena();
    }

    private boolean validarNombre() {
        // El nombre debe contener solo letras y espacios, y tener al menos un carácter
        return nombre.matches("[a-zA-Z ]+") && nombre.length() > 0;
    }

    private boolean validarCorreo() {
        // Validar el formato del correo electrónico usando una expresión regular
        String regexCorreo = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return correo.matches(regexCorreo);
    }

    private boolean validarContrasena() {
        // La contraseña debe tener al menos 8 caracteres, incluyendo al menos una letra mayúscula, una minúscula y un número
        return contrasena.length() >= 8 && contrasena.matches(".*[A-Z]+.*") && contrasena.matches(".*[a-z]+.*") && contrasena.matches(".*\\d+.*");
    }
}