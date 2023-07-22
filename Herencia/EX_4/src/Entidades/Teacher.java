/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Enums.Deanships;
import Enums.MaritalStatus;
import Enums.Sex;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class Teacher extends Employee {

    private Deanships dep;

    public Teacher() {
    }

    public Teacher(Deanships dep, Integer yearEnter, Integer office,
            String completeName, Integer id, MaritalStatus est, Integer age,
            Sex s, Long cellNum, String adress, Integer adressNum, String nationality) {
        super(yearEnter, office, completeName, id, est, age, s, cellNum, adress, adressNum, nationality);
        this.dep = dep;
    }

    @Override
    public String toString() {
        return super.toString() + ", Deanships : " + dep;
    }

    @Override
    public Person createPerson() {
        super.createPerson();
        String dean;
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        while (dep == null) {
            System.out.println("DEANSHIP");
            dean = sc.next().toUpperCase();
            for (Deanships aux : Deanships.values()) {
                if (aux.toString().equalsIgnoreCase(dean)) {
                    this.dep = aux;
                }
            }
        }

        return new Teacher(dep, yearEnter, office, completeName, id, est, age, s, cellNum, adress, adressNum, nationality);
    }

    // • Cambio de departamento de un profesor. 
    @Override
    public void changeOffice() {
        super.changeOffice();
        String dean;
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        Integer c = 0;
        while (c == 0) {
            System.out.println("DEANSHIP");
            dean = sc.next().toUpperCase();
            for (Deanships aux : Deanships.values()) {
                if (aux.toString().equalsIgnoreCase(dean)) {
                    this.dep = aux;
                    c++;
                }
            }
        }
    }

}
