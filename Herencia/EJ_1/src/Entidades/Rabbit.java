/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Enum.Size;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class Rabbit extends Animal {
    
    private Integer sizeTeeth;

    public Rabbit() {
    }

    public Rabbit(Integer sizeTeeth, String name, Integer age, String type, String colour, Size siz) {
        super(name, age, type, colour, siz);
        this.sizeTeeth = sizeTeeth;
    }

    @Override
    public Animal createAnimal() {
        super.createAnimal(); 
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("SCALE OF SIZE'S TEETH");
        this.sizeTeeth = sc.nextInt();
        return new Rabbit(sizeTeeth,name,age,type,colour, siz);
    }

    @Override
    public String toString() {
        return super.toString() + " SIZE OF THE TEETH " + sizeTeeth; 
    }
    
    

}
