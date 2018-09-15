package ar.edu.untref.dyasc;

public class Periodico extends Producto {

    int periodicidad;

    public Periodico(Double precio, String descripcion, String codigo) {
        this.precio = precio;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }
}
