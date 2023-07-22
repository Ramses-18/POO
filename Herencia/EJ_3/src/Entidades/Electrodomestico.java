/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Electrodomestico {
    
    protected Double precio;
    protected String color;
    protected char consumo;
    protected Double peso;

    public Electrodomestico() {
    }

    public Electrodomestico(Double precio, String color, char consumo, Double peso) {
        this.precio = precio;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumo() {
        return consumo;
    }

    public void setConsumo(char consumo) {
        this.consumo = consumo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
    
//    Método comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta,
//sino es correcta usara la letra F por defecto. Este método se debe invocar al crear el
//objeto y no será visible.
    
    public void consumoEnergetico(char a){
        
        if (a == 'a' || a == 'b' || a == 'c' || a == 'd' || a == 'e' || a == 'A' || a == 'B' || a == 'C' || a == 'D' || a == 'E'  ) {
            
            this.consumo = a;
            
        }else{
        
            this.consumo = 'F';
            
        }
           
       }
    
//    Método comprobarColor(String color): comprueba que el color es correcto, y si no lo es,
//usa el color blanco por defecto. Los colores disponibles para los electrodomésticos son
//blanco, negro, rojo, azul y gris. No importa si el nombre está en mayúsculas o en
//minúsculas. Este método se invocará al crear el objeto y no será visible.
    
    public void comprobarColor(String color){
    
        if (color.equalsIgnoreCase("negro") || color.equalsIgnoreCase("rojo") || color.equalsIgnoreCase("azul") || color.equalsIgnoreCase("gris") ) {
            
            this.color = color;
            
        }else{
            
            this.color = "blanco";
        
        }
        
    }
    
//    Metodo crearElectrodomestico(): le pide la información al usuario y llena el
//electrodoméstico, también llama los métodos para comprobar el color y el consumo. Al
//precio se le da un valor base de $1000.
    
    public void crearElectrodomestico(){
    
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Color ?");
        comprobarColor(read.next());
        
        System.out.println("Que clase de consumo electrico tiene? A / B / C / D / E / F");
        consumoEnergetico(read.next().charAt(0));
        
        System.out.println("Cual es su peso en kg ?");
        this.peso = read.nextDouble();
    
        precioFinal();
        
        System.out.println();
    }
    
//    Método precioFinal(): según el consumo energético y su tamaño, aumentará el valor del
//precio. Esta es la lista de precios:
    
    public void precioFinal(){
        
         this.precio = 1000d;
         
        switch(this.consumo){
            
            case 'a' : this.precio += 1000d;
            break;
            
            case 'b' : this.precio += 800d;
            break;
            
            case'c' : this.precio += 600d;
            break;
            
            case 'd' : this.precio += 500d;
            break;
            
            case 'e' : this.precio += 300d;
            break;
            
            case 'f' : this.precio += 100d;
            break;
            
            case 'A' : this.precio += 1000d;
            break;
            
            case 'B' : this.precio += 800d;
            break;
            
            case 'C' : this.precio += 600;
            break;
            
            case 'D' : this.precio += 500d;
            break;
            
            case 'E' : this.precio += 300d;
            break;
            
            case 'F' : this.precio += 100d;
            break;
            
        }
        
        if (peso < 20 ) {
            this.precio += 100d;
        }else if(peso >= 20 && peso < 50){
            this.precio += 500d;
        }else if(peso >= 50 && peso < 80){
            this.precio += 800d;
        }else if(peso >= 80){
            this.precio += 1000d;
        }
        
        
    
    
    
    }

   
    
    
    
    
    
    }
    
    
    
    
    

