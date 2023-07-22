package Entidades;

import java.util.Date;


public class Persona {
    
    //Implemente la clase Persona en el paquete entidades. Una persona tiene un nombre y
    //una fecha de nacimiento (Tipo Date), constructor vacío, constructor parametrizado, get y set.
    private String name;
    private Date nac;

    public Persona(String name, Date nac) {
        this.name = name;
        this.nac = nac;
    }

    public Persona() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNac() {
        return nac;
    }

    public void setNac(Date nac) {
        this.nac = nac;
    }

    @Override
    public String toString() {
        return "Persona " + "nac =" + nac + '}';
    }
    
    
}
