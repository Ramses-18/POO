/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tomyv
 *
 * el nombre, documento del cliente, la fecha de alquiler, fecha de devolución,
 * la posición del amarre y el barco que lo ocupará.
 */
public class Alquiler {

    private String name;
    private LocalDate fechaAlq;
    private LocalDate fechaDev;
    private int pos;
    private int diff;
    private Barco bar;
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public Alquiler() {
    }

    public Alquiler(String name, LocalDate fechaAlq, LocalDate fechaDev, int pos) {
        this.name = name;
        this.fechaAlq = fechaAlq;
        this.fechaDev = fechaDev;
        Random r = new Random();
        this.pos = r.nextInt(30);
    }

    public Alquiler(String name, LocalDate fechaAlq, LocalDate fechaDev, int pos, int diff, Barco bar) {
        this.name = name;
        this.fechaAlq = fechaAlq;
        this.fechaDev = fechaDev;
        Random r = new Random();
        this.pos = r.nextInt(30);
        this.diff = diff;
        this.bar = bar;
    }

    public Barco getBar() {
        return bar;
    }

    public void setBar(Barco bar) {
        this.bar = bar;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.bar);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alquiler other = (Alquiler) obj;
        if (!Objects.equals(this.bar, other.bar)) {
            return false;
        }
        return true;
    }

    public Alquiler crearAlquiler() {
        System.out.println("Nombre de Cliente");
        this.name = sc.next();
        LocalDate ld = LocalDate.now();
        this.fechaAlq = ld;
        System.out.println("Dias de alquiler");
        diff = sc.nextInt();
        this.fechaDev = ld.plusDays(diff);
        return new Alquiler(name, fechaAlq, fechaDev, pos);
    }

    @Override
    public String toString() {
        return "Alquiler{" + " Name: " + name + ", Fecha_Alquiler: " + fechaAlq
                + ", Fecha_Devolucion: " + fechaDev + ", Posicion: " + pos + ", Barco: " + bar + '}';
    }

}
