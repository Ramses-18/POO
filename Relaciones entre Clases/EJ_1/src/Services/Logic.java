/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entidades.Perro;
import Entidades.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class Logic {

    public void all() {
        ArrayList<Persona> listP = new ArrayList();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        do {
            System.out.println("Name");
            String n = sc.next();
            System.out.println("Surname");
            String sur = sc.next();
            System.out.println("Age");
            Integer i = sc.nextInt();
            System.out.println("Dni");
            Integer dni = sc.nextInt();
            System.out.println("¿Do you want adopt a dog?(Y/N)");
            if (sc.next().equalsIgnoreCase("y")) {
                System.out.println("DOG");
                System.out.println("Name");
                String nd = sc.next();
                System.out.println("Raza");
                String raza = sc.next();
                System.out.println("Age");
                Integer age = sc.nextInt();
                System.out.println("Size");
                String a = sc.next();
                listP.add(new Persona(n, sur, i, dni, new Perro(nd, raza, age, a)));
            }else{
                listP.add(new Persona(n, sur, i, dni));
            }
            System.out.println("Other??");
        } while ("S".equalsIgnoreCase(sc.next()));
        mostrar(listP);
    }

    public void mostrar(ArrayList arl) {
        for (Object aux : arl) {
            System.out.println(aux);
        }
        System.out.println("-------------------------------------------------------------");
    }
}
