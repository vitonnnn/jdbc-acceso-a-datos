# Proyecto de Gestión de Cosechas

Este proyecto es una aplicación de escritorio en Java que permite gestionar registros de cosechas de frutas. Su principal objetivo es facilitar la administración de datos relacionados con las cosechas, incluyendo la fecha de la cosecha, el tipo de fruta y la cantidad cosechada en kilogramos.

## Funcionalidades Principales

- **Agregar Cosechas**: Permite al usuario introducir nuevos registros de cosechas en la base de datos.
- **Listar Cosechas**: Muestra todos los registros de cosechas existentes.
- **Actualizar Cosechas**: Permite modificar los detalles de una cosecha ya registrada.
- **Eliminar Cosechas**: Ofrece la opción de eliminar registros de cosechas.

## Estructura del Proyecto

- **Modelo**: Define la clase `Cosecha` que representa la estructura de datos de una cosecha.
- **DAO**: Implementa la clase `CosechaDAO` que maneja la conexión y las operaciones de base de datos para las cosechas.
- **Interfaz de Usuario**: Utiliza `CosechaView` para crear una interfaz gráfica intuitiva donde los usuarios pueden interactuar con la aplicación.
- **Conexión a Base de Datos**: `ConexionBD` establece la conexión a la base de datos MySQL.

## Requisitos

- JDK 8 o superior.
- MySQL Server.
- Conector MySQL JDBC.

Este proyecto es útil para quienes desean llevar un control de las cosechas de frutas, optimizando la gestión y el acceso a la información relevante.
