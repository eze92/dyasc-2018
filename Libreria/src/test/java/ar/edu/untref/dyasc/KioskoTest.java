package ar.edu.untref.dyasc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class KioskoTest {
	
    private List<Cliente> listadoDeClientes;
    private Kiosco negocio;
    private Cliente unCliente;
	
	@Before
	public void crearEntidadesIniciadoras(){
	  listadoDeClientes = new ArrayList<>();
	  negocio = new Kiosco(listadoDeClientes, crearListadoDeProductos());
	 }
	
	@Before 
	public void crearCliente() {
		unCliente = new Cliente("eze","ledesma","calle falsa 123",36555888);
	}
	

    private List<Producto> crearListadoDeProductos() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new ArticuloDeLibreria(10.0, "Lapiz", "A1"));
        productos.add(new ArticuloDeLibreria(26.0, "Cuaderno", "A1"));
        productos.add(new Periodico(55.0, "Revista", "R1"));
        return productos;
    }
    
    @Test
    public void hayProductos(){

        Assert.assertTrue(negocio.hayProductos());
    }

	
	@Test
    public void montoACobrarAUnClienteEnElMes3RetornarValor30Pesos() {

        CuentaCorriente ctaCorriente = new CuentaCorriente();

        Compra compra = new Compra(obtenerFechaFormateada("01/03/2018"));

        compra.setProducto(new Periodico(30.0, "Revista", "A1"));
        ctaCorriente.agregoCompra(compra);
        unCliente.setCuentaCorriente(ctaCorriente);
        negocio.agregarCliente(unCliente);
        Double montoMesMarzo = negocio.montoACobrar(3, 2018, unCliente);
        Assert.assertEquals(new Double(28.57), montoMesMarzo, 0.02);
    }
	
	 @Test
	    public void montoACobrarAUnClienteEnElMes3TieneUnaSuscripcionSoloTiene20x100toDescuento() {


	        CuentaCorriente ctaCorriente = new CuentaCorriente();
	        Compra compra = new Compra(obtenerFechaFormateada("01/03/2018"));
	        Producto diario = new Periodico(30.0, "Diario ARG.", "A1");
	        compra.setProducto(diario);
	        ctaCorriente.agregoCompra(compra);
	        unCliente.setCuentaCorriente(ctaCorriente);
	        unCliente.asignarSuscripcion(diario);
	        negocio.agregarCliente(unCliente);
	        Double montoMesMarzo = negocio.montoACobrar(3, 2018, unCliente);

	        Assert.assertEquals(new Double(25), montoMesMarzo, 0.1);
	    }
	 
	 @Test
	    public void montoACobrarAUnClienteAnual2017() {

	        CuentaCorriente ctaCorriente = new CuentaCorriente();

	        Compra compra = new Compra(obtenerFechaFormateada("01/03/2017"));
	        Producto diario = new Periodico(30.0, "Diario ARG.", "A1");
	        compra.setProducto(diario);
	        ctaCorriente.agregoCompra(compra);
	        negocio.agregarCliente(unCliente);
	        compra = new Compra(obtenerFechaFormateada("23/05/2017"));
	        compra.setProducto(new Periodico(30.0, "Diario ARG.", "A1"));
	        ctaCorriente.agregoCompra(compra);
	        unCliente.setCuentaCorriente(ctaCorriente);
	        Double montoMesMarzo = negocio.montoACobrar(2017, unCliente);

	        Assert.assertEquals(new Double(57.14), montoMesMarzo, 0.2);
	    }
	
	 private Date obtenerFechaFormateada(String unaFecha) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        Date fecha = null;
	        try {
	            fecha = sdf.parse(unaFecha);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return fecha;
	    }
	


}
