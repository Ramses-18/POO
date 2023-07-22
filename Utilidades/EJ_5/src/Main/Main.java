package Main;

import Entidades.Persona;
import Service.PersonaService;

public class Main {
    
    public static void main(String[] args) {
        PersonaService ps = new PersonaService();
        Persona p = ps.crearPersona();
        
        if(ps.menorQue(p,18)){
            System.out.println( p.getName().toUpperCase() + " IS OLDER THAN 18 YEARS OLD");
        }else{
            System.out.println( p.getName().toUpperCase() + " IS YOUNGER THAN 18 YEARS OLD");
        }
        
        ps.mostrarPersona(p);
    }

}
