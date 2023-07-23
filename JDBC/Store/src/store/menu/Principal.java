/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.menu;

import java.util.Scanner;
import store.services.ServiceFabricante;
import store.services.ServiceProducto;

/**
 *
 * @author tomyv
 */
public class Principal {
    
    private final Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private final ServiceFabricante sf = new ServiceFabricante();
    private final ServiceProducto sp = new ServiceProducto();
    
    public void menu() throws Exception {
        int opt;
        do {
            System.out.println("Elija una opción del menú");
            System.out.println("1 - Crear/Modificar/Eliminar un Producto.");
            System.out.println("2 - Crear/Modificar/Eliminar un Fabricante.");
            System.out.println("3 - Salir");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    menuProduct();
                    break;
                case 2:
                    menuManufacturer();
                    break;
            }
        } while (opt != 4);
    }

    public void menuProduct() throws Exception {
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
                    sp.createProducto();
                    break;
                case 2:
                    sp.downProducto();
                    break;
                case 3:
                    sp.upProducto();
                    break;
                case 4:
                    sp.editeProducto();
                    break;
                case 5:
                    sp.searchProducto();
                    break;
                case 6:
                    sp.showUpProducto();
                    break;
                case 7:
                    sp.searchByNameProducto();
                    break;
                case 8:
                    sp.searchByIdProducto();
                    break;
            }
        } while (op != 9);
    }
    
    public void menuManufacturer() throws Exception {
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
                    sf.createFabricante();
                    break;
                case 2:
                    sf.downFabricante();
                    break;
                case 3:
                    sf.upFabricante();
                    break;
                case 4:
                    sf.editeFabricante();
                    break;
                case 5:
                    sf.searchByNameFabricante();
                    break;
                case 6:
                    sf.showUpFabricante();
                    break;
                case 7:
                    sf.searchByNameFabricante();
                    break;
                case 8:
                    sf.searchByIdFabricante();
                    break;
            }
        } while (op != 9);

    }
    
}
