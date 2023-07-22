package Entidades;

import java.util.Random;

/**
 *
 * @author tomyv
 * Crea una clase en Java donde declares una variable de tipo array de Strings
 * que contenga los doce meses del año, en minúsculas.
 * A continuación, declara una variable mesSecreto de tipo String,
 * y hazla igual a un elemento del array (por ejemplo, mesSecreto = mes[9].
 * 

 */
public class Calendario {
    Random r = new Random();
    private String anio [] = {"janeiro","fevereiro","março","abril","maio","junho","julho","agosto","outubro","novembro","dezembro"};
    private String mesSecreto = anio[r.nextInt(11)];

    public Calendario() {
    }    
    
    public String[] getAnio() {
        return anio;
    }

    public void setAnio(String[] anio) {
        this.anio = anio;
    }

    public String getMesSecreto() {
        return mesSecreto;
    }

    public void setMesSecreto(String mesSecreto) {
        this.mesSecreto = mesSecreto;
    }
    
    
}
