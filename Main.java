package org.escuela.programacionIII2024;
import org.escuela.programacionIII2024.modelo.Biblioteca;
import org.escuela.programacionIII2024.modelo.Libro;
import org.escuela.programacionIII2024.modelo.LibroService;
import org.escuela.programacionIII2024.modelo.Usuario;
import org.escuela.programacionIII2024.modelo.UsuarioService;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        LibroService libroService = new LibroService();
        UsuarioService usuarioService = new UsuarioService();
        Biblioteca biblioteca = new Biblioteca(libroService, usuarioService);
        new BibliotecaGUI(biblioteca);
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n--- Biblioteca ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Buscar libro por nombre");
            System.out.println("4. Buscar libros por autor");
            System.out.println("5. Agregar usuario");
            System.out.println("6. Eliminar usuario");
            System.out.println("7. Listar usuarios");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el género del libro: ");
                    String genero = scanner.nextLine();
                    System.out.print("Ingrese el ISBN del libro: ");
                    String isbn = scanner.nextLine();
                    biblioteca.agregarLibro(titulo, autor, genero, isbn);
                    System.out.println("Libro agregado exitosamente.");
                    break;

                case "2":
                    System.out.print("Ingrese el ISBN del libro a eliminar: ");
                    isbn = scanner.nextLine();
                    biblioteca.eliminarLibro(isbn);
                    System.out.println("Libro eliminado exitosamente.");
                    break;

                case "3":
                    System.out.print("Ingrese el nombre del libro a buscar: ");
                    String nombre = scanner.nextLine();
                    biblioteca.buscarLibroPorNombre(nombre);
                    break;

                case "4":
                    System.out.print("Ingrese el autor de los libros a buscar: ");
                    autor = scanner.nextLine();
                    biblioteca.buscarLibrosPorAutor(autor);
                    break;

                case "5":
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese el DNI del usuario: ");
                    String dni = scanner.nextLine();
                    biblioteca.agregarUsuario(nombreUsuario, dni);
                    System.out.println("Usuario agregado exitosamente.");
                    break;

                case "6":
                    System.out.print("Ingrese el DNI del usuario a eliminar: ");
                    dni = scanner.nextLine();
                    biblioteca.eliminarUsuario(dni);
                    System.out.println("Usuario eliminado exitosamente.");
                    break;

                case "7":
                    biblioteca.listarUsuarios();
                    break;

                case "8":
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (!opcion.equals("8"));

        scanner.close();
    }
}





