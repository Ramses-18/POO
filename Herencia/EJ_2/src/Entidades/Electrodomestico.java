/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author tomyv
 *
 * Crear una superclase llamada Electrodoméstico con los siguientes atributos:
 * precio, color, consumo energético (letras entre A y F) y peso.
 */
public class Electrodomestico {

    protected Double price;
    protected String colour;
    protected char consElec;
    protected Integer height;

    public Electrodomestico() {
    }

    public Double getPrice() {
        return price;
    }

    
    
    public Electrodomestico(Double price, String colour, char consElec, Integer height) {
        this.price = price;
        this.colour = colour;
        this.consElec = consElec;
        this.height = height;
    }

    //Método comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta,
    //sino es correcta usara la letra F por defecto. Este método se debe invocar al crear el
    //objeto y no será visible.
    public char comprobarConsumoEnergetico(char a) {
        a = Character.toUpperCase(a);
        if (a == 'A' || a == 'B' || a == 'C' || a == 'D' || a == 'E') {
            return this.consElec = a;
        } else {
            return this.consElec = 'f';
        }
    }

    //Método comprobarColor(String color): comprueba que el color es correcto, y si no lo es,
    //usa el color blanco por defecto. Los colores disponibles para los electrodomésticos son
    //blanco, negro, rojo, azul y gris. No importa si el nombre está en mayúsculas o en
    //minúsculas. Este método se invocará al crear el objeto y no será visible.
    public void comprobarColor(String color) {
        if (color.equalsIgnoreCase("NEGRO") || color.equalsIgnoreCase("ROJO")
                || color.equalsIgnoreCase("AZUL") || color.equalsIgnoreCase("GRIS")) {
            this.colour = color;
        } else {
            this.colour = "BLANCO";
        }
    }

    //Metodo crearElectrodomestico(): le pide la información al usuario y llena el
    //electrodoméstico, también llama los métodos para comprobar el color y el consumo. Al
    //precio se le da un valor base de $1000.
    public void crearElectrodomestico() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        this.price = 1000d;
        System.out.println("COLOR");
        comprobarColor(sc.next());
        System.out.println("TIPO DE CONSUMO (A-F)");
        comprobarConsumoEnergetico(sc.next().charAt(0));
        System.out.println("PESO");
        this.height = sc.nextInt();
    }

    //Método precioFinal(): según el consumo energético y su tamaño, aumentará el valor del
    //precio. Esta es la lista de precios:
    public Double precioFinal() {
        switch (this.consElec) {
            case 'A':
                this.price += 1000d;
                break;
            case 'B':
                this.price += 800d;
                break;
            case 'C':
                this.price += 600d;
                break;
            case 'D':
                this.price += 500d;
                break;
            case 'E':
                this.price += 300d;
                break;
            case 'F':
                this.price += 100d;
                break;
        }

        if (height < 20) {
            price += 100d;
        } else if (height >= 20 || height < 50) {
            price += 100d;
        } else if (height >= 50 || height < 80) {
            price += 100d;
        } else {
            price += 100d;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Electrodomesticos{" + "Price:$" + price + ", Colour:" + colour + ", Consumo:" + consElec + ", Height:" + height;
    }

}
