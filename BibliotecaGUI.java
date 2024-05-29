package org.escuela.programacionIII2024;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import org.escuela.programacionIII2024.modelo.Biblioteca;
import org.escuela.programacionIII2024.modelo.Libro;
import org.escuela.programacionIII2024.modelo.Usuario;

public class BibliotecaGUI {
    private Biblioteca biblioteca;
    private JFrame frame;
    private JTextField tituloField;
    private JTextField autorField;
    private JTextField generoField;
    private JTextField isbnField;
    private JTextField nombreUsuarioField;
    private JTextField dniField;
    private JTextArea outputArea;

    public BibliotecaGUI(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Sistema de Gestión de Biblioteca");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        inputPanel.setLayout(new GridLayout(6, 2));

        JLabel tituloLabel = new JLabel("Título:");
        inputPanel.add(tituloLabel);

        tituloField = new JTextField();
        inputPanel.add(tituloField);
        tituloField.setColumns(30);

        JLabel autorLabel = new JLabel("Autor:");
        inputPanel.add(autorLabel);

        autorField = new JTextField();
        inputPanel.add(autorField);
        autorField.setColumns(15);

        JLabel generoLabel = new JLabel("Género:");
        inputPanel.add(generoLabel);

        generoField = new JTextField();
        inputPanel.add(generoField);
        generoField.setColumns(15);

        JLabel isbnLabel = new JLabel("ISBN:");
        inputPanel.add(isbnLabel);

        isbnField = new JTextField();
        inputPanel.add(isbnField);
        isbnField.setColumns(10);

        JLabel nombreUsuarioLabel = new JLabel("Nombre Usuario:");
        inputPanel.add(nombreUsuarioLabel);

        nombreUsuarioField = new JTextField();
        inputPanel.add(nombreUsuarioField);
        nombreUsuarioField.setColumns(15);

        JLabel dniLabel = new JLabel("DNI:");
        inputPanel.add(dniLabel);

        dniField = new JTextField();
        inputPanel.add(dniField);
        dniField.setColumns(10);

        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(3, 2));

        JButton agregarLibroButton = new JButton("Agregar Libro");
        agregarLibroButton.setBackground(Color.cyan);
        agregarLibroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });
        buttonPanel.add(agregarLibroButton);

        JButton eliminarLibroButton = new JButton("Eliminar Libro");
        eliminarLibroButton.setBackground(Color.cyan);
        eliminarLibroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarLibro();
            }
        });
        buttonPanel.add(eliminarLibroButton);

        JButton buscarLibroButton = new JButton("Buscar Libro por Nombre");
        buscarLibroButton.setBackground(Color.cyan);
        buscarLibroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarLibroPorNombre();
            }
        });
        buttonPanel.add(buscarLibroButton);

        JButton buscarAutorButton = new JButton("Buscar Libros por Autor");
        buscarAutorButton.setBackground(Color.cyan);
        buscarAutorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarLibrosPorAutor();
            }
        });
        buttonPanel.add(buscarAutorButton);

        JButton agregarUsuarioButton = new JButton("Agregar Usuario");
        agregarUsuarioButton.setBackground(Color.cyan);
        agregarUsuarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarUsuario();
            }
        });
        buttonPanel.add(agregarUsuarioButton);

        JButton eliminarUsuarioButton = new JButton("Eliminar Usuario");
        eliminarUsuarioButton.setBackground(Color.cyan);
        eliminarUsuarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarUsuario();
            }
        });
        buttonPanel.add(eliminarUsuarioButton);

        outputArea = new JTextArea();
        frame.getContentPane().add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void agregarLibro() {
        String titulo = tituloField.getText();
        String autor = autorField.getText();
        String genero = generoField.getText();
        String isbn = isbnField.getText();
        biblioteca.agregarLibro(titulo, autor, genero, isbn);
        outputArea.append("Libro agregado: " + titulo + "\n");
    }

    private void eliminarLibro() {
        String isbn = isbnField.getText();
        biblioteca.eliminarLibro(isbn);
        outputArea.append("Libro eliminado con ISBN: " + isbn + "\n");
    }

    private void buscarLibroPorNombre() {
        String nombre = tituloField.getText();
        List<Libro> libros = biblioteca.buscarLibroPorNombre(nombre);
        outputArea.append("Libros encontrados:\n");
        for (Libro libro : libros) {
            outputArea.append(libro.toString() + "\n");
        }
    }

    private void buscarLibrosPorAutor() {
        String autor = autorField.getText();
        List<Libro> libros = biblioteca.buscarLibrosPorAutor(autor);
        outputArea.append("Libros de " + autor + ":\n");
        for (Libro libro : libros) {
            outputArea.append(libro.toString() + "\n");
        }
    }

    private void agregarUsuario() {
        String nombre = nombreUsuarioField.getText();
        String dni = dniField.getText();
        biblioteca.agregarUsuario(nombre, dni);
        outputArea.append("Usuario agregado: " + nombre + "\n");
    }

    private void eliminarUsuario() {
        String dni = dniField.getText();
        biblioteca.eliminarUsuario(dni);
        outputArea.append("Usuario eliminado con DNI: " + dni + "\n");
    }
}
