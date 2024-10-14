package com.ejemplo.dao;

import com.ejemplo.model.Cosecha;
import com.ejemplo.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CosechaDAO {

    private Connection conexion;

    public CosechaDAO() {
        conexion = ConexionBD.getConexion();
    }

    // Aqui esta la logica de insertar datos.
    public void agregarCosecha(Cosecha cosecha) throws SQLException {
        String sql = "INSERT INTO registro_cosecha (fecha_cosecha, tipo_fruta, cantidad_kg) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(cosecha.getFechaCosecha().getTime()));
            statement.setString(2, cosecha.getTipoFruta());
            statement.setDouble(3, cosecha.getCantidadKg());
            statement.executeUpdate();
        }
    }

    // Aqui esta la logica de leer la base de datos
    public List<Cosecha> obtenerCosechas() throws SQLException {
        List<Cosecha> cosechas = new ArrayList<>();
        String sql = "SELECT * FROM registro_cosecha";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Cosecha cosecha = new Cosecha();
                cosecha.setId(resultSet.getInt("id"));
                cosecha.setFechaCosecha(resultSet.getDate("fecha_cosecha"));
                cosecha.setTipoFruta(resultSet.getString("tipo_fruta"));
                cosecha.setCantidadKg(resultSet.getDouble("cantidad_kg"));
                cosechas.add(cosecha);
            }
        }
        return cosechas;
    }

    // Aqui esta la logica de actualizar las cosechas
    public void actualizarCosecha(Cosecha cosecha) throws SQLException {
        String sql = "UPDATE registro_cosecha SET fecha_cosecha = ?, tipo_fruta = ?, cantidad_kg = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(cosecha.getFechaCosecha().getTime()));
            statement.setString(2, cosecha.getTipoFruta());
            statement.setDouble(3, cosecha.getCantidadKg());
            statement.setInt(4, cosecha.getId());
            statement.executeUpdate();
        }
    }

    // Aqui esta la logica de eliminar las cosechas
    public void eliminarCosecha(int id) throws SQLException {
        String sql = "DELETE FROM registro_cosecha WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
