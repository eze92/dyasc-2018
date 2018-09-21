package ar.edu.untref.dyasc;

public class GeneradorSalida {

    public Salida generar(String salida) {
        if (salida.equals("CONSOLA")) {
            return new SalidaPantalla();
        } else {
            return new SalidaArhivo(salida);
        }
    }

}
