package Service;

import Comparadores.Comparators;
import Entidades.Person;
import Entidades.Staff;
import Entidades.Student;
import Entidades.Teacher;
import static Enums.MaritalStatus.MARRIED;
import static Enums.MaritalStatus.SINGLE;
import static Enums.Sex.MEN;
import static Enums.Sex.WOMEN;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class University {

    private List<Person> people = new ArrayList();
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private Person p;
    private Boolean flagOpt = true;
    private Boolean flagRes = true;
    private Boolean flagEmp = true;
    private Boolean flagChan = true;
    private Boolean flagSee = true;

    public void options() {
        //List subject, Boolean pay, String completeName, Integer id,
        //MaritalStatus est, Integer age, Sex s, Long cellNum, String adress, Integer adressNum, String nationality
        people.add(new Student(null, true, "TOMAS LARA", 45612200, SINGLE, 19, MEN, 1125399048l, "LOPEZ BUCHARDO", 1476, "ARGENTINA"));
        people.add(new Student(null, true, "VALEN DARTES", 42212200, SINGLE, 20, WOMEN, 1125399048l, "JULIAN ALVAREZ", 16, "ARGENTINA"));
        while (flagOpt) {
            System.out.println("WHAT DO YOU WISH TO DO? ");
            System.out.println("1 - REGISTER ");
            System.out.println("2 - CHANGE DATA ");
            System.out.println("3 - SEE DATA ");
            System.out.println("4 - EXIT ");
            Integer opt = sc.nextInt();
            switch (opt) {
                case 1:
                    register();
                    break;
                case 2:
                    if (people.isEmpty()) {
                        System.out.println("NOTHING REGISTERED");
                    } else {
                        changeData();
                    }
                    break;
                case 3:
                    if (people.isEmpty()) {
                        System.out.println("NOTHING REGISTERED");
                    } else {
                        seeData();
                    }
                    break;
                case 4:
                    System.out.println("BYE.............. ");
                    flagOpt = false;
                    break;
                default:
                    System.out.println("INCORRECT ");
                    break;
            }
        }

    }

    public void register() {
        while (flagRes) {
            System.out.println("1 - STUDENT ");
            System.out.println("2 - EMPLOYEE ");
            System.out.println("3 - COME-BACK ");
            Integer opt = sc.nextInt();
            switch (opt) {
                case 1:
                    p = new Student();
                    people.add(p.createPerson());
                    System.out.println("ADDED!!!");
                    break;
                case 2:
                    createEmployee();
                    break;
                case 3:
                    System.out.println("COMING BACK.........");
                    flagRes = false;
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
        }

        if (flagRes == false) {
            options();
        }

    }

    public void createEmployee() {
        while (flagEmp) {
            System.out.println("1 - TEACHER ");
            System.out.println("2 - STAFF ");
            System.out.println("3 - RETURN ");
            switch (sc.nextInt()) {
                case 1:
                    p = new Teacher();
                    people.add(p.createPerson());
                    System.out.println("ADEDD!!");
                    break;
                case 2:
                    p = new Staff();
                    people.add(p.createPerson());
                    System.out.println("ADEDD!!");
                    break;
                case 3:
                    System.out.println("COMING BACK.........");
                    flagEmp = false;
                    break;
                default:
                    System.out.println("INCORRECT");
                    break;
            }
        }

        if (flagEmp == false) {
            register();
        }

    }

    public void changeData() {
        /**
         * @param args the command line arguments
         *
         * • Cambio del estado civil de una persona.
         *
         * • Reasignación de despacho a un empleado.
         *
         * • Matriculación de un estudiante en un nuevo curso.
         *
         * • Cambio de departamento de un profesor.
         *
         * • Traslado de sección de un empleado del personal de servicio.
         */


        while (flagChan) {

            System.out.println("WHAT'S THE NAME");
            String name = sc.next();

            for (Person aux : people) {

                if (name.equalsIgnoreCase(aux.getCompleteName())) {
                    System.out.println("WHAT DO YOU WISH TO CHANGE");
                    System.out.println("1 - NEW MARITAL STATUS");

                    if (aux instanceof Staff) {
                        System.out.println("2 - NEW SECCION");
                        System.out.println("3 - BE BACK");
                        Staff st = (Staff) aux;
                        switch (sc.nextInt()) {
                            case 1:
                                st.changeRelationship();
                                System.out.println("DONE IT");
                                break;
                            case 2:
                                st.changeOffice();
                                System.out.println("DONE IT");
                            case 3:
                                System.out.println("COMING BACK...........");
                                flagChan = false;
                                break;
                            default:
                                System.out.println("ERROR");
                        }
                    }

                    if (aux instanceof Teacher) {
                        System.out.println("2 - CHANGE OF DEANSHIP");
                        System.out.println("3 - BE BACK");
                        Teacher t = (Teacher) aux;
                        switch (sc.nextInt()) {
                            case 1:
                                t.changeRelationship();
                                System.out.println("DONE IT");
                                break;
                            case 2:
                                t.changeOffice();
                                System.out.println("DONE IT");
                            case 3:
                                System.out.println("COMING BACK...........");
                                flagChan = false;
                                break;
                            default:
                                System.out.println("ERROR");
                        }
                    }

                    if (aux instanceof Student) {
                        System.out.println("2 - NEW SUBJECT");
                        System.out.println("3 - BE BACK");
                        Student st = (Student) aux;
                        switch (sc.nextInt()) {
                            case 1:
                                st.changeRelationship();
                                System.out.println("DONE IT");
                                break;
                            case 2:
                                st.changeAssignature();
                                System.out.println("DONE IT");
                            case 3:
                                System.out.println("COMING BACK...........");
                                flagChan = false;
                                break;
                            default:
                                System.out.println("ERROR");
                        }
                    }

                }

            }

        }

        if (flagChan == false) {
            options();
        }

    }

    public void seeData() {
        Boolean check;
        while (flagSee) {
            System.out.println("WHAT DO YOU WISH?");
            System.out.println("1 - ORDEN BY NAME");
            System.out.println("2 - ORDEN BY AGE");
            System.out.println("3 - OBSERVE MEN");
            System.out.println("4 - OBSERVE WOMEN");
            System.out.println("5 - SEE STUDENTS");
            System.out.println("6 - SEE STAFF");
            System.out.println("7 - SEE TEACHERS");
            System.out.println("8 - RETURN");
            check = true;
            switch (sc.nextInt()) {
                case 1:
                    Collections.sort(people, Comparators.orderByName);
                    for (Person aux : people) {
                        System.out.println(aux);
                    }
                    break;
                case 2:
                    Collections.sort(people, Comparators.orderByDni);
                    for (Person aux : people) {
                        System.out.println(aux);
                    }
                    break;
                case 3:
                    for (Person aux : people) {
                        if (aux.getS() == MEN) {
                            System.out.println(aux);
                            check = false;
                        }
                    }

                    if (check) {
                        System.out.println("NO MEN REGISTERED");
                    }
                    break;
                case 4:
                    for (Person aux : people) {
                        if (aux.getS() == WOMEN) {
                            System.out.println(aux);
                            check = false;
                        }
                    }

                    if (check) {
                        System.out.println("NO WOMEN REGISTERED");
                    }
                    break;
                case 5:
                    for (Person aux : people) {
                        if (aux instanceof Student) {
                            System.out.println(aux);
                            check = false;
                        }
                    }

                    if (check) {
                        System.out.println("NO STUDENTS REGISTERED");
                    }
                    break;
                case 6:
                    for (Person aux : people) {
                        if (aux instanceof Staff) {
                            System.out.println(aux);
                            check = false;
                        }
                    }

                    if (check) {
                        System.out.println("NO STAFF REGISTERED");
                    }
                    break;
                case 7:
                    for (Person aux : people) {
                        if (aux instanceof Teacher) {
                            System.out.println(aux);
                            check = false;
                        }
                    }

                    if (check) {
                        System.out.println("NO TECHERS REGISTERED");
                    }

                    break;
                case 8:
                    options();
                    flagSee = false;
                    break;
                default:
                    System.out.println("ERROR");
            }
        }
    }
}
