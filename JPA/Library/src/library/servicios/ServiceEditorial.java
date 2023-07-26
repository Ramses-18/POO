/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.servicios;

import java.util.List;
import java.util.Scanner;
import library.entidades.Editorial;
import library.persistencia.DAOEditorial;

/**
 *
 * @author tomyv
 */
public class ServiceEditorial extends DAOEditorial {

    private final Scanner sc;
    private Editorial ed;

    public ServiceEditorial() {
        this.sc = new Scanner(System.in).useDelimiter("\n");
    }

    public Editorial createEditorial() {
        try {
            ed = new Editorial();
            String name;
            do {
                System.out.println("Nombre Editorial");
                name = sc.next();
            } while (!verificarTitulo(ed));
            ed.setNombre(name);
            ed.setAlta(true);
            crearEditorial(ed);
            System.out.println("Editorial Creada");
        } catch (Exception e) {
            throw e;
        }
        return ed;
    }

    public void downEditorial() throws Exception {
        try {
            ed = new Editorial();
            System.out.println("Id a bajar");
            ed.setId(sc.nextLong());
            bajarEditorial(ed);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void upEditorial() throws Exception {
        try {
            ed = new Editorial();
            System.out.println("Id a subir");
            ed.setId(sc.nextLong());
            subirEditorial(ed);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editeEditorial() throws Exception {
        try {
            ed = new Editorial();
            System.out.println("Id a cambiar");
            ed.setId(sc.nextLong());
            System.out.println("Nuevo Nombre");            
            ed.setNombre(sc.next());
            editarEditorial(ed);
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchEditorial() {
        try {
            ed = new Editorial();
            System.out.println("Ingrese ID a buscar");
            ed.setId(sc.nextLong());
            buscarEditorial(ed);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean showUpEditorial() {
        try {
            List<Editorial> ed = listarEditorial();
            if (ed == null) {
                System.out.println("No se ha ingresado Ninguna Editotial a la Base De Datos");
                return false;
            } else {
                for (Editorial aux : ed) {
                    System.out.println(aux.toString());
                }
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByNameEditorial(){
        try {
            ed = new Editorial();
            System.out.println("Ingrese el Nombre de la Editorial");
            ed.setNombre(sc.next());
            buscarEditorialPorNombre(ed);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void searchByIdEditorial(){
        try {
            ed = new Editorial();
            System.out.println("Ingrese el Id del Autor");
            ed.setId(sc.nextLong());
            buscarEditorialPorId(ed);
        } catch (Exception e) {
            throw e;
        }
    }
}
