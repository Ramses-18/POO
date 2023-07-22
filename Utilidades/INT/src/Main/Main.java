package Main;

import Service.StudentService;

public class Main {

    public static void main(String[] args) {
        StudentService s = new StudentService();
        s.datear();
        System.out.println("THE NOTE`S MEDIA IS " + s.calculate());
        s.over();
        s.print();
    }

}