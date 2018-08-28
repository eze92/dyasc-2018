package ar.edu.untref.dyasc;

import java.util.HashMap;
import java.util.List;

public class Program {
	
	protected Program() {
		
	}
	

	public static void main(String[] args) {

	        args = checkArguments(args);

	        HashMap<Integer, String> mapa = getMapa();
	        String opcion = args[0];

	        if (mapa.containsValue(opcion)) {
	            int limite = Integer.valueOf(args[1]);

	            Integer keyOfOption = getClaves(mapa, opcion);
	            boolean estaInvertido = (keyOfOption == 2 || keyOfOption == 4);

	            fibo unFibo;

	            if (keyOfOption == 1 || keyOfOption == 2) {
	            	unFibo = new fibo(limite, estaInvertido);    
	                String resultado = unFibo.mostrarV();
	                System.out.println(resultado);
	            } else {
	            	unFibo = new fibo(limite, estaInvertido);
	                String resultado = unFibo.mostrar();
	                System.out.println(resultado);
	            }
	        } else {
	            System.out.println("Opciones no validas.");
	        }
	    }

	
	 private static String[] checkArguments(String[] args) {
	        String[] arguments = args;
	        if (arguments.length == 1) {
	            String value = args[0];
	            arguments = new String[2];
	            arguments[0] = "-o=hd";
	            arguments[1] = value;

	        }
	        return arguments;
	    }

	    private static HashMap<Integer, String> getMapa(){
	        HashMap<Integer, String> unMapa = new HashMap<>();
	        unMapa.put(1, "-o=vd");
	        unMapa.put(2, "-o=vi");
	        unMapa.put(3, "-o=hd");
	        unMapa.put(4, "-o=hi");
	        return unMapa;
	    }

	    private static Integer getClaves(HashMap<Integer, String> unMapa, String valor){
	        for (Integer eachKey : unMapa.keySet()) {
	            if(valor.equals(unMapa.get(eachKey).toString())){
	                return eachKey;
	            }
	        }
	        return null;
	}

}