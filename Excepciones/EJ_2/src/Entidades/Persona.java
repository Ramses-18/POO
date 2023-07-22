/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author tomyv
 */
public class Persona {

    private String name;
    private int edad;
    private int[] v ;

    public Persona() {
    }

    public Persona(String name, int edad, int[] v) {
        this.name = name;
        this.edad = edad;
        this.v = new int [3];
    }

    public void test(int indice, int valor){
        try{
            v[indice] = valor;
        }catch(ArrayIndexOutOfBoundsException a){
            System.out.println("Error : " + a.fillInStackTrace());
        }finally{
            System.out.println("Se ha verificado el indice");
        }
    }
    
    @Override
    public String toString() {
        return "Persona{" + "name=" + name + ", edad=" + edad + ", v=" + v + '}';
    }
    
    
}
