/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.menu;

import java.util.Scanner;
import library.persistencia.DAO;
import library.servicios.ServiceAutor;
import library.servicios.ServiceEditorial;
import library.servicios.ServiceLibro;

/**
 *
 * @author tomyv
 */
public class Principal extends DAO {

    private final Scanner sc;
    private final ServiceAutor sa;
    private final ServiceEditorial se;
    private final ServiceLibro sl;

    public Principal() {
        this.sl = new ServiceLibro();
        this.se = new ServiceEditorial();
        this.sa = new ServiceAutor();
        this.sc = new Scanner(System.in).useDelimiter("\n");
    }

    public void menu() throws Exception {
        int opt;
        do {
            System.out.println("Elija una opción del menú");
            System.out.println("1 - Crear/Modificar/Eliminar un Libro.");
            System.out.println("2 - Crear/Modificar/Eliminar un Autor.");
            System.out.println("3 - Crear/Modificar/Eliminar una Editorial.");
            System.out.println("4 - Salir");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    menuBook();
                    break;
                case 2:
                    menuWriter();
                    break;
                case 3:
                    menuPublishing();
                    break;
            }
        } while (opt != 4);
    }

    public void menuBook() throws Exception {
        int op;
        do {
            System.out.println("1 - Create");
            System.out.println("2 - Down");
            System.out.println("3 - Up");
            System.out.println("4 - Edit");
            System.out.println("5 - Ask");
            System.out.println("6 - Show List");
            System.out.println("7 - Search by Title");
            System.out.println("8 - Search by Id");
            System.out.println("9 - Exit");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    sl.createBook();
                    break;
                case 2:
                    sl.downBook();
                    break;
                case 3:
                    sl.upBook();
                    break;
                case 4:
                    sl.editeBook();
                    break;
                case 5:
                    sl.searchBook();
                    break;
                case 6:
                    sl.showUpBook();
                    break;
                case 7:
                    sl.searchByTitleBook();
                    break;
                case 8:
                    sl.searchByIdBook();
                    break;
            }
        } while (op != 9);
    }
    
    public void menuWriter() throws Exception {
        int op;
        do {
            System.out.println("1 - Create");
            System.out.println("2 - Down");
            System.out.println("3 - Up");
            System.out.println("4 - Edit");
            System.out.println("5 - Ask");
            System.out.println("6 - Show List");
            System.out.println("7 - Search by name");
            System.out.println("8 - Search by Id");
            System.out.println("9 - Exit");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    sa.createAutor();
                    break;
                case 2:
                    sa.downAutor();
                    break;
                case 3:
                    sa.upAutor();
                    break;
                case 4:
                    sa.editeAutor();
                    break;
                case 5:
                    sa.searchAutor();
                    break;
                case 6:
                    sa.showUpAutor();
                    break;
                case 7:
                    sa.searchByNameAutor();
                    break;
                case 8:
                    sa.searchByIdAutor();
                    break;
            }
        } while (op != 9);

    }

    public void menuPublishing() throws Exception {
        int op;
        do {
            System.out.println("1 - Create");
            System.out.println("2 - Down");
            System.out.println("3 - Up");
            System.out.println("4 - Edit");
            System.out.println("5 - Ask");
            System.out.println("6 - Show List");
            System.out.println("7 - Search by name");
            System.out.println("8 - Search by Id");
            System.out.println("9 - Exit");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    se.createEditorial();
                    break;
                case 2:
                    se.downEditorial();
                    break;
                case 3:
                    se.upEditorial();
                    break;
                case 4:
                    se.editeEditorial();
                    break;
                case 5:
                    se.searchEditorial();
                    break;
                case 6:
                    se.showUpEditorial();
                    break;
                case 7:
                    se.searchByNameEditorial();
                    break;
                case 8:
                    se.searchByIdEditorial();
                    break;
            }
        } while (op != 9);

    }
 
}
