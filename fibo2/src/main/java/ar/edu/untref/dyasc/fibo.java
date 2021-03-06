package ar.edu.untref.dyasc;


import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

public class fibo{

	private List<Integer> sucesion;
	
	public fibo(Integer limite, Boolean estaInvertido) {
		sucesion = this.calculoFibo(limite);
        if(estaInvertido) {
        	sucesion = this.invertirSucesion();
        }
}
	
	public static List<Integer> calculoFibo(int limite) {
	    return Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
	      .limit(limite)
	      .map(n -> n[0])
	      .collect(toList());
		}
		
	private List<Integer> invertirSucesion () {
	    List<Integer> listaInvertida = new ArrayList<>();
	     for (int i = (sucesion.size()-1); i >= 0; i--) {
	    	 listaInvertida.add(sucesion.get(i));
	      }
	      return listaInvertida;
		}
	
	public List<Integer> getSucesion() {
        return this.sucesion;
		}
	
	 public String mostrar() {
	        StringBuffer salida = new StringBuffer("fibo<").append(this.sucesion.size()).append(">: ");
	        for (Integer eachNumber : this.sucesion) {
	            salida.append(" ").append(eachNumber);
	        }
	        return salida.toString();
	 }
	 public String mostrarV() {
	        StringBuffer salida = new StringBuffer("fibo<").append(this.sucesion.size()).append(">: ");
	        for (Integer eachNumber : this.sucesion) {
	        	salida.append("\n");
	        	salida.append(eachNumber);
	        }
	        return salida.toString();
	}
}
