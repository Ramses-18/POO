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
            System.out.println("DATOS DEL LIBRO");
            do {
                System.out.println("ISBN");
                l.setId(sc.nextLong());
            } while (verificarISBN(l));
            System.out.println("TITULO");
            l.setTitulo(sc.next());
            l.setAlta(Boolean.TRUE);
            System.out.println("AÑO");
            l.setAnio(sc.nextInt());
            System.out.println("EJEMPLARES");
            l.setEjemplares(sc.nextInt());
            int ejp;
            do {
                System.out.println("EJEMPLARES PRESTADOS");
                ejp = sc.nextInt();
            } while (l.getEjemplares() >= ejp);
            l.setEjemplaresPrestados(ejp);
            l.setEjemplaresRestantes(l.getEjemplares() - l.getEjemplaresPrestados());
            int opt;
            boolean flag1 = true;
            do {
                aut = new Autor();
                System.out.println("1 - ASIGNAR UN AUTOR PREVIAMENTE CREADO");
                System.out.println("2 - INGRESAR UN NUEVO AUTOR EN LA BASE DE DATOS");
                System.out.println("3 - MOSTRAR AUTORES DE LA BASE");
                System.out.println("4 - SALIR");
                opt = sc.nextInt();
                switch (opt) {
                    case 1:
                        System.out.println("INGRESE SU ID");
                        aut.setId(sc.nextLong());
                        if (sa.buscarAutor(aut) != null) {
                            l.setAutor(aut);
                            System.out.println("SETEADO DE AUTOR EXITOSO");
                            flag1 = false;
                        }
                        break;
                    case 2:
                        l.setAutor(sa.createAutor());
                        flag1 = false;
                        break;
                    case 3:
                        System.out.println("ESTOS SON LOS AUTORES EN LA BASE");
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
                System.out.println("1 - ASIGNAR UNA EDITORIAL CREADA PREVIAMENTE");
                System.out.println("2 - INGRESAR UNA NUEVA EDITORIAL EN LA BASE DE DATOS");
                System.out.println("3 - VER EDITORIALES PREVIAMENTE CREADAS");
                System.out.println("4 - SALIR");
                opt2 = sc.nextInt();
                switch (opt2) {
                    case 1:
                        System.out.println("INGRESE SU ID");
                        Long id_editorial = sc.nextLong();
                        edi.setId(id_editorial);
                        if (se.buscarEditorial(edi) != null) {
                            l.setEditorial(edi);
                            System.out.println("EDITORIAL SETEADA EXITOSAMENTE");
                            flag2 = false;
                        }
                        break;
                    case 2:
                        l.setEditorial(se.createEditorial());
                        System.out.println("EDITORIAL SETEADA EXITOSAMENTE");
                        flag2 = false;
                        break;
                    case 3:
                        System.out.println("ESTAS SON LAS EDITORIALES EN LA BASE");
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
            System.out.println("ID DEL LIBRO A BAJAR");
            l.setId(sc.nextLong());
            bajarLibro(l);
        } catch (Exception e) {
            throw e;
        }
    }

    public void upBook() {
        try {
            l = new Libro();
            System.out.println("ID DEL LIBRO A SUBIR");
            l.setId(sc.nextLong());
            subirLibro(l);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editeBook() throws Exception {
        try {
            l = new Libro();
            int opt;
            do {
                showUpBook();
                System.out.println("1 - EDITAR TITULO");
                System.out.println("2 - EDITAR AÑO");
                System.out.println("3 - EDITAR CANTIDAD DE EJEMPLARES");
                System.out.println("4 - EDITAR EJEMPLARES PRESTADOS");
                System.out.println("5 - EDITAR EDITORIAL");
                System.out.println("6 - EDITAR AUTOR");
                System.out.println("7 - SALIR");
                opt = sc.nextInt();
                switch (opt) {
                    case 1:
                        System.out.println("ISBN A EDITAR");
                        l.setId(sc.nextLong());
                        System.out.println("INGRESE EL NUEVO TITULO");
                        l.setTitulo(sc.next());
                        editeLibro(l, 1);
                        break;
                    case 2:
                        System.out.println("ISBN A EDITAR");
                        l.setId(sc.nextLong());
                        System.out.println("INGRESE EL NUEVO AÑO");
                        l.setAnio(sc.nextInt());
                        editeLibro(l, 2);
                        break;
                    case 3:
                        System.out.println("ISBN A EDITAR");
                        l.setId(sc.nextLong());
                        System.out.println("INGRESE NUEVA CANTIDAD DE EJEMPLARES");
                        l.setEjemplares(sc.nextInt());
                        editeLibro(l, 3);
                        break;
                    case 4:
                        System.out.println("ISBN A EDITAR");
                        l.setId(sc.nextLong());
                        System.out.println("INGRESE LOS LIBROS PRESTADOS");
                        l.setEjemplaresPrestados(sc.nextInt());
                        editeLibro(l, 4);
                        break;
                    case 5:
                        edi = new Editorial();
                        boolean flag3 = true;
                        do {
                            System.out.println("1 - CAMBIAR LA EDITORIAL A UNA YA CREADA");
                            System.out.println("2 - CREAR UNA NUEVA EDITORIAL Y SETEARLA");
                            System.out.println("3 - SALIR");
                            switch (sc.nextInt()) {
                                case 1:
                                    if (se.showUpEditorial()) {
                                        System.out.println("ELIGE UNA");
                                        System.out.println("INGRESE SU ID");
                                        Long id_editorial = sc.nextLong();
                                        edi.setId(id_editorial);
                                        if (se.buscarEditorial(edi) != null) {
                                            l.setEditorial(edi);
                                            editeLibro(l, 5);
                                            System.out.println("EDITORIAL SETEADA EXITOSAMENTE");
                                            flag3 = false;
                                        }
                                    }
                                    break;
                                case 2:
                                    l.setEditorial(se.createEditorial());
                                    editeLibro(l, 5);
                                    System.out.println("EDITORIAL SETEADA EXITOSAMENTE");
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
                            System.out.println("1 - CAMBIAR EL AUTOR A UNO YA CREADO");
                            System.out.println("2 - CREAR UN NUEVO AUTOR Y SETEARLO");
                            System.out.println("3 - SALIR");
                            switch (sc.nextInt()) {
                                case 1:
                                    if (sa.showUpAutor()) {
                                        System.out.println("INGRESE SU ID");
                                        aut.setId(sc.nextLong());
                                        if (sa.buscarAutor(aut) != null) {
                                            l.setAutor(aut);
                                            editeLibro(l, 6);
                                            System.out.println("SETEADO DE AUTOR EXITOSO");
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
            System.out.println("INGRESE EL TITULO");
            l.setTitulo(sc.next());
            buscarLibroPorNombre(l);
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByIdBook() {
        try {
            l = new Libro();
            System.out.println("INGRESE EL ISBN");
            l.setId(sc.nextLong());
            buscarEditorialPorId(l);
        } catch (Exception e) {
            throw e;
        }
    }

}
