package com.ejemplo.view;

import com.ejemplo.dao.CosechaDAO;
import com.ejemplo.model.Cosecha;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CosechaView extends JFrame {

    private CosechaDAO cosechaDAO;
    private JTextField txtId, txtFechaCosecha, txtTipoFruta, txtCantidadKg;
    private JTextArea textArea;

    public CosechaView() {
        cosechaDAO = new CosechaDAO();

        // Configuración de la ventana principal
        setTitle("Gestión de Cosechas");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));  // Espacios de 10 píxeles entre componentes
        getContentPane().setBackground(new Color(245, 245, 245));  // Fondo gris claro

        // Panel superior con formulario
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBorder(new EmptyBorder(10, 10, 10, 10));  // Padding de 10 píxeles
        panelFormulario.setBackground(new Color(255, 255, 255));  // Fondo blanco
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);  // Márgenes entre elementos

        // Campo para ID
        JLabel lblId = new JLabel("ID (para Actualizar/Eliminar):");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelFormulario.add(lblId, gbc);
        txtId = new JTextField(10);
        gbc.gridx = 1;
        panelFormulario.add(txtId, gbc);

        // Campo para Fecha de Cosecha
        JLabel lblFechaCosecha = new JLabel("Fecha de Cosecha (YYYY-MM-DD):");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulario.add(lblFechaCosecha, gbc);
        txtFechaCosecha = new JTextField(10);
        gbc.gridx = 1;
        panelFormulario.add(txtFechaCosecha, gbc);

        // Campo para Tipo de Fruta
        JLabel lblTipoFruta = new JLabel("Tipo de Fruta:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelFormulario.add(lblTipoFruta, gbc);
        txtTipoFruta = new JTextField(10);
        gbc.gridx = 1;
        panelFormulario.add(txtTipoFruta, gbc);

        // Campo para Cantidad en Kg
        JLabel lblCantidadKg = new JLabel("Cantidad en Kg:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelFormulario.add(lblCantidadKg, gbc);
        txtCantidadKg = new JTextField(10);
        gbc.gridx = 1;
        panelFormulario.add(txtCantidadKg, gbc);

        // Panel de botones con FlowLayout
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.setBackground(new Color(240, 240, 240));

        // Botón para agregar Cosecha (CREATE)
        JButton btnAgregar = new JButton("Agregar Cosecha");
        btnAgregar.setBackground(new Color(76, 175, 80));  // Verde claro
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCosecha();
            }
        });
        panelBotones.add(btnAgregar);

        // Botón para actualizar Cosecha (UPDATE)
        JButton btnActualizar = new JButton("Actualizar Cosecha");
        btnActualizar.setBackground(new Color(33, 150, 243));  // Azul claro
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCosecha();
            }
        });
        panelBotones.add(btnActualizar);

        // Botón para eliminar Cosecha (DELETE)
        JButton btnEliminar = new JButton("Eliminar Cosecha");
        btnEliminar.setBackground(new Color(244, 67, 54));  // Rojo claro
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarCosecha();
            }
        });
        panelBotones.add(btnEliminar);

        // Botón para listar Cosechas (READ)
        JButton btnListar = new JButton("Listar Cosechas");
        btnListar.setBackground(new Color(255, 193, 7));  // Amarillo claro
        btnListar.setForeground(Color.WHITE);
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarCosechas();
            }
        });
        panelBotones.add(btnListar);

        // Área de texto para mostrar resultados
        textArea = new JTextArea(10, 40);
        textArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Añadir paneles a la ventana principal
        add(panelFormulario, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void agregarCosecha() {
        try {
            Date fechaCosecha = new SimpleDateFormat("yyyy-MM-dd").parse(txtFechaCosecha.getText());
            String tipoFruta = txtTipoFruta.getText();
            double cantidadKg = Double.parseDouble(txtCantidadKg.getText());
            Cosecha cosecha = new Cosecha(0, fechaCosecha, tipoFruta, cantidadKg);
            cosechaDAO.agregarCosecha(cosecha);
            textArea.setText("Cosecha agregada exitosamente\n");
        } catch (SQLException | ParseException | NumberFormatException e) {
            e.printStackTrace();
            textArea.setText("Error al agregar la cosecha\n");
        }
    }

    private void actualizarCosecha() {
        try {
            int id = Integer.parseInt(txtId.getText());
            Date fechaCosecha = new SimpleDateFormat("yyyy-MM-dd").parse(txtFechaCosecha.getText());
            String tipoFruta = txtTipoFruta.getText();
            double cantidadKg = Double.parseDouble(txtCantidadKg.getText());
            Cosecha cosecha = new Cosecha(id, fechaCosecha, tipoFruta, cantidadKg);
            cosechaDAO.actualizarCosecha(cosecha);
            textArea.setText("Cosecha actualizada exitosamente\n");
        } catch (SQLException | ParseException | NumberFormatException e) {
            e.printStackTrace();
            textArea.setText("Error al actualizar la cosecha\n");
        }
    }

    private void eliminarCosecha() {
        try {
            int id = Integer.parseInt(txtId.getText());
            cosechaDAO.eliminarCosecha(id);
            textArea.setText("Cosecha eliminada exitosamente\n");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            textArea.setText("Error al eliminar la cosecha\n");
        }
    }

    private void listarCosechas() {
        try {
            List<Cosecha> cosechas = cosechaDAO.obtenerCosechas();
            StringBuilder builder = new StringBuilder();
            for (Cosecha cosecha : cosechas) {
                builder.append("ID: ").append(cosecha.getId())
                       .append(", Fecha Cosecha: ").append(cosecha.getFechaCosecha())
                       .append(", Tipo de Fruta: ").append(cosecha.getTipoFruta())
                       .append(", Cantidad Kg: ").append(cosecha.getCantidadKg()).append("\n");
            }
            textArea.setText(builder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            textArea.setText("Error al listar las cosechas\n");
        }
    }

    public static void main(String[] args) {
        new CosechaView();
    }
}
