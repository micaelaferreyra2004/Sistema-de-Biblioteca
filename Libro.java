package org.escuela.programacionIII2024.modelo;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private String isbn;

    public Libro(String titulo, String autor, String genero, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "'" + titulo + "' por " + autor + " (" + genero + ") - ISBN: " + isbn;
    }
}

