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
public class DivisionNumero {

    public void test(String n1, String n2) {
        try {
            int num1 = Integer.parseInt(n1);
            int num2 = Integer.parseInt(n2);
            double res = (double) num1 / num2;
            System.out.println("EL EL RESULTADO ES " + res);
        }catch(ArithmeticException a){
            System.out.println(a.fillInStackTrace());
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }finally{
            System.out.println("BYE.............");
        }
    }

}
