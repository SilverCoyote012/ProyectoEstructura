package com.silver.main.sesion;

// Clase usada para manejar la sesion del usuario en el sistema y mantener la informacion del usuario
public class sesion {
    private static String correo;
    private static String rol;

    // Método para iniciar sesion
    public static void iniciarSesion(String correo, String rol) {
        sesion.correo = correo;
        sesion.rol = rol;
    }

    // Método para cerrar sesion
    public static void cerrarSesion() {
        sesion.correo = null;
        sesion.rol = null;
    }

    // Método para obtener el correo del usuario
    public static String getCorreo() {
        return sesion.correo;
    }

    // Método para obtener el rol del usuario
    public static String getRol() {
        return sesion.rol;
    }
}
