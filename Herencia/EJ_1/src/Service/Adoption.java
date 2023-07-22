/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entidades.Animal;
import Entidades.Cat;
import Entidades.Dog;
import Entidades.Fish;
import Entidades.Parrot;
import Entidades.Rabbit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class Adoption {

    public void menu() {
        Boolean flag = true;
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        Animal a ;
        List<Animal> aList = new ArrayList();
        do {
            //WE SHOW ALL THE POSSIBLE ANIMALS AVAILABLE.
            System.out.println("¿WHAT ANIMAL ARE YOU INTERESTED ON ENTER ON THE SYSTEM?");
            System.out.println(" 1 - CAT ");
            System.out.println(" 2 - DOG ");
            System.out.println(" 3 - PARROT ");
            System.out.println(" 4 - RABBIT ");
            System.out.println(" 5 - FISH ");
            System.out.println(" 6 - EXIT ");
            Integer option = sc.nextInt();
            switch (option) {
                case 1:
                    a = new Cat();
                    aList.add(a.createAnimal());
                    break;
                case 2:
                    a = new Dog();
                    aList.add(a.createAnimal());
                    break;
                case 3:
                    a = new Parrot();
                    aList.add(a.createAnimal());
                    break;
                case 4:
                    a = new Rabbit();
                    aList.add(a.createAnimal());
                    break;
                case 5:
                    a = new Fish();
                    aList.add(a.createAnimal());
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("INCORRECT");
                    System.out.println("TRY AGAIN");
                    break;
            }
        } while (flag);
        System.out.println(aList.toString());
    }
}
