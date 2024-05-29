package org.escuela.programacionIII2024.modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibroService {
    private List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(String isbn) {
        libros.removeIf(libro -> libro.getIsbn().equals(isbn));
    }

    public List<Libro> buscarLibroPorNombre(String nombre) {
        return libros.stream()
                     .filter(libro -> libro.getTitulo().toLowerCase().contains(nombre.toLowerCase()))
                     .collect(Collectors.toList());
    }

    public List<Libro> buscarLibrosPorAutor(String autor) {
        return libros.stream()
                     .filter(libro -> libro.getAutor().toLowerCase().contains(autor.toLowerCase()))
                     .collect(Collectors.toList());
    }
}
