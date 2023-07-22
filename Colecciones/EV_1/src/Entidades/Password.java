package Entidades;

/**
 * 
 * @author tomyv
 */

//Haz una clase llamada Password que siga las siguientes condiciones:
public class Password {
    
    // Que tenga los atributos longitud y contraseña . 
    private int longitud;
    private String contraseña;

    public Password(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    //Un constructor por defecto.
    public Password() {
    }
    
    //Un constructor con la longitud que nosotros le pasemos. Generara una contraseña aleatoria con esa longitud.
    public Password(int longitud, String contraseña) {
        //Por defecto, la longitud sera de 8.
        this.longitud = 8;
        this.contraseña = "";
    }

    public Password(String substring) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Password{" + "longitud=" + longitud + ", contrase\u00f1a=" + contraseña + '}';
    }

    // Método set para longitud.
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    //Método get para contraseña y longitud.
    public String getContraseña() {
        return contraseña;
    }
    
     public int getLongitud() {
        return longitud;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
