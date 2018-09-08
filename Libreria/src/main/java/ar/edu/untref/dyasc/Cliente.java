package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;



public class Cliente {
	
	private CuentaCorriente ctaCorriente;
	private List<Producto> suscripciones;
	public String nombre;
	public String apellido;
	public String direccion;
	public int dni;
	
	public Cliente(String nombre ,String apellido ,String direccion ,int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.dni = dni;
		this.ctaCorriente = new CuentaCorriente();
		this.suscripciones = new ArrayList<>();
		
	}
	public Double obtenerMontoComprasRealizadasAnio(Integer anio) {
		 Double montoDelAnio = 0.0;
	        for (Compra cadaCompra : ctaCorriente.getCompras()) {
	            int anioDeLaCompra = Utils.obtenerAnio(cadaCompra.getFecha());
	            if (anio == anioDeLaCompra) {
	                Producto producto = cadaCompra.getProducto();
	                if (contieneSuscripcion(producto)) {
	                    montoDelAnio += (producto.getPrecioDeVenta() / Utils.suscripcion);
	                } else {
	                    montoDelAnio += producto.getPrecioDeVenta();
	                }
	            }
	        }
	        return montoDelAnio;
	 }

	public Double obtenerMontoComprasRealizadasAnioyMes(Integer mes, Integer anio) {
        Double montoDelMes = 0.0;
        for (Compra cadaCompra : ctaCorriente.getCompras()) {
            int mesDeLaCompra = Utils.obtenerMes(cadaCompra.getFecha());
            int anioDeLaCompra = Utils.obtenerAnio(cadaCompra.getFecha());
            if (mes == mesDeLaCompra && anio == anioDeLaCompra) {
                Producto producto = cadaCompra.getProducto();
                if (contieneSuscripcion(producto)) {
                    montoDelMes += (producto.getPrecioDeVenta() / Utils.suscripcion);
                } else {
                    montoDelMes += producto.getPrecioDeVenta();
                }
            }
        }
        return montoDelMes;
    }

	
	
	public CuentaCorriente getCuentaCorriente() {
		return ctaCorriente;
	}
	
	public boolean asignarSuscripcion(Producto producto) {
		return this.suscripciones.add(producto);
	}
	
	public boolean contieneSuscripcion(Producto producto) {
		return this.suscripciones.contains(producto);
	}
	
	public boolean tieneSuscripcion() {
		return this.suscripciones.size() > 0;
	}
	public void setCuentaCorriente(CuentaCorriente ctaCorriente) {
		this.ctaCorriente = ctaCorriente;
	}

}
