/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entidades.Alquiler;
import Entidades.Barco;
import Entidades.Lancha;
import Entidades.Velero;
import Entidades.Yate;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class Puerto {

    public void menu() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        Double total = 0d;
        Double suma = 0d;
        int flag = 0;
        do {
            System.out.println("¿Que tipo de embarcacion posee?");
            System.out.println("1 - Lancha ");
            System.out.println("2 - Yate");
            System.out.println("3 - Velero");
            System.out.println("4 - Otro");
            System.out.println("5 - Salir");
            int opc = sc.nextInt();
            Alquiler al = new Alquiler();
            al.crearAlquiler();
            switch (opc) {
                case 1:
                    Lancha lan = new Lancha();
                    al.setBar(lan.crearLancha());
                    suma = (al.getDiff() * lan.getEslora() * 10) + lan.getPotencia();
                    System.out.println("El Alquiler de la Lancha es de $" + suma);
                    break;
                case 2:
                    Yate yat = new Yate();
                    al.setBar(yat.crearYate());
                    suma = (al.getDiff() * yat.getEslora() * 10) + yat.getCamarotes() + yat.getPotencia();
                    System.out.println("El Alquiler del Yate es de $" + suma);
                    break;
                case 3:
                    Velero vel = new Velero();
                    al.setBar(vel.crearVelero());
                    suma = (al.getDiff() * vel.getEslora() * 10) + vel.getMastiles();
                    System.out.println("El Alquiler de el Velero es de $" + suma);
                    break;
                case 4:                          
                    al.setBar(new Barco());
                    suma = al.getDiff() * al.getBar().getEslora() * 10;
                    System.out.println("El Alquiler de su Barco es de $" + suma);
                    break;
                case 5:
                    System.out.println("Saliendo.........");
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;
            }
            total = total + suma;
            flag = flag + 1;     
            System.out.println(al.toString());
            System.out.println("¿Posee otra embarcacion? (S/N)");
        } while ("s".equalsIgnoreCase(sc.next()));

        if (flag >= 2) {
            System.out.println("El total de sus embarcaciones es de " + total);
        }
    }

}
