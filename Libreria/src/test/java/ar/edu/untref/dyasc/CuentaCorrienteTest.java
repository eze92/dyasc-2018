package ar.edu.untref.dyasc;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class CuentaCorrienteTest {

    @Test
    public void agregoCompra() {

        Compra unaCompra = new Compra(new Date());
        unaCompra.setProducto(new ArticuloDeLibreria(30.0, "Libro", "L0"));
        CuentaCorriente unaCuenta = new CuentaCorriente();

        unaCuenta.agregoCompra(unaCompra);

        Assert.assertNotNull(unaCuenta.getCompras());
    }

}
