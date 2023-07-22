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
 */
public class Lancha extends Barco {
    
    protected Integer potencia;

    public Lancha() {
        
    }

    public Lancha(Integer potencia, String matricula, Double eslora, Integer anioFabric) {
        super(matricula, eslora, anioFabric);
        this.potencia = potencia;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }
    
    public Lancha crearLancha(){
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Potencia de la lancha");
        this.potencia = read.nextInt();  
        return new Lancha(potencia,matricula,eslora,anioFabric);
    }

    @Override
    public String toString() {
        return "Lancha{" + " Potencia: " + potencia + '}';
    }
    
    
    
    
    
}
