/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author tomyv
 *
 * Un Barco se caracteriza por: su matrícula, su eslora en metros y año de
 * fabricación.
 */
public class Barco {

    protected String matricula;
    protected Double eslora;
    protected Integer anioFabric;

    public Barco() {
        crearBarco();
    }

    public Barco(String matricula, Double eslora, Integer anioFabric) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabric = anioFabric;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getEslora() {
        return eslora;
    }

    public void setEslora(Double eslora) {
        this.eslora = eslora;
    }

    public Integer getAnioFabric() {
        return anioFabric;
    }

    public void setAnioFabric(Integer anioFabric) {
        this.anioFabric = anioFabric;
    }
    
    public Barco crearBarco(){
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Matricula");
        this.matricula = read.next();
        System.out.println("Eslora de la embarcacion");
        this.eslora = read.nextDouble();
        System.out.println("Año de fabricacion");
        this.anioFabric = read.nextInt();
        return new Barco(matricula,eslora,anioFabric);
    }

    @Override
    public String toString() {
        return "Barco{" + " Matricula: " + matricula + ", Eslora: " + eslora + ", Fabricacion: " + anioFabric + '}';
    }
    
    
    
}
