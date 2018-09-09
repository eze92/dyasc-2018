package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

public class CuentaCorriente {

    private List<Compra> compra = new ArrayList<>();

    public List<Compra> getCompras() {
        return this.compra;
    }

    public void agregoCompra(Compra compra) {
        this.compra.add(compra);
    }

}
