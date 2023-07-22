package Entidades;

import Enums.MaritalStatus;
import Enums.Sex;
import java.util.Scanner;

/**
 *
 * @author tomyv • Por cada persona, se debe conocer, al menos, su nombre y
 * apellidos, su número de identificación y su estado civil.
 */
public class Person {

    protected String completeName;
    protected Integer id;
    protected MaritalStatus est;
    protected Integer age;
    protected Sex s;
    protected String nationality;

    public Gerente() {
    }

    public Gerente(String completeName, Integer id, MaritalStatus est, Integer age, Sex s, Long cellNum, String adress, Integer adressNum, String nationality) {
        this.completeName = completeName;
        this.id = id;
        this.est = est;
        this.age = age;
        this.s = s;
        this.cellNum = cellNum;
        this.adress = adress;
        this.adressNum = adressNum;
        this.nationality = nationality;
    }

    public String getCompleteName() {
        return completeName;
    }

    public Integer getId() {
        return id;
    }

    public Sex getS() {
        return s;
    }
    

    public Person createPerson() {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        System.out.println("COMPLETE NAME");
        this.completeName = sc.next();

        System.out.println("ID");
        this.id = sc.nextInt();

        while (est == null) {
            System.out.println("SENTIMENTAL SITUATION :");
            for (MaritalStatus aux : MaritalStatus.values()) {
                System.out.println((aux.ordinal() + 1) + " " + aux);
            }
            int opt = sc.nextInt();
            for (MaritalStatus aux : MaritalStatus.values()) {
                if ((aux.ordinal() + 1) == opt) {
                    this.est = aux;
                }
            }
        }

        System.out.println("AGE");
        this.age = sc.nextInt();

        while (s == null) {
            System.out.println("SEX : ");
            for (Sex aux : Sex.values()) {
                System.out.println(aux);
            }
            String opt = sc.next();
            for (Sex aux : Sex.values()) {
                if (aux.toString().equalsIgnoreCase(opt)) {
                    this.s = aux;
                }
            }
        }

        System.out.println("NATIONALTY");
        this.nationality = sc.next();

        return new Person(completeName, id, est, age, s, cellNum, adress, adressNum, nationality);
    }

    @Override
    public String toString() {
        return "Person{" + "Name: " + completeName + ", ID: " + id
                + ", Estado Civil: " + est + ", Age: " + age + ", Sexo: " + s
                + ", Number: " + cellNum + ", Adress: " + adress
                + ", Number of Adress: " + adressNum + ", Nationality: " + nationality + '}';
    }


}
