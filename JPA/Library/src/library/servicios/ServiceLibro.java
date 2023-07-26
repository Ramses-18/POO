/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.servicios;

import java.util.Scanner;
import library.entidades.Autor;
import library.entidades.Editorial;
import library.entidades.Libro;
import library.persistencia.DAOLibro;

/**
 *
 * @author tomyv
 */
public class ServiceLibro extends DAOLibro {

    private Libro l;
    private Autor aut;
    private Editorial edi;
    private final Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private final ServiceAutor sa = new ServiceAutor();
    private final ServiceEditorial se = new ServiceEditorial();

    public void createBook() throws Exception {
        try {
            l = new Libro();
            System.out.println("Datos Del Libro");
            do {
                System.out.println("Isbn");
                l.setId(sc.nextLong());
            } while (verificarISBN(l));
            System.out.println("Titulo");
            l.setTitulo(sc.next());
            l.setAlta(Boolean.TRUE);
            System.out.println("Año");
            l.setAnio(sc.nextInt());
            System.out.println("Ejemplares");
            l.setEjemplares(sc.nextInt());
            int ejp;
            do {
                System.out.println("Ejemplares Prestados");
                ejp = sc.nextInt();
            } while (l.getEjemplares() <= ejp);
            l.setEjemplaresPrestados(ejp);
            l.setEjemplaresRestantes(l.getEjemplares() - l.getEjemplaresPrestados());
            int opt;
            boolean flag1 = true;
            do {
                aut = new Autor();
                System.out.println("1 - Setear un autor ya creado");
                System.out.println("2 - Crear un nuevo autor y setearlo");
                System.out.println("3 - Mostrar todos los autores de la base");
                System.out.println("4 - Salir");
                opt = sc.nextInt();
                switch (opt) {
                    case 1:
                        System.out.println("Sus Autores");
                        sa.showUpAutor();
                        System.out.println("Ingrese su Id");
                        aut.setId(sc.nextLong());
                        if (sa.buscarAutor(aut) != null) {
                            l.setAutor(aut);
                            System.out.println("Seteado de Autor Exitoso");
                            flag1 = false;
                        }
                        break;
                    case 2:
                        l.setAutor(sa.createAutor());
                        flag1 = false;
                        break;
                    case 3:
                        System.out.println("Sus Autores");
                        sa.showUpAutor();
                        break;
                    case 4:
                        flag1 = false;
                        break;
                }
            } while (flag1);
            System.out.println(l.toString());
            boolean flag2 = true;
            int opt2;
            do {
                edi = new Editorial();
                System.out.println("1 - Setear una Editorial ya creada");
                System.out.println("2 - Crear una nueva Editorial y setearla");
                System.out.println("3 - Mostrar todos los Editoriales de la base");
                System.out.println("4 - Salir");
                opt2 = sc.nextInt();
                switch (opt2) {
                    case 1:
                        System.out.println("Sus Editoriales");
                        se.showUpEditorial();
                        System.out.println("Ingrese su Id");
                        Long id_editorial = sc.nextLong();
                        edi.setId(id_editorial);
                        if (se.buscarEditorial(edi) != null) {
                            l.setEditorial(edi);
                            System.out.println("Edirorial seteada exitosamente");
                            flag2 = false;
                        }
                        break;
                    case 2:
                        l.setEditorial(se.createEditorial());
                        System.out.println("Edirorial seteada exitosamente");
                        flag2 = false;
                        break;
                    case 3:
                        System.out.println("Edirorial seteada exitosamente");
                        se.showUpEditorial();
                        break;
                    case 4:
                        flag2 = false;
                        break;
                }
            } while (flag2);
            System.out.println(l.toString());
            crearLibro(l);
        } catch (Exception e) {
            throw e;
        }
    }

    public void downBook() {
        try {
            l = new Libro();
            System.out.println("Id del Libro a Bajar");
            l.setId(sc.nextLong());
            bajarLibro(l);
        } catch (Exception e) {
            throw e;
        }
    }

    public void upBook() {
        try {
            l = new Libro();
            System.out.println("Id del Libro a Subir");
            l.setId(sc.nextLong());
            subirLibro(l);
        } catch (Exception e) {
            throw e;
        }
    }

    public void downAmount(){
        
    }
    
