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

    public void registrarEvento(String unMensaje) {
        try {
            String mensaje = this.formatoMensaje(unMensaje);
            String config = System.getProperty("bitacora.destino");
            List<Salida> salidaL = this.recorrerValor(config);
            Iterator<Salida> iterador = salidaL.iterator();
            while (iterador.hasNext()) {
                Salida salida = iterador.next();
                salida.mostrar(mensaje);
            }
        } catch (NullPointerException e) {
            System.out.println("Variable de entorno no encontrada");
        }

    }

    private List<Salida> recorrerValor(String lista) {
        StringTokenizer token = new StringTokenizer(lista, ",");
        List<Salida> unaSalida = new ArrayList<>();
        while (token.hasMoreTokens()) {
            String proximoToken = token.nextToken();
            unaSalida.add(creadorDeSalidas.generar(proximoToken));
        }
        return unaSalida;
    }

    private String formatoMensaje(String unMensaje) {
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fechaConFormato = fecha.format(formatter);
        String mensajeDeSalida = fechaConFormato + " " + unMensaje;
        return mensajeDeSalida;
    }
}
