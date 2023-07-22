 /**
     * @param args the command line arguments
     * Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos productos que
     * venderemos y el precio que tendrán. Además, se necesita que la aplicación cuente con las funciones básicas.
     * Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio, eliminar un producto y
     * mostrar los productos que tenemos con su precio (Utilizar Hashmap).
     * El HashMap tendrá de llave el nombre del producto y de valor el precio.
     * Realizar un menú para lograr todas las acciones previamente mencionadas.
     */
package Entidades;

import java.util.HashMap;

public class Producto {
    private String nameProduct;
    private Double priceProduct;
    private static HashMap<String, Producto> prod = new HashMap();
    
    public Producto() {
    }

    public static HashMap<String, Producto> getProd() {
        return prod;
    }

    public static void setProd(HashMap<String, Producto> prod) {
        Producto.prod = prod;
    }

    public Producto(String nameProduct, Double priceProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public void add(HashMap<String,Producto> hmp ,Producto p){
        hmp.put(p.nameProduct,p);
    }
    
    public void remove(HashMap<String,Producto> hmp ,Producto p){
        hmp.remove(p.nameProduct,p);
    }
    
}
