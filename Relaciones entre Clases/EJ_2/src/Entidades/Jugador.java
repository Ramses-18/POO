package Entidades;

/*
   Clase Jugador : esta clase posee los siguientes atributos: id (representa el número del
   jugador), nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo) y mojado (indica
   si está mojado o no el jugador). El número de jugadores será decidido por el usuario, pero
   debe ser entre 1 y 6. Si no está en este rango, por defecto será 6.
*/
public class Jugador {
    
    private Integer id;
    private String name;
    private boolean mojado;

    public Jugador() {
        
    }
    
    public Jugador(Integer id, String name, boolean mojado) {
        this.id = id;
        this.name = name;
        this.mojado = mojado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getMojado() {
        return mojado;
    }

    public void setMojado(boolean mojado) {
        this.mojado = mojado;
    }

    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", name=" + name + ", mojado=" + mojado + '}';
    }
    
    
    
}
