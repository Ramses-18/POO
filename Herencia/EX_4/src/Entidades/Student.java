/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Enums.MaritalStatus;
import Enums.Sex;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tomyv • En cuanto a los estudiantes, se requiere almacenar el curso
 * en el que están matriculados.
 */
public class Student extends Person {

    private List subject;
    private Boolean pay;

    public Student() {
        this.subject = new ArrayList();
    }

    public Student(List subject, Boolean pay, String completeName, Integer id,
            MaritalStatus est, Integer age, Sex s, Long cellNum, String adress, Integer adressNum, String nationality) {
        super(completeName, id, est, age, s, cellNum, adress, adressNum, nationality);
        this.subject = subject;
        this.pay = pay;
    }

    @Override
    public Person createPerson() {
        super.createPerson();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        System.out.println("ASIGNATURE");
        String newAsig = sc.next();
        this.subject.add(newAsig);

        while (pay == null) {
            System.out.println("TO DAY (Y/N) ");
            String opt = sc.next();
            if ("Y".equalsIgnoreCase(opt)) {
                this.pay = true;
            } else if ("N".equalsIgnoreCase(opt)) {
                this.pay = false;
            }
        }

        return new Student(subject, pay, completeName, id, est, age, s, cellNum, adress, adressNum, nationality);
    }

    @Override
    public String toString() {
        return super.toString() + ", Subjects: " + subject + ", Pay: " +  pay; 
       
    }

    public List changeAssignature() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("NEW SUBJECT :");
        subject.add(sc.next());
        return subject;
    }

}
