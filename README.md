# Desafío de Consulta de Libros (Alura Cursos)

Este proyecto es una aplicación Java que interactúa con la API de Gutendex para realizar búsquedas de libros, listar autores y libros registrados, filtrar por idioma, y realizar otras operaciones relacionadas con datos literarios.

## Tecnologías Utilizadas
- **Java 17**: Lenguaje de programación.
- **Spring Boot**: Framework para facilitar la creación de aplicaciones.
- **Jackson**: Biblioteca para el manejo de JSON.
- **JUnit 5**: Framework para pruebas unitarias.

## Estructura del Proyecto
El proyecto se organiza en los siguientes paquetes:
- `com.aluracursos.desafio.model`: Define las clases de datos (`DatosAutor`, `DatosLibros`).
- `com.aluracursos.desafio.service`: Contiene clases para la comunicación con la API y la conversión de datos.
- `com.aluracursos.desafio.principal`: Incluye la clase principal que maneja la lógica del menú y las operaciones del usuario.
- `com.aluracursos.desafio`: Contiene la clase principal de la aplicación para inicializar el contexto.

## Características
1. **Buscar libro por título**: Permite buscar un libro utilizando palabras clave en su título.
2. **Listar libros registrados**: Muestra todos los libros disponibles en la API.
3. **Listar autores registrados**: (Por implementar) Mostrará todos los autores disponibles en la API.
4. **Listar autores vivos en un año específico**: (Por implementar) Filtrará autores basados en su año de nacimiento.
5. **Listar libros por idioma**: Filtra libros según el idioma especificado (ES, EN, FR, PT).
6. **Salir**: Finaliza la ejecución del programa.

## Instalación
1. Clona este repositorio:
   ```bash
 [  git clone https://github.com/tu-usuario/desafio-alura.git](https://github.com/Mayid926/challenge_libros.git)
   cd desafio-alura
Asegúrate de tener Java 17 y Maven instalados.

