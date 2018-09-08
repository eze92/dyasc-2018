package ar.edu.untref.dyasc;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class ClienteTest {

	
	private Cliente unCliente;
	
	@Before
	
	public void crearCliente() {
		unCliente = new Cliente ("eze","ledesma","calle falsa 123",36555888);
	}
	@Test
	public void asignarSuscripcionDeUnProducto() {
		Producto revista = new Periodico(25.00, "Calculo", "2");
	    Boolean result = unCliente.asignarSuscripcion(revista);
	    Assert.assertTrue(result);
	}
	
	@Test
    public void contieneSuscripcionRetornaTrue() {

        Producto revista = new Periodico(25d, "Pinion", "I1");
        this.unCliente.asignarSuscripcion(revista);

        Boolean result = this.unCliente.contieneSuscripcion(revista);

        Assert.assertTrue(result);
    }
	
	 @Test
	    public void obtenerMontoComprasRealizadasMes4DeberiaRetornar100SinSuscripcion() {

	        @SuppressWarnings("deprecation")
			Compra nuevaCompra = new Compra(new Date("04/23/2018"));
	        nuevaCompra.setProducto(new Periodico(100.0, "Revista", "A1"));
	        CuentaCorriente unaCuenta = new CuentaCorriente();
	        unaCuenta.agregoCompra(nuevaCompra);
	        this.unCliente.setCuentaCorriente(unaCuenta);
	        Double monto = this.unCliente.obtenerMontoComprasRealizadasAnioyMes(4, 2018);
	        Assert.assertEquals(new Double(100), monto);
	    }
	 
	 @Test
	    public void obtenerDeMontoCompraConSuscripcionDeberiaRetonarMontoMenos20x100to() {

	        @SuppressWarnings("deprecation")
			Compra nuevaCompra = new Compra(new Date("04/28/2018"));
	        Producto revistaGente = new Periodico(100.0, "Revista", "A1");
	        nuevaCompra.setProducto(revistaGente);
	        CuentaCorriente unaCuenta = new CuentaCorriente();
	        unaCuenta.agregoCompra(nuevaCompra);
	        this.unCliente.asignarSuscripcion(revistaGente);
	        this.unCliente.setCuentaCorriente(unaCuenta);

	        Double monto = this.unCliente.obtenerMontoComprasRealizadasAnioyMes(4, 2018);

	        Assert.assertEquals(new Double(83.33), monto,0.02);
	    }

	
}
