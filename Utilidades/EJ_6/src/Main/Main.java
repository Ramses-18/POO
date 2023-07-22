package Main;

import Entidades.Curso;
import Services.CursoService;

public class Main {

    public static void main(String[] args) {
        CursoService cs = new CursoService();
        Curso c = cs.crearCurso();
        System.out.println("You are earning $" + cs.calcularGananciaSemanal(c) + " per week");
    }

}
