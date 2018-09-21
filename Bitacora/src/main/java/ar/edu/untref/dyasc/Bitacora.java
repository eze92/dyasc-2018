package ar.edu.untref.dyasc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Bitacora {

    private GeneradorSalida creadorDeSalidas;

    public Bitacora() {
        this.creadorDeSalidas = new GeneradorSalida();
    }

    public void registrarEvento(String mensaje) {
        try {
            String mensajeDeSalida = this.formateadorDeMensaje(mensaje);
            String configuracionDeSalida = System.getProperty("bitacora.destino");
            List<Salida> salidasEvento = this.parsearEntrada(configuracionDeSalida);
            Iterator<Salida> iterador = salidasEvento.iterator();
            while (iterador.hasNext()) {
                Salida salida = iterador.next();
                salida.mostrar(mensajeDeSalida);
            }
        } catch (NullPointerException e) {
            System.out.println("Variable de entorno no encontrada");
        }

    }

    private List<Salida> parsearEntrada(String parametros) {
        StringTokenizer token = new StringTokenizer(parametros, ",");
        List<Salida> unaSalida = new ArrayList<>();
        while (token.hasMoreTokens()) {
            String parametroDeSalida = token.nextToken();
            unaSalida.add(creadorDeSalidas.generar(parametroDeSalida));
        }
        return unaSalida;
    }

    private String formateadorDeMensaje(String unMensaje) {
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fechaConFormato = fecha.format(formatter);
        String mensajeDeSalida = fechaConFormato + " " + unMensaje;
        return mensajeDeSalida;
    }
}

// }