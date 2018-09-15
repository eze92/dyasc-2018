package ar.edu.untref.dyasc;

import java.util.List;

public class FiboHorizontal implements FormaFibonacci {

	@Override
	public String devolverForma(List<Integer> succession) {
		StringBuffer out = new StringBuffer();
		for (Integer eachNumber : succession) {
			out.append(" ").append(eachNumber);
		}
		return out.toString();
	}

}
