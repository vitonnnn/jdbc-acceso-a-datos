# Gestión de Cosechas

Este proyecto es una aplicación Java de escritorio para gestionar registros de cosechas en una base de datos. Permite realizar operaciones básicas de CRUD (Crear, Leer, Actualizar y Eliminar) sobre los datos de las cosechas.

## Funcionalidades

- Agregar nuevas cosechas.
- Listar todas las cosechas existentes.
- Actualizar registros de cosechas.
- Eliminar cosechas.

## Requisitos

- Java Development Kit (JDK) 8 o superior.
- MySQL Server.
- Conector MySQL JDBC para Java.

## Configuración del Proyecto

1. **Base de Datos**
   - Asegúrate de tener MySQL instalado y en funcionamiento.
   - Crea una base de datos llamada `cosecha` utilizando el siguiente script SQL:

     ```sql
     CREATE DATABASE cosecha;

     USE cosecha;

     CREATE TABLE cosechas (
         id INT AUTO_INCREMENT PRIMARY KEY,
         fecha_cosecha DATE NOT NULL,
         tipo_fruta VARCHAR(100) NOT NULL,
         cantidad_kg DOUBLE NOT NULL
     );
     ```

2. **Conexión a la Base de Datos**
   - Modifica la clase `ConexionBD` en `com.ejemplo.util` para ajustar los parámetros de conexión según tu configuración de MySQL (usuario y contraseña).

   ```java
   public static Connection getConexion() {
       String url = "jdbc:mysql://localhost:3306/cosecha"; // URL de conexión
       String usuario = "root"; // Cambia esto según tu usuario
       String contraseña = "negros*"; // Cambia esto según tu contraseña
       // Resto del código...
   }
