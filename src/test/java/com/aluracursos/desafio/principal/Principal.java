package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.model.Datos;
import com.aluracursos.desafio.model.DatosLibros;
import com.aluracursos.desafio.service.ConsumoApi;
import com.aluracursos.desafio.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);

    public void muestraElMenu() {
        int opcion;
        do {
            System.out.println("Elija la opción a través de su número:");
            System.out.println("1 - Buscar libro por título");
            System.out.println("2 - Listar libros registrados");
            System.out.println("3 - Listar autores registrados");
            System.out.println("4 - Listar autores vivos en un determinado año");
            System.out.println("5 - Listar libros por idioma");
            System.out.println("6 - Salir");

            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> buscarLibroPorTitulo();
                case 2 -> listarLibrosRegistrados();
                case 3 -> listarAutoresRegistrados();
                case 4 -> listarAutoresVivos();
                case 5 -> listarLibrosPorIdioma();
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el título del libro que desea buscar:");
        String tituloLibro = teclado.nextLine();
        String json = consumoApi.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);

        Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();

        if (libroBuscado.isPresent()) {
            System.out.println("Libro encontrado: ");
            System.out.println(libroBuscado.get());
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private void listarLibrosRegistrados() {
        var json = consumoApi.obtenerDatos(URL_BASE);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println("Lista de libros registrados:");
        datos.resultados().forEach(l -> System.out.println(l.titulo()));
    }

    private void listarAutoresRegistrados() {
        // Implementa aquí la lógica para listar autores registrados.
        System.out.println("Función no implementada aún.");
    }

    private void listarAutoresVivos() {
        System.out.println("Ingrese el año para listar autores vivos:");
        int anio = teclado.nextInt();
        teclado.nextLine(); // Limpiar el buffer

        // Implementa aquí la lógica para filtrar autores vivos en el año ingresado.
        System.out.println("Función no implementada aún.");
    }

    private void listarLibrosPorIdioma() {
        System.out.println("Ingrese el idioma (ES, EN, FR, PT):");
        String idioma = teclado.nextLine().toUpperCase();

        var json = consumoApi.obtenerDatos(URL_BASE);
        var datos = conversor.obtenerDatos(json, Datos.class);

        System.out.println("Libros en idioma " + idioma + ":");
        datos.resultados().stream()
                .filter(l -> l.idioma().equalsIgnoreCase(idioma))
                .forEach(l -> System.out.println(l.titulo()));
    }
}

