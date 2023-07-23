/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.services;

import java.util.List;
import java.util.Scanner;
import store.entidades.Fabricante;
import store.entidades.Producto;
import store.persistencia.DAOProducto;

/**
 *
 * @author tomyv
 */
public class ServiceProducto extends DAOProducto {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private Producto pro;
    private Fabricante fab;
    private ServiceFabricante sf;

    public Producto createProducto() {
        try {
            pro = new Producto();
            System.out.println("NOMBRE");
            pro.setNombre(sc.next());
            pro.setAlta(Boolean.TRUE);
            System.out.println("PRECIO");
            pro.setPrecio(sc.nextDouble());
            int opt;
            boolean flag1 = true;
            do {
                sf = new ServiceFabricante();
                fab = new Fabricante();
                System.out.println("1 - ASIGNAR UN FABRICANTE PREVIAMENTE DE LA BASE");
                System.out.println("2 - CREAR UN NUEVO FABRICANTE EN LA BASE DE DATOS ");
                System.out.println("3 - MOSTRAR FABRICANTE DE LA BASE");
                System.out.println("4 - SALIR");
                opt = sc.nextInt();
                switch (opt) {
                    case 1:
                        System.out.println("INGRESE SU ID");
                        fab.setId(sc.nextLong());
                        if (sf.buscarFabricante(fab, 1) != null) {
                            pro.setFabricante(fab);
                            System.out.println("SETEADO DE FABRICANTE EXITOSO");
                            flag1 = false;
                        }
                        break;
                    case 2:
                        pro.setFabricante(sf.createFabricante());
                        flag1 = false;
                        break;
                    case 3:
                        System.out.println("ESTOS SON LOS AUTORES EN LA BASE");
                        sf.showUpFabricante();
                        break;
                    case 4:
                        flag1 = false;
                        break;
                }
            } while (flag1);
            crearProducto(pro);
            System.out.println("PRODUCTO CREADO EXITOSAMENTE");
        } catch (Exception e) {
            throw e;
        }
        return pro;
    }

    public void downProducto() throws Exception {
        try {
            pro = new Producto();
            System.out.println("Id a bajar");
            pro.setId(sc.nextLong());
            bajarProducto(pro);
        } catch (Exception e) {
            throw e;
        }
    }

    public void upProducto() throws Exception {
        try {
            pro = new Producto();
            System.out.println("Id a subir");
            pro.setId(sc.nextLong());
            subirProducto(pro);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editeProducto() throws Exception {
        try {
            boolean flag = true;
            int op;
            pro = new Producto();
            fab = new Fabricante();
            do {
                System.out.println("1 - EDITAR NOMBRE");
                System.out.println("2 - EDITAR PRECIO");
                System.out.println("3 - EDITAR FABRICANTE");
                System.out.println("4 - SALIR");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("SUS PRODUCTOS");
                        showUpProducto();
                        System.out.println("ID");
                        pro.setId(sc.nextLong());
                        System.out.println("INGRESE NUEVO NOMBRE");
                        pro.setNombre(sc.next());
                        editarProducto(pro, 1);
                        flag = false;
                        break;
                    case 2:
                        System.out.println("SUS PRODUCTOS");
                        showUpProducto();
                        System.out.println("ID");
                        pro.setId(sc.nextLong());
                        System.out.println("INGRESE NUEVO PRECIO");
                        pro.setPrecio(sc.nextDouble());
                        editarProducto(pro, 2);
                        flag = false;
                        break;
                    case 3:
                        Boolean flag2 = true;
                        sf = new ServiceFabricante();
                        do {
                            System.out.println("1 - CAMBIAR EL FABRICANTE A UNO YA CREADO");
                            System.out.println("2 - CREAR UN NUEVO FABRICANTE Y SETEARLO");
                            System.out.println("3 - SALIR");
                            switch (sc.nextInt()) {
                                case 1:
                                    System.out.println("SUS PRODUCTOS");
                                    showUpProducto();
                                    do {
                                        System.out.println("INGRESE ID DEL PRODUCTO A EDITAR");
                                        pro.setId(sc.nextLong());
                                    } while (!buscarProductoPorId(pro));
                                    System.out.println("SUS FABRICANTES");
                                    if (sf.showUpFabricante()) {
                                        do {
                                            System.out.println("INGRESE EL ID DEL FABRICANTE");
                                            fab.setId(sc.nextLong());
                                        } while (!sf.buscarFabricantePorId(fab));
                                        if (sf.buscarFabricante(fab, 2) != null) {
                                            pro.setFabricante(fab);
                                            editarProducto(pro, 3);
                                            System.out.println("FABRICANTE SETEADA EXITOSAMENTE");
                                            flag2 = false;
                                        }
                                    }
                                    break;
                                case 2:
                                    do {
                                        System.out.println("INGRESE ID DEL PRODUCTO A EDITAR");
                                        pro.setId(sc.nextLong());
                                    } while (!buscarProductoPorId(pro));
                                    pro.setFabricante(sf.createFabricante());
                                    editarProducto(pro, 3);
                                    flag2 = false;
                                    break;
                                case 3:
                                    flag2 = false;
                                    break;
                            }
                        } while (flag2);
                        break;
                    case 4:
                        flag = false;
                        break;
                }
            } while (flag);

        } catch (Exception e) {
            throw e;
        }
    }

    public void searchProducto() {
        try {
            pro = new Producto();
            System.out.println("Ingrese ID a buscar");
            pro.setId(sc.nextLong());
            buscarProducto(pro);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean showUpProducto() {
        try {
            List<Producto> lista = listarProducto();
            if (lista == null) {
                System.out.println("NO SE HA INGRESADOS NINGUN PRODUCTO");
                return false;
            } else {
                for (Producto aux : lista) {
                    System.out.println(aux.toString());
                }
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByNameProducto() {
        try {
            pro = new Producto();
            System.out.println("INGRESE EL NOMBRE");
            pro.setNombre(sc.next());
            buscarProductoPorNombre(pro);
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchByIdProducto() {
        try {
            pro = new Producto();
            System.out.println("INGRESE EL ID_AUTOR");
            pro.setId(sc.nextLong());
            buscarProductoPorId(pro);
        } catch (Exception e) {
            throw e;
        }
    }
}
