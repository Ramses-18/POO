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
public class Fish extends Animal {

    private String typeOfShape;

    public Fish() {
    }

    public Fish(String typeOfShape, String name, Integer age, String type, String colour, Size siz) {
        super(name, age, type, colour, siz);
        this.typeOfShape = typeOfShape;
    }

    @Override
    public Animal createAnimal() {
        super.createAnimal();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("STYLE OF SHAPE");
        this.typeOfShape = sc.next();
        return new Fish(typeOfShape, name, age, type, colour, siz);
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Type Of Shape " + typeOfShape ;
    }
    
    

}
