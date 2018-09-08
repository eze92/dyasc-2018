package ar.edu.untref.dyasc;

import java.util.List;


public class Kiosco {
	
	private List<Cliente> clientes ;
	private List<Producto> productos;
	
	public Kiosco(List<Cliente> cliente, List<Producto> producto) {
		this.clientes = cliente;
		this.productos = producto;
	}
	
	public void agregarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	public boolean hayProductos() {
		return this.productos.size() >0;
	}
	
	 private Double aplicarDescuentoCliente(Double montoTotal, Double porcentaje) {
	        return montoTotal / porcentaje;
	 }
	
	public Double montoACobrar(Integer anio, Cliente unCliente) {

        Double montoTotal = 0.0;
        if (clientes.contains(unCliente)) {
            montoTotal = unCliente.obtenerMontoComprasRealizadasAnio(anio);
            if (!unCliente.tieneSuscripcion()) {
                montoTotal = aplicarDescuentoCliente(montoTotal, Utils.descuento_cliente);
            }
        }
        return montoTotal;
    }
	 public Double montoACobrar(Integer mes, Integer anio, Cliente unCliente) {
	        Double montoTotal = 0.0;
	        if (clientes.contains(unCliente)) {
	            montoTotal = unCliente.obtenerMontoComprasRealizadasAnioyMes(mes, anio);
	            if (!unCliente.tieneSuscripcion()) {
	                montoTotal = aplicarDescuentoCliente(montoTotal, Utils.descuento_cliente);
	            }
	        }
	        return montoTotal;
	    }
}
