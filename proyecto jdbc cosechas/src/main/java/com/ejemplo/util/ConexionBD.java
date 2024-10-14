package com.ejemplo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static Connection conexion;
// Creamos un bloque try-catch en el que hacemos la conexion con la base de datos.
    static {
        try {
            String url = "jdbc:mysql://localhost:3306/cosecha";
            String usuario = "root";
            String contraseña = "negros";
            conexion = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexion() {
        return conexion;
    }
}
