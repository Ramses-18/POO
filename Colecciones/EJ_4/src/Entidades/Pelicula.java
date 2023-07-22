package Entidades;

public class Pelicula {
    //Un cine necesita implementar un sistema en el que se puedan cargar peliculas.
    //Para esto, tendremos una clase Pelicula con el título, director y duración de la película (en horas).
    private String title;
    private String direct;
    private Double time;

    public Pelicula() {
    }

    public Pelicula(String title, String direct, double time) {
        this.title = title;
        this.direct = direct;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "title=" + title + ", direct=" + direct + ", time=" + time + '}';
    }
    
    
}
