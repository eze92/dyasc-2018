package ar.edu.untref.dyasc;


public class Ejemplo {

    public static void main (String [] args ) {
        Bitacora unaBitacora = new Bitacora();
        unaBitacora.registrarEvento("Inicio Secion");
        unaBitacora.registrarEvento("Cierro Secion");
    }   
}