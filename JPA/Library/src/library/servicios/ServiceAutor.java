/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.servicios;

import java.util.List;
import java.util.Scanner;
import library.entidades.Autor;
import library.persistencia.DAOAutor;

/**
 *
 * @author tomyv
 */
public class ServiceAutor extends DAOAutor {

    private Scanner sc;
    private Autor aut;

    public ServiceAutor() {
        this.sc = new Scanner(System.in).useDelimiter("\n");
    }

    public Autor createAutor() {
        try {
            aut = new Autor();
            do {
                System.out.println("Nombre");
                aut.setNombre(sc.next());
            } while (!verificarNombreAutor(aut));
            aut.setAlta(Boolean.TRUE);
            crearAutor(aut);
            System.out.println("Autor Creado");
        } catch (Exception e) {
            throw e;
        }
        return aut;
    }

    public void downAutor() throws Exception {
        try {
            aut = new Autor();
            System.out.println("Id a bajar");
            aut.setId(sc.nextLong());
            bajarAutor(aut);
        } catch (Exception e) {
            throw e;
        }
    }

    public void upAutor() throws Exception {
        try {
            aut = new Autor();
            System.out.println("Id a subir");
            aut.setId(sc.nextLong());
            subirAutor(aut);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editeAutor() throws Exception {
        try {
            aut = new Autor();
            System.out.println("Id a cambiar");
            aut.setId(sc.nextLong());
            System.out.println("Nuevo Nombre");
            aut.setNombre(sc.next());
            editarAutor(aut);
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchAutor() {
        try {
            aut = new Autor();
            System.out.println("Ingrese ID a buscar");
            aut.setId(sc.nextLong());
            buscarAutor(aut);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean showUpAutor() {
        try {
            List<Autor> lista = listarAutor();
            if (lista == null) {
                System.out.println("NO SE HA INGRESADOS NINGUN AUTOR");
                return false;
            } else {
                for (Autor aux : lista) {
                    System.out.println(aux.toString());
                }
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByNameAutor() {
        try {
            aut = new Autor();
            System.out.println("INGRESE EL NOMBRE");
            aut.setNombre(sc.next());
            buscarAutorPorNombre(aut);
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByIdAutor() {
        try {
            aut = new Autor();
            System.out.println("INGRESE EL ID_AUTOR");
            aut.setId(sc.nextLong());
            buscarAutorPorId(aut);
        } catch (Exception e) {
            throw e;
        }
    }
}
