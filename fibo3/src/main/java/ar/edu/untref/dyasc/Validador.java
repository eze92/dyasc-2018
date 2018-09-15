package ar.edu.untref.dyasc;

public class Validador {

    private final static String[] validaArgumento = new String[] { "-o=[vh][di]", "-m=[ls]", "-f=[^\\s]+" };

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
        try {
            Integer.parseInt(arguments[arguments.length - 1]);
        } catch (Exception e) {
            legalArguments = false;
        }

        return legalArguments;
    }

}
