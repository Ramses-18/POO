/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author tomyv
 */
public class Extra_Hoteleros extends Alojamiento {
    
    protected Boolean type;
    protected Double metrosCuadrados;

    public Extra_Hoteleros() {
    }

    public Extra_Hoteleros(Boolean type, Double metrosCuadrados, String name, String direction, Integer numDirection, String localidad, Gerente gerent) {
        super(name, direction, numDirection, localidad, gerent);
        this.type = type;
        this.metrosCuadrados = metrosCuadrados;
    }

    @Override
    public String toString() {
        return super.toString() + "Extra_Hoteleros{" + "Type: " + type + ", Metros Cuadrados: " + metrosCuadrados + '}'; 
    }
    
    @Override
    public Alojamiento createAlojamiento() {
        super.createAlojamiento(); 
        System.out.println("TIPO DE ALOJAMIENTO");
        while (type == null) {
            System.out.println("1 - PUBLICO / 2 - PRIVADO");
            switch (sc.nextInt()) {
                case 1:
                    this.type = true;
                    break;
                case 2:
                    this.type = false;
                    break;
                default:
                    System.out.println("ERROR");
                    System.out.println("INTENTA DE NUEVO");
            }
        }
        System.out.println("METROS CUADRADOS");
        this.metrosCuadrados = sc.nextDouble();
        return new Extra_Hoteleros(type,metrosCuadrados,name,direction,numDirection,localidad,gerent);
    }
    
}
