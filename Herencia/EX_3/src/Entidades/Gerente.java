/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Enums.Sex;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class Gerente {
    
    private String completeName;
    private Integer id;
    private Integer age;
    private Sex s;
    private String nationality;

    public Gerente() {
    }

    public Gerente(String completeName, Integer id, Integer age, Sex s, String nationality) {
        this.completeName = completeName;
        this.id = id;
        this.age = age;
        this.s = s;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Gerente{" + "Name: " + completeName + ", Id: " + id + ", Age:" + age +
                ", Sex: " + s + ", Nationality: " + nationality + '}';
    }
    
    public Gerente createGerente(){
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("NOMBRE DEL GERENTE");
        completeName = sc.next();
        System.out.println("DNI");
        id = sc.nextInt();
        System.out.println("EDAD");
        age = sc.nextInt();
        while (s == null) {
            System.out.println("SEXO (H/M/O)");
            String ans = sc.next();
            for (Sex aux : Sex.values()) {
                if(ans.equalsIgnoreCase(ans)){
                    this.s = aux;
                }
            }
        }
        System.out.println("NACIONALIDAD");
        nationality = sc.next();
        return new Gerente(completeName,id,age,s,nationality);
    }
    
}
