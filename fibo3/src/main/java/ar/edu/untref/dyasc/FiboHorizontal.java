package ar.edu.untref.dyasc;

import java.util.List;

public class FiboHorizontal implements ShapeToFibonacci {

	   @Override
	    public String giveShape(List<Integer> succession) {
	        StringBuffer out = new StringBuffer();
	        for (Integer eachNumber : succession) {
	            out.append(" ").append(eachNumber);
	        }
	        return out.toString();
	    }
	}

