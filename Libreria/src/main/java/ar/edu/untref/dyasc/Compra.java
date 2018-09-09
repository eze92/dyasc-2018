package ar.edu.untref.dyasc;

import java.util.Date;

public class Compra {

    private Producto unProducto;
    private int codigoFactura;
    private Date fecha;

    public Compra(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public Producto getProducto() {
        return this.unProducto;
    }

    public void setProducto(Producto unProducto) {
        this.unProducto = unProducto;
    }
}
