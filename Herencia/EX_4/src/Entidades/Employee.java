package Entidades;

import Enums.MaritalStatus;
import Enums.Sex;
import Service.University;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class Employee extends Person {

    protected Integer yearEnter;
    protected Integer office;

    public Employee() {
    }

    public Employee(Integer yearEnter, Integer office, String completeName, Integer id, MaritalStatus est, Integer age,
            Sex s, Long cellNum, String adress, Integer adressNum, String nationality) {
        super(completeName, id, est, age, s, cellNum, adress, adressNum, nationality);
        this.yearEnter = yearEnter;
        this.office = office;
    }

    @Override
    public Person createPerson() {
        super.createPerson();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("YEAR OF ENTRANCE");
        this.yearEnter = sc.nextInt();
        System.out.println("OFFICE");
        this.office = sc.nextInt();
        return new Employee(yearEnter, office, completeName, id, est, age, s, cellNum, adress, adressNum, nationality);
    }

    @Override
    public String toString() {
        return super.toString() + ", Year Entrance : " + yearEnter + ", Office : " + office;
    }

    // • Reasignación de despacho a un empleado.
    public void changeOffice() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("NEW NUMBER OF OFFICE");
        office = sc.nextInt();
    }
}
