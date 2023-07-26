/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import library.entidades.Cliente;
import library.entidades.Libro;
import library.entidades.Prestamo;
import library.persistencia.DAOLibro;
import library.persistencia.DAOPrestamo;

/**
 *
 * @author tomyv
 */
public class ServicePrestamo extends DAOPrestamo {

    private Prestamo pr;
    private Scanner sc;
    private Cliente cl;
    private Libro l;
    private ServiceCliente scl;
    private ServiceLibro sl;

    public Prestamo crPrestamo() {
        return new Prestamo();
    }

    public void creation() throws ParseException {
        sc = new Scanner(System.in).useDelimiter("\n");
        cl = new Cliente();
        l = new Libro();
        scl = new ServiceCliente();
        sl = new ServiceLibro();
        System.out.println("Cuantos Libros a llevar?");
        int cant = sc.nextInt();
        for (int i = 0; i < cant; i++) {
            pr = crPrestamo();
            if (i == 0) {
                int op;
                do {
                    System.out.println("1 - Nuevo Cliente");
                    System.out.println("2 - Ya Registrado");
                    op = sc.nextInt();
                    switch (op) {
                        case 1:
                            pr.setCliente(scl.createClient());
                            break;
                        case 2:
                            scl.showUpClient();
                            System.out.println("Ingrese su Id");
                            cl.setId(sc.nextLong());
                            if (scl.buscarCliente(cl) != null) {
                                pr.setCliente(scl.buscarCliente(cl));
                            }
                            break;
                    }
                } while (op != 1 && op != 2);
            }
            if (i > 0) {
                pr.setCliente(scl.buscarCliente(cl));
            }
            Calendar cal = Calendar.getInstance();
            pr.setFechaPrestamo(cal.getTime());
            pr.setAlta(true);
            System.out.println("Libros a Llevar");
            sl.showUpBook();
            System.out.println("Ingrese su Id");
            l.setId(sc.nextLong());
            //Checkear que ese Libro exista
            if (sl.buscarLibro(l) != null) {
                pr.setLibro(sl.buscarLibro(l));
                // Buscar ese Libro y Disminuir la Cantidad de Ejemplares
                Libro l2 = sl.buscarLibro(l);
                if (l2.getEjemplaresRestantes() != 0) {
                    l2.setEjemplaresPrestados(l2.getEjemplaresPrestados() + 1);
                    l2.setEjemplaresRestantes(l2.getEjemplaresRestantes() - 1);
                    DAOLibro DAO = new DAOLibro();
                    DAO.upload(l2);
                    System.out.println("Ingrese la Fecha de Devolucion DD/MMM/YYY");
                    String fechaString = sc.next();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        pr.setFechaDevolucion(dateFormat.parse(fechaString));
                    } catch (ParseException e) {
                        throw e;
                    }
                    crearPrestamo(pr);
                } else {
                    System.out.println("Libro Agotado");
                    i = i - 1;
                }
            } else {
                System.out.println("No existe ese Id");
                i = i - 1;
            }
        }

        System.out.println("Prestamos Creados Exitosamente");
    }

    public void downLoan() {
        try {
            pr = new Prestamo();
            sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Id del Prestamo a Bajar");
            pr.setId(sc.nextLong());
            bajarPrestamo(pr);
        } catch (Exception e) {
            throw e;
        }
    }

    public void upLoan() {
        try {
            pr = new Prestamo();
            sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Id del Prestamo a Subir");
            pr.setId(sc.nextLong());
            subirPrestamo(pr);
        } catch (Exception e) {
            throw e;
        }
    }

    public void showUpLoan() {
        listarPrestamo();
    }

    public void searchById() {
        try {
            sc = new Scanner(System.in).useDelimiter("\n");
            pr = new Prestamo();
            System.out.println("Ingrese su Id");
            pr.setId(sc.nextLong());
            buscarPrestamoPorId(pr);
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByIdClient() {
        try {
            sc = new Scanner(System.in).useDelimiter("\n");
            pr = new Prestamo();
            cl = new Cliente();
            System.out.println("Ingrese el Id del Cliente del Prestamo");
            cl.setId(sc.nextLong());
            pr.setCliente(cl);
            buscarPrestamoPorIdCliente(pr);
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByIdBook() {
        try {
            sc = new Scanner(System.in).useDelimiter("\n");
            pr = new Prestamo();
            l = new Libro();
            System.out.println("Ingrese el Id del Libro del Prestamo");
            l.setId(sc.nextLong());
            pr.setLibro(l);
            buscarPrestamoPorIdLibro(pr);
        } catch (Exception e) {
            throw e;
        }
    }
}
