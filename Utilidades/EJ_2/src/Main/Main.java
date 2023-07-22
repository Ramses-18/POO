package Main;

import Services.ParDeNumerosService;

public class Main {

    public static void main(String[] args) {
        ParDeNumerosService p = new ParDeNumerosService();
        
        p.mostrarValores();
        
        System.out.println("EL MAYOR ES " + p.devolverMayor());
        
        p.calcularPotencia();
        
        p.calcularRaiz();
        
    }

}
