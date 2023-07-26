/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.servicios;

import java.util.Scanner;
import library.entidades.Cliente;
import library.persistencia.DAOCliente;

/**
 *
 * @author tomyv
 */
public class ServiceCliente extends DAOCliente {

    private Cliente cl;
    private Scanner sc;

    public Cliente createClient() {
        sc = new Scanner(System.in).useDelimiter("\n");
        cl = new Cliente();
        System.out.println("Nombre");
        cl.setNombre(sc.next());
        System.out.println("Apellido");
        cl.setApellido(sc.next());
        System.out.println("Dni");
        cl.setDni(sc.nextLong());
        System.out.println("Telefono");
        cl.setTelefono(sc.next());
        cl.setAlta(Boolean.TRUE);
        crearCliente(cl);
        return cl;
    }

    public void downClient() {
        try {
            cl = new Cliente();
            sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Id del Cliente a Bajar");
            cl.setId(sc.nextLong());
            bajarCliente(cl);
        } catch (Exception e) {
            throw e;
        }
    }

    public void upClient() {
        try {
            cl = new Cliente();
            sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Id del Cliente a Subir");
            cl.setId(sc.nextLong());
            subirCliente(cl);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editClient() {
        cl = new Cliente();
        sc = new Scanner(System.in).useDelimiter("\n");
        int op;
        do {
            System.out.println("1 - Editar Nombre");
            System.out.println("2 - Editar Apellido");
            System.out.println("3 - Editar Dni");
            System.out.println("4 - Editar Telefono");
            System.out.println("5 - Salir");
            op = sc.nextInt();
            System.out.println("Ingrese Id del Cliente");
            cl.setId(sc.nextLong());
            switch (op) {
                case 1:
                    System.out.println("Nuevo Nombre");
                    cl.setNombre(sc.next());
                    editarCliente(cl,1);
                    break;
                case 2:
                    System.out.println("Nuevo Apellido");
                    cl.setApellido(sc.next());
                    editarCliente(cl, 2);
                    break;
                case 3:
                    System.out.println("Nuevo Dni");
                    cl.setDni(sc.nextLong());
                    editarCliente(cl, 3);
                    break;
                case 4:
                    System.out.println("Nuevo Telefono");
                    cl.setTelefono(sc.next());
                    editarCliente(cl, 4);
                    break;
            }
        } while (op != 5);

    }

    public void listClient() {
        super.listarCliente();
    }

    public void showUpClient() {
        try {
            listarCliente();
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByNameClient() {
        try {
            cl = new Cliente();
            sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Ingrese el Nombre Del Cliente");
            cl.setNombre(sc.next());
            buscarClientePorNombre(cl);
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByIdClient() {
        try {
            cl = new Cliente();
            sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Ingrese el Id Del Cliente");
            cl.setId(sc.nextLong());
            buscarClientePorId(cl);
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByCellphoneClient() {
        try {
            cl = new Cliente();
            sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Ingrese el numero de Telefono");
            cl.setTelefono(sc.next());
            buscarClientePorTelefono(cl);
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchBySurnameClient() {
        try {
            cl = new Cliente();
            sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Ingrese el Apellido del Cliente");
            cl.setApellido(sc.next());
            buscarClientePorApellido(cl);
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByDniClient() {
        try {
            cl = new Cliente();
            sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Ingrese el DNI del Cliente");
            cl.setDni(sc.nextLong());
            buscarClientePorDni(cl);
        } catch (Exception e) {
            throw e;
        }
    }
}
