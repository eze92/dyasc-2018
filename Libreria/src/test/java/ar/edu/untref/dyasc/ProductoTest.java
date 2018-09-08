package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;


public class ProductoTest {
	
    private static Double IVA = 1.21;

    @Test
    public void obterPrecioDeProducto() {

        Producto revista = new Periodico(10.00, "Revita", "R");

        Double precio = revista.getPrecioDeVenta();

        Assert.assertEquals(new Double(10), precio);
    }
    
    @Test
    public void obterPreciodeArticuloConIva() {

        Producto lapizColorNegro = new ArticuloDeLibreria(20d, "Cuaderno","A4");

        Double precio = lapizColorNegro.getPrecioDeVenta();
        Double precioMasIVA = 20.00 *IVA;

         Assert.assertEquals(precioMasIVA, precio);
    }
}
