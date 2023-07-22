package Service;

import Entidades.Password;
import java.util.Random;
import java.util.Scanner;

public class PasswordService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private Password p = new Password();

    //Los métodos que implementa serán: esFuerte(): devuelve un booleano si es fuerte o no, para que sea fuerte debe tener mas de
    //2 mayúsculas, mas de 1 minúscula y mas de 5 números.
    public boolean esFuerte() {
        int may = 0;
        int min = 0;
        int num = 0;
        System.out.println("Ingresa la contraseña");
        p.setContraseña(sc.next());
        for (int i = 0; i < p.getContraseña().length(); i++) {
            if (Character.isUpperCase(i)) {
                may++;
            } else if (Character.isLowerCase(i)) {
                min++;
            } else if (Character.isDigit(i)) {
                num++;
            }
        }

        if (may > 2 && min > 2 && num > 5) {
            return true;
        }else{
            return false;
        }
    }
    
  /* 
  Crea un array de Passwords con el tamaño que tu le indiques por teclado. Crea
  un bucle que cree un objeto para cada posición del array. Indica también por
  teclado la longitud de los Passwords (antes de bucle). Crea otro array de
  booleanos donde se almacene si el password del array de Password es o no
  fuerte (usa el bucle anterior). Al final, muestra la contraseña y si es o no
  fuerte (usa el bucle anterior). Usa este simple formato: 
  contraseña1 valor_booleano1
  contraseña2 valor_bololeano2
  */
    
    public void generarPassword(){
        Random r = new Random();
        System.out.println("¿De que largo queres tu password?");
        int l = sc.nextInt();
        String pass [] = new String [l];
        for (int i = 0; i < p.getContraseña().length(); i++) {
            pass[i] = new Password(p.getContraseña().charAt(i));
        }
    }
    
}
