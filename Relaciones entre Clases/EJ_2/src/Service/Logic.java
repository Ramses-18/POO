/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entidades.Juego;
import Entidades.Jugador;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class Logic {

    private Juego game = new Juego();
    private Jugador player = new Jugador();

    // • llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores deben ser aleatorios.
    public void llenarRevolver() {
        Random rand = new Random();
        game.getPistol().setPosTambor(rand.nextInt(6) + 1);
        game.getPistol().setPosAgua(rand.nextInt(6) + 1);
        //System.out.println("TAM = " + game.getPistol().getPosTambor() + " AGUA = " + game.getPistol().getPosAgua());
    }

    // • mojar(): devuelve true si la posición del agua coincide con la posición actual.
    public boolean mojar() {
        return game.getPistol().getPosAgua().equals(game.getPistol().getPosTambor());
    }

    // • siguienteChorro(): cambia a la siguiente posición del tambor.
    public void siguienteChorro() {
        game.getPistol().setPosAgua(game.getPistol().getPosAgua() + 1);
        if (game.getPistol().getPosAgua().equals(7)) {
            game.getPistol().setPosAgua(1);
        }
    }

    // • toString(): muestra información del revolver (posición actual y donde está el agua).
    public void tooString() {
        System.out.println(game.getPistol().toString());
    }

    // • disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de
    //mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
    //revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
    //devuelve true, sino false. sssssssssssiii
    public boolean disparo() {
        if (mojar()) {
            player.setMojado(true);
            System.out.println("GAME OVER, MY FRIEND");
            return true;
        } else {
            siguienteChorro();
            return false;
        }
    }

    // • llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
    // y el revolver para guardarlos en los atributos del juego.
    public void llenarJuego() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        Integer c = 1;

        System.out.println("HOW MANY PLAYERS?");
        System.out.println("BETWEEN 1 TO 6");
        Integer number = sc.nextInt();

        if (number < 1 || number > 6) {
            System.out.println("THERE WILL BE 6 PEOPLE");
            number = 6;
        }

        do {
            System.out.println("NAME " + c);
            game.getPlayer().add(new Jugador(c, sc.next(), false));
            c++;
        } while (c <= number);

        if (c >= 1) {
            llenarRevolver();
        }

    }

    //• ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
    //aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
    //moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
    //mojar. Al final del juego, se debe mostrar que jugador se mojó.
    //Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
    public void ronda() {
        llenarJuego();

        Boolean flag = true;
        while (flag) {
            for (Jugador aux : game.getPlayer()) {
                if (disparo()) {
                    flag = false;
                    System.out.println(aux.getName().toUpperCase() + " HAS DIED");
                    break;
                } else {
                    System.out.println(aux.getName().toUpperCase() + " IS ALIVE");
                }

            }
        }

    }

}
