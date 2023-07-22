package Entidades;

import java.util.ArrayList;

//Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y
//Revolver

public class Juego {

    private ArrayList<Jugador> player = new ArrayList();
    private Revolver pistol = new Revolver();

    public Juego() {
    }

    public ArrayList<Jugador> getPlayer() {
        return player;
    }

    public void setPlayer(ArrayList<Jugador> player) {
        this.player = player;
    }

    public Revolver getPistol() {
        return pistol;
    }

    public void setPistol(Revolver pistol) {
        this.pistol = pistol;
    }

    @Override
    public String toString() {
        return "Juego{" + "player=" + player + ", pistol=" + pistol + '}';
    }

    

}
