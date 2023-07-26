/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.menu;

import java.text.ParseException;
import java.util.Scanner;
import library.persistencia.DAO;
import library.servicios.ServiceAutor;
import library.servicios.ServiceCliente;
import library.servicios.ServiceEditorial;
import library.servicios.ServiceLibro;
import library.servicios.ServicePrestamo;

/**
 *
 * @author tomyv
 */
public class Principal extends DAO {

    private final Scanner sc;
    private final ServiceAutor sa;
    private final ServiceEditorial se;
    private final ServiceLibro sl;
    private final ServiceCliente scl;
    private final ServicePrestamo sp;

    public Principal() {
        this.sl = new ServiceLibro();
        this.se = new ServiceEditorial();
        this.sa = new ServiceAutor();
        this.scl = new ServiceCliente();
        this.sp = new ServicePrestamo();
        this.sc = new Scanner(System.in).useDelimiter("\n");
    }

    public void menu() throws Exception {
        int opt;
        do {
            System.out.println("Elija una opción del menú");
            System.out.println("1 - Libro.");
            System.out.println("2 - Autor.");
            System.out.println("3 - Editorial.");
            System.out.println("4 - Prestamo.");
            System.out.println("5 - Cliente.");
            System.out.println("6 - Salir");
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
                case 4:
                    menuLoan();
                    break;
                case 5:
                    menuClient();
                    break;
            }
        } while (opt != 6);
    }

    public void menuBook() throws Exception {
        int op;
        do {
            System.out.println("1 - Crear");
            System.out.println("2 - Bajar");
            System.out.println("3 - Subir");
            System.out.println("4 - Editar");
            System.out.println("5 - Mostrar Lista");
            System.out.println("6 - Buscar por Name");
            System.out.println("7 - Buscar por Id");
            System.out.println("8 - Salir");
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
                    sl.showUpBook();
                    break;
                case 6:
                    sl.searchByTitleBook();
                    break;
                case 7:
                    sl.searchByIdBook();
                    break;
            }
        } while (op != 8);
    }

    public void menuWriter() throws Exception {
        int op;
        do {
            System.out.println("1 - Crear");
            System.out.println("2 - Bajar");
            System.out.println("3 - Subir");
            System.out.println("4 - Editar");
            System.out.println("5 - Mostrar Lista");
            System.out.println("6 - Buscar por Name");
            System.out.println("7 - Buscar por Id");
            System.out.println("8 - Salir");
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
                    sa.showUpAutor();
                    break;
                case 6:
                    sa.searchByNameAutor();
                    break;
                case 7:
                    sa.searchByIdAutor();
                    break;
            }
        } while (op != 8);

    }

    public void menuPublishing() throws Exception {
        int op;
        do {
            System.out.println("1 - Crear");
            System.out.println("2 - Bajar");
            System.out.println("3 - Subir");
            System.out.println("4 - Editar");
            System.out.println("5 - Mostrar Lista");
            System.out.println("6 - Buscar por Name");
            System.out.println("7 - Buscar por Id");
            System.out.println("8 - Salir");
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
                    se.showUpEditorial();
                    break;
                case 6:
                    se.searchByNameEditorial();
                    break;
                case 7:
                    se.searchByIdEditorial();
                    break;
            }
        } while (op != 8);

    }

    public void menuLoan() throws ParseException {
        int op;
        do {
            System.out.println("1 - Crear");
            System.out.println("2 - Bajar");
            System.out.println("3 - Subir");
            System.out.println("4 - Editar");
            System.out.println("5 - Mostrar Lista");
            System.out.println("6 - Buscar por Id de Libro");
            System.out.println("7 - Buscar por Id de Cliente");
            System.out.println("8 - Salir");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    sp.creation();
                    break;
                case 2:
                    sp.downLoan();
                    break;
                case 3:
                    sp.upLoan();
                    break;
                case 5:
                    sp.showUpLoan();
                    break;
                case 6:
                    sp.searchByIdBook();
                    break;
                case 7:
                    sp.searchByIdClient();
                    break;
            }
        } while (op != 8);

    }

    public void menuClient() {
        int op;
        do {
            System.out.println("1 - Crear");
            System.out.println("2 - Bajar");
            System.out.println("3 - Subir");
            System.out.println("4 - Editar");
            System.out.println("5 - Mostrar Lista");
            System.out.println("6 - Buscar por Id");
            System.out.println("7 - Buscar por Dni");
            System.out.println("8 - Buscar por Nombre");
            System.out.println("9 - Buscar por Apellido");
            System.out.println("10 - Buscar por Telefono");
            System.out.println("11 - Exit");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    scl.createClient();
                    break;
                case 2:
                    scl.showUpClient();
                    scl.downClient();
                    break;
                case 3:
                    scl.showUpClient();
                    scl.upClient();
                    break;
                case 4:
                    scl.showUpClient();
                    scl.editClient();
                    break;
                case 5:
                    scl.showUpClient();
                    break;
                case 6:
                    scl.searchByIdClient();
                    break;
                case 7:
                    scl.searchByDniClient();
                    break;
                case 8:
                    scl.searchByNameClient();
                    break;
                case 9:
                    scl.searchBySurnameClient();
                    break;
                case 10:
                    scl.searchByCellphoneClient();
                    break;

            }
        } while (op != 11);
    }
}
