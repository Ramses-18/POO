package Entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * •
 *
 */
//Realizar una baraja de cartas españolas orientada a objetos.
//Una carta tiene un número entre 1 y 12 (el 8 y el 9 no los incluimos) y un palo (espadas, bastos, oros y copas).
public class Carta {

    private Integer numero;
    private Palos palo;
    private ArrayList<Carta> mazo = new ArrayList();
    private ArrayList<Carta> descarte = new ArrayList();
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public Carta() {  
    }

    public Carta(Integer numero, Palos palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public void create() {
        mazo.clear();
        descarte.clear();
        for (Integer i = 1; i <= 12; i++) {
            if (i != 8 && i != 9) {
                for (Palos aux : Palos.values()) {
                    mazo.add(new Carta(i, aux));
                }
            }
        }
    }

    //• barajar(): cambia de posición todas las cartas aleatoriamente.
    public void barajar() {
        Collections.shuffle(mazo);
    }

    // siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando
    //no haya más o se haya llegado al final, se indica al usuario que no hay más cartas.
    public void siguienteCarta() {
        if (mazo.size() > 0) {
            System.out.println(mazo.get(0).numero + " DE " + mazo.get(0).palo);
            descarte.add(mazo.get(0));
            mazo.remove(0);
        } else {
            System.out.println("NO HAY NADA, MOSTRI");
        }

    }

    // • cartasDisponibles(): indica el número de cartas que aún se puede repartir.
    public void cartasDisponibles() {
        System.out.println("HAY " + mazo.size() + " CARTAS PARA REPARTIR");
    }

    //• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número de cartas.
    //En caso de que haya menos cartas que las pedidas, no devolveremos nada, pero debemos indicárselo al usuario.
    public void darCartas() {
        System.out.println("¿CUANTOS CARTAS QUERES DAR?");
        int n = sc.nextInt();
        if (n > mazo.size()) {
            System.out.println("NO HAY ESA CANTIDAD");
        } else {
            for (int i = 0; i < n; i++) {
                siguienteCarta();
            }
        }
    }

//  • cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna indicárselo al usuario.
    public void cartasMonton() {
        if (mazo.size() > 0 || descarte.size() > 1) {
            System.out.println("DESCARTASTE " + descarte.size() + " CARTAS");
        } else {
            System.out.println("NO HA SALIDO NINGUNA");
        }
    }

    // mostrarBaraja(): muestra todas las cartas hasta el final.
    //Es decir, si se saca una carta y luego se llama al método, 
    //este no mostrara esa primera carta.
    public void mostrar() {
        int cont = 1;
        for (Carta aux : mazo) {
            System.out.println("(" + cont + ") " + aux.numero + " DE " + aux.palo);
            cont++;
        }
        
        if(mazo.size() == 0 ){
            System.out.println("NO QUEDA NINGUNA CARTA EN EL MAZO");
        }
    }

    public void menu() {
        boolean flag = true;
        create();
        barajar();
        System.out.println("¿QUE HACEMOS CON LAS 40 CARTAS BARAJADAS?");
        do {
            System.out.println("1. REPARTIR LAS CARTAS");
            System.out.println("2. VER CANTIDAD DISPONIBLES");
            System.out.println("3. VER DESCARTADAS");
            System.out.println("4. MOSTRAR LAS CARTAS QUE QUEDAN");
            System.out.println("5. BARAJAR DE NUEVO");
            System.out.println("6. SALIR");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    darCartas();
                    break;
                case 2:
                    cartasDisponibles();
                    break;
                case 3:
                    cartasMonton();
                    break;
                case 4:
                    mostrar();
                    break;
                case 5:
                    create();
                    barajar();
                    break;
                case 6:
                    flag = false;
                    System.out.println("GRACIAS POR JUGAR!");
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");
            }
            System.out.println("---------------------------------------");
            System.out.println("¿AHORA?");
        } while (flag);

    }

}
