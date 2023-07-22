/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Enums.MaritalStatus;
import Enums.Sections;
import Enums.Sex;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class Staff extends Employee {
    
    private Sections sec;

    public Staff() {
    }

    public Staff(Sections sec, Integer yearEnter, Integer office, String completeName, Integer id, MaritalStatus est, Integer age, Sex s, Long cellNum, String adress, Integer adressNum, String nationality) {
        super(yearEnter, office, completeName, id, est, age, s, cellNum, adress, adressNum, nationality);
        this.sec = sec;
    }

    @Override
    public Person createPerson() {
        super.createPerson();
        String sect;
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        while (sec == null) {
            System.out.println("SECTION");
            sect = sc.next().toUpperCase();
            for (Sections aux : Sections.values()) {
                if(aux.toString().equalsIgnoreCase(sect)){
                    this.sec = aux;
                }
            }
        }
        return new Staff(sec,yearEnter, office, completeName, id, est, age, s, cellNum, adress, adressNum, nationality);
    }
    
     @Override
    public String toString() {
        return super.toString()+ ", Section: " + sec;
    }

    //• Traslado de sección de un empleado del personal de servicio. 
    @Override
    public void changeOffice() {
        super.changeOffice();
        String sect;
        Integer c = 0; 
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        
        while (c == 0) {
            System.out.println("NEW SECTION");
            sect = sc.next().toUpperCase();
            for (Sections aux : Sections.values()) {
                if(aux.toString().equalsIgnoreCase(sect)){
                    this.sec = aux;
                    c++;
                }
            }
        }
        
    }
    
    
}
