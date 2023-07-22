package Service;

import Entidades.Calendario;
import java.util.Date;
import java.util.Scanner;

/**
 * Crea una clase en Java donde declares una variable de tipo array de Strings
 * que contenga los doce meses del año, en minúsculas. A continuación, declara
 * una variable mesSecreto de tipo String, y hazla igual a un elemento del array
 * (por ejemplo, mesSecreto = mes[9]. El programa debe pedir al usuario que
 * adivine el mes secreto. Si el usuario acierta mostrar un mensaje, y si no lo
 * hace, pedir que vuelva a intentar adivinar el mes secreto. Un ejemplo de
 * ejecución del programa podría ser este: Adivine el mes secreto. Introduzca el
 * nombre del mes en minúsculas: febrero No ha acertado. Intente adivinarlo
 * introduciendo otro mes: agosto ¡Ha acertado!
 *
 */
public class CalendarioService {

    Calendario c = new Calendario();
    Date d = new Date();
    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void Secret() {
        System.out.println("Adivinhe o mês secreto! Você tem 5 oportunidades.");
        int cont = 5;
        String ans;
        do {
            ans = sc.next().toLowerCase();
            cont--;
            if (c.getMesSecreto().equals(ans)) {
                System.out.println("Perfeito, você é um gênio do caralho");
                break;
            } else if (cont == 0) {
                System.out.println("fim de jogo o mês secreto foi " + (c.getMesSecreto()));
                break;
            } else if (cont != 0) {
                System.out.println("Não, você ainda tem " + cont + " oportunidades");
            }
        } while (cont > 0 || c.getMesSecreto().equals(ans));

    }
}
