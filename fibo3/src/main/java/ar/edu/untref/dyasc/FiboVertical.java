package ar.edu.untref.dyasc;

import java.util.List;

public class FiboVertical implements FormaFibonacci {

	@Override
	public String devolverForma(List<Integer> sucesion) {
		StringBuffer salida = new StringBuffer();
		for (Integer eachNumber : sucesion) {
			salida.append("\n");
			salida.append(eachNumber);

		}
		return salida.toString();
	}

}