    public void editeBook() throws Exception {
        try {
            l = new Libro();
            int opt;
            do {
                showUpBook();
                System.out.println("1 - Editar Titulo");
                System.out.println("2 - Editar Año");
                System.out.println("3 - Editar Cantidad de Ejemplares");
                System.out.println("4 - Editar Cantidad de Ejemplares Prestado");
                System.out.println("5 - Editar Editorial");
                System.out.println("6 - Editar Autor");
                System.out.println("7 - Salir");
                opt = sc.nextInt();
                System.out.println("ISBN a Editar");
                l.setId(sc.nextLong());
                switch (opt) {
                    case 1:
                        System.out.println("Ingrese su nuevo Titulo");
                        l.setTitulo(sc.next());
                        editeLibro(l, 1);
                        break;
                    case 2:
                        System.out.println("Ingrese su nuevo Año");
                        l.setAnio(sc.nextInt());
                        editeLibro(l, 2);
                        break;
                    case 3:
                        System.out.println("Ingrese su nueva Cantidad de Ejemplares");
                        l.setEjemplares(sc.nextInt());
                        editeLibro(l, 3);
                        break;
                    case 4:
                        System.out.println("Ingrese a actualizar la Cantidad de libros Prestados");
                        l.setEjemplaresPrestados(sc.nextInt());
                        editeLibro(l, 4);
                        break;
                    case 5:
                        edi = new Editorial();
                        boolean flag3 = true;
                        do {
                            System.out.println("1 - Setearle una Editorial ya Creada");
                            System.out.println("2 - Crear la Editorial y Setearla");
                            System.out.println("3 - Salir");
                            switch (sc.nextInt()) {
                                case 1:
                                    if (se.showUpEditorial()) {
                                        System.out.println("Elige una");
                                        System.out.println("Ingrese su ID");
                                        Long id_editorial = sc.nextLong();
                                        edi.setId(id_editorial);
                                        if (se.buscarEditorial(edi) != null) {
                                            l.setEditorial(edi);
                                            editeLibro(l, 5);
                                            System.out.println("Editorial seteada Exitosamente");
                                            flag3 = false;
                                        }
                                    }
                                    break;
                                case 2:
                                    l.setEditorial(se.createEditorial());
                                    editeLibro(l, 5);
                                    System.out.println("Editorial seteada Exitosamente");
                                    flag3 = false;
                                    break;
                                case 3:
                                    flag3 = false;
                                    break;
                            }

                        } while (flag3);
                        break;
                    case 6:
                        aut = new Autor();
                        boolean flag4 = true;
                        do {
                            System.out.println("1 - Setearla un Autor ya Creado");
                            System.out.println("2 - Crear un autor y setearlo");
                            System.out.println("3 - Salir");
                            switch (sc.nextInt()) {
                                case 1:
                                    if (sa.showUpAutor()) {
                                        System.out.println("Ingrese su ID");
                                        aut.setId(sc.nextLong());
                                        if (sa.buscarAutor(aut) != null) {
                                            l.setAutor(aut);
                                            editeLibro(l, 6);
                                            System.out.println("Seteado de Autor Exitoso");
                                            flag4 = false;
                                        }
                                    }
                                    break;
                                case 2:
                                    l.setAutor(sa.createAutor());
                                    editeLibro(l, 6);
                                    flag4 = false;
                                    break;
                                case 3:
                                    flag4 = false;
                                    break;
                            }
                        } while (flag4);
                        break;
                }
            } while (opt != 7);

        } catch (Exception e) {
            throw e;
        }
    }

    public void searchBook() {
        try {
            l = new Libro();
            System.out.println("Ingrese ID a buscar");
            l.setId(sc.nextLong());
            buscarLibro(l);
        } catch (Exception e) {
            throw e;
        }
    }

    public void showUpBook() {
        try {
            listarLibros();
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByTitleBook() {
        try {
            l = new Libro();
            System.out.println("Ingrese el Titulo a Buscar");
            l.setTitulo(sc.next());
            buscarLibroPorNombre(l);
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByIdBook() {
        try {
            l = new Libro();
            System.out.println("Ingrese el ISBN que desea encontrar");
            l.setId(sc.nextLong());
            buscarLibroPorId(l);
        } catch (Exception e) {
            throw e;
        }
    }

}
