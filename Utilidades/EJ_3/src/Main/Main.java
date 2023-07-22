package Main;

import Services.ArreglosService;

public class Main {
    public static void main(String[] args) {
        ArreglosService as = new ArreglosService();
        //Crear en el Main dos arreglos. El arreglo A de 50 números reales y el arreglo B de 20 números reales.
        Integer ArregloA[] = new Integer [50];
        double ArregloB[] = new double [20];
        System.out.println("FIRST ARRAY");
        as.inicializarA(ArregloA);
        System.out.println("ORDER");
        as.ordenar(ArregloA);
        System.out.println("ARRAY B");
        as.inicializarB(ArregloA, ArregloB);
    }
    
}
