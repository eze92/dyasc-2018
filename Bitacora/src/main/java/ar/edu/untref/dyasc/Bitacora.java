package ar.edu.untref.dyasc;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bitacora {

    LocalDateTime fecha = LocalDateTime.now();

    public void registrarEvento(String unMensaje) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        String fechaConFormato = fecha.format(formatter);
        String destino = System.getProperty("bitacora.destino");
        if (destino == null) {
            System.out.println(unMensaje + ' ' + fechaConFormato);

        }
        else {
            grabarEvento(unMensaje, fecha.format(formatter), "bitacora");
        }
    }

    public void grabarEvento(String mensaje, String string, String archivo) {
        try {
            FileWriter escribir = new FileWriter(archivo);
            escribir.write(mensaje + ' ' + string );
            escribir.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}