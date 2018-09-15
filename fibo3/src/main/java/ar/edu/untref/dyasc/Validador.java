package ar.edu.untref.dyasc;

public class Validador {
<<<<<<< HEAD


    private final static String[] validaArgumento = new String[] { "-o=[vhp][di]", "-m=[ls]", "-f=[^\\s]+" };

    public Boolean chequeoArgumento(String[] arguments) {
        boolean legalArguments = true;

        if (arguments.length > 1) {
            for (int i = 0; i < arguments.length - 1; i++) {
                legalArguments = false;
                for (String validaArgumento : validaArgumento) {
                    if (arguments[i].matches(validaArgumento)) {
                        legalArguments = true;
                    }
                }
            }
        }
        // El ultimo parámetro debe ser el número de la secuencia de fibonacci
        try {
            Integer.parseInt(arguments[arguments.length - 1]);
        } catch (Exception e) {
            legalArguments = false;
        }

        return legalArguments;
    }
=======
	
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
>>>>>>> cd65047e28b41b10b8dbf65bcf1eab954540b889

}
