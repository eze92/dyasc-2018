package ar.edu.untref.dyasc;

public class GeneradorSalida {

    public Salida generar(String unaSalida) {
        if (unaSalida.equals("CONSOLA")) {
            return new SalidaPantalla();
        } else {
            return new SalidaArhivo(unaSalida);
        }
    }

}
