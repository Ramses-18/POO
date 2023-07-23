/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.services;

import java.util.List;
import java.util.Scanner;
import store.entidades.Fabricante;
import store.persistencia.DAOFabricante;

/**
 *
 * @author tomyv
 */
public class ServiceFabricante extends DAOFabricante {

    private final Scanner sc = new Scanner(System.in).useDelimiter("\n");
    ;
    private Fabricante aut;

    public Fabricante createFabricante() {
        try {
            aut = new Fabricante();
            Fabricante fab = new Fabricante();
            do {
                System.out.println("NOMBRE");
                fab.setNombre(sc.next());
            } while (buscarFabricante(fab,2) != null);
            aut.setNombre(fab.getNombre());
            aut.setAlta(Boolean.TRUE);
            crearFabricante(aut);
            System.out.println("FABRICANTE CREADO");
            return aut;
        } catch (Exception e) {
            throw e;
        }       
    }

    public void downFabricante() throws Exception {
        try {
            aut = new Fabricante();
            System.out.println("Id a bajar");
            aut.setId(sc.nextLong());
            bajarFabricante(aut);
        } catch (Exception e) {
            throw e;
        }
    }

    public void upFabricante() throws Exception {
        try {
            aut = new Fabricante();
            System.out.println("Id a subir");
            aut.setId(sc.nextLong());
            subirFabricante(aut);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editeFabricante() throws Exception {
        try {
            aut = new Fabricante();
            System.out.println("Id a cambiar");
            aut.setId(sc.nextLong());
            System.out.println("Nuevo Nombre");
            aut.setNombre(sc.next());
            editarFabricante(aut);
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchFabricante() {
        try {
            aut = new Fabricante();
            System.out.println("Ingrese ID a buscar");
            aut.setId(sc.nextLong());
            buscarFabricante(aut,1);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean showUpFabricante() {
        try {
            List<Fabricante> lista = listarFabricante();
            if (lista == null) {
                System.out.println("NO SE HA INGRESADOS NINGUN FABRICANTE");
                return false;
            } else {
                for (Fabricante aux : lista) {
                    System.out.println(aux.toString());
                }
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByNameFabricante() {
        try {
            aut = new Fabricante();
            System.out.println("INGRESE EL NOMBRE");
            aut.setNombre(sc.next());
            buscarFabricantePorNombre(aut);
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByIdFabricante() {
        try {
            aut = new Fabricante();
            System.out.println("INGRESE EL ID_FABRICANTE");
            aut.setId(sc.nextLong());
            buscarFabricantePorId(aut);
        } catch (Exception e) {
            throw e;
        }
    }
}
