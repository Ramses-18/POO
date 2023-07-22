package Entidades;

import java.util.ArrayList;


public class Alumno {
    //Crear una clase llamada Alumno que mantenga información sobre las notas de distintos alumnos.
    //La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer con sus 3 notas.
    private String name;
    private ArrayList<Integer> note;

    
    public Alumno() {
        this.note = new ArrayList();
    }
    
    @Override
    public String toString() {
        return "Alumno{" + "name=" + name + ", note=" + note + '}';
    }
    
    public Alumno(String name, ArrayList<Integer> note) {
        this.name = name;
        this.note = note;
    }

    public void setNote(ArrayList<Integer> note) {
        this.note = note;
    }

    public ArrayList<Integer> getNote() {
        return note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    
    
    
}
