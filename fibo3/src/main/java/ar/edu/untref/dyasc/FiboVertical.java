package ar.edu.untref.dyasc;


import java.util.List;

public class FiboVertical implements ShapeToFibonacci {

	@Override
	public String giveShape(List<Integer> sucesion) {
		StringBuffer salida = new StringBuffer();
		for (Integer eachNumber : sucesion) {
			salida.append("\n");
        	salida.append(eachNumber);
			
		}
        return salida.toString();
	}


}
