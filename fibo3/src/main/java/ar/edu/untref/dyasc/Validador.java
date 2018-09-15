package ar.edu.untref.dyasc;


public class Validador {
	
	 	private final static String OPTION_VD = "-o=vd";
	    private final static String OPTION_VI = "-o=vi";
	    private final static String OPTION_HD = "-o=hd";
	    private final static String OPTION_HI = "-o=hi";

	    public Boolean chequeoArgumento(String[] arguments) {
	        if (arguments.length == 2) {
	            return chequeoPrimerArgumento(arguments[0]);
	        }
	        return arguments.length <= 4;
	    }

	    private Boolean chequeoPrimerArgumento(String firstArgument) {
	        return (firstArgument.equals(OPTION_VD) || firstArgument.equals(OPTION_VI) || firstArgument.equals(OPTION_HD) || firstArgument.equals(OPTION_HI));
	}

}
