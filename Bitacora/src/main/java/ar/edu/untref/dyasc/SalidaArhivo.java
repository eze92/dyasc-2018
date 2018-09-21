package ar.edu.untref.dyasc;

import java.io.FileWriter;
import java.io.IOException;

public class SalidaArhivo implements Salida {

    private String archivoSalida;

    public SalidaArhivo(String archivo) {
        this.archivoSalida = archivo;
    }

    public void mostrar(String unMensaje) {
        try {
            FileWriter escribe = new FileWriter(this.archivoSalida, true);
            escribe.write(unMensaje + "\n");
            escribe.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}