package org.escuela.programacionIII2024.modelo;

import java.util.List;


public class Biblioteca {
    private LibroService libroService;
    private UsuarioService usuarioService;
//contructor
    public Biblioteca(LibroService libroService, UsuarioService usuarioService) {
        this.libroService = libroService;
        this.usuarioService = usuarioService;
    }

    // Métodos para manejar libros
    public void agregarLibro(String titulo, String autor, String genero, String isbn) {
        Libro libro = new Libro(titulo, autor, genero, isbn);
        libroService.agregarLibro(libro);
    }

    public void eliminarLibro(String isbn) {
        libroService.eliminarLibro(isbn);
    }

    public List<Libro> buscarLibroPorNombre(String nombre) {
        return libroService.buscarLibroPorNombre(nombre);
    }

    public List<Libro> buscarLibrosPorAutor(String autor) {
        return libroService.buscarLibrosPorAutor(autor);
    }

    // Métodos para manejar usuarios
    public void agregarUsuario(String nombre, String dni) {
        Usuario usuario = new Usuario(nombre, dni);
        usuarioService.agregarUsuario(usuario);
    }

    public void eliminarUsuario(String dni) {
        usuarioService.eliminarUsuario(dni);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
}


