package Main;

import Service.RazasService;
import java.util.ArrayList;

public class EJ_1_EJ_2 {

    /**
     * @param args the command line arguments 
     * /////////////////////////////////////////////////////////////////////////
     * 
     */
    public static void main(String[] args) {
        RazasService rs = new RazasService();
        ArrayList<String> als = rs.crearRazas();
        rs.search(als);
    }

}
