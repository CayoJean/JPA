package com.egg;

import java.util.Scanner;

import com.egg.servicios.AutorServicio;
import com.egg.servicios.EditorialServicio;
import com.egg.servicios.LibroServicio;

public class Menu {

    private AutorServicio autorServicio = new AutorServicio();
    private EditorialServicio editorialServicio = new EditorialServicio();
    private LibroServicio libroServicio = new LibroServicio();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1. Crear Autor");
            System.out.println("2. Crear Editorial");
            System.out.println("3. Crear Libro");
            System.out.println("4. Buscar Autor por ID");
            System.out.println("5. Buscar Libro por ISBN");
            System.out.println("6. Dar de Baja un Autor");
            System.out.println("7. Dar de Baja un Libro");
            System.out.println("8. Eliminar Editorial");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    crearAutor();
                    break;
                case 2:
                    crearEditorial();
                    break;
                case 3:
                    crearLibro();
                    break;
                case 4:
                    buscarAutor();
                    break;
                case 5:
                    buscarLibro();
                    break;
                case 6:
                    darBajaAutor();
                    break;
                case 7:
                    darBajaLibro();
                    break;
                case 8:
                    eliminarEditorial();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void crearAutor() {
        System.out.print("Ingrese el nombre del autor: ");
        String nombre = scanner.nextLine();
        autorServicio.crearAutor(nombre);
        System.out.println("Autor creado exitosamente.");
    }

    private void crearEditorial() {
        System.out.print("Ingrese el nombre de la editorial: ");
        String nombre = scanner.nextLine();
        editorialServicio.crearEditorial(nombre);
        System.out.println("Editorial creada exitosamente.");
    }

    private void crearLibro() {
        System.out.print("Ingrese el ISBN del libro: ");
        Long isbn = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el año de publicación: ");
        int anio = scanner.nextInt();
        System.out.print("Ingrese la cantidad de ejemplares: ");
        int ejemplares = scanner.nextInt();
        System.out.print("Ingrese el ID del autor: ");
        int autorId = scanner.nextInt();
        System.out.print("Ingrese el ID de la editorial: ");
        int editorialId = scanner.nextInt();

        libroServicio.crearLibro(isbn, titulo, anio, ejemplares, autorId, editorialId);
        System.out.println("Libro creado exitosamente.");
    }

    private void buscarAutor() {
        System.out.print("Ingrese el ID del autor: ");
        int id = scanner.nextInt();
        System.out.println(autorServicio.buscarAutorPorId(id));
    }

    private void buscarLibro() {
        System.out.print("Ingrese el ISBN del libro: ");
        long isbn = scanner.nextLong();
        System.out.println(libroServicio.buscarLibroPorIsbn(isbn));
    }

    private void darBajaAutor() {
        System.out.print("Ingrese el ID del autor a dar de baja: ");
        int id = scanner.nextInt();
        autorServicio.darBajaAutor(id);
        System.out.println("Autor dado de baja.");
    }

    private void darBajaLibro() {
        System.out.print("Ingrese el ISBN del libro a dar de baja: ");
        long isbn = scanner.nextLong();
        libroServicio.darBajaLibro(isbn);
        System.out.println("Libro dado de baja.");
    }

    private void eliminarEditorial() {
        System.out.print("Ingrese el ID de la editorial a eliminar: ");
        int id = scanner.nextInt();
        editorialServicio.eliminarEditorial(id);
        System.out.println("Editorial eliminada.");
    }
}
