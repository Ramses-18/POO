package Entidades;

//Crear una clase Ahorcado (como el juego).
public class Ahorcado {
    //la cual deberá contener como atributos, un vector con la palabra a buscar, la
    //cantidad de letras encontradas y la cantidad jugadas máximas que puede realizar el usuario.

    private String search[];
    private int canl = 0;
    private int jmax;

    public Ahorcado(String[] search, int canl, int jmax) {
        this.search = search;
        this.canl = canl;
        this.jmax = jmax;
    }

    public Ahorcado() {
    }

    public String[] getSearch() {
        return search;
    }

    public void setSearch(String[] search) {
        this.search = search;
    }

    public int getCanl() {
        return canl;
    }

    public void setCanl(int siuu) {
        this.canl = canl + siuu;
    }

    public int getJmax() {
        return jmax;
    }

    public void setJmax(int jmax) {
        this.jmax = jmax;
    }

}
