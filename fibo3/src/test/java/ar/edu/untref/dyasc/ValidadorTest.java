package ar.edu.untref.dyasc;
import org.junit.Test;

import junit.framework.Assert;

public class ValidadorTest {

    @SuppressWarnings("deprecation")
	@Test
    public void checkArgumentsShouldReturnTrue(){

    	Validador validator = new Validador();
        String[] arguments = new String[]{"-o=vd", "-f=salida.txt", "5"};

        Boolean esCorrecto = validator.chequeoArgumento(arguments);

        Assert.assertTrue(esCorrecto);
    }

    @Test
    public void checkArgumentsWithArgumentsIncorrectShouldReturnFalse(){

    	Validador validator = new Validador();
        String[] arguments = new String[]{"-o=vd", "-f=salida.txt", "5", "NA", "NA"};

        Boolean isRight = validator.chequeoArgumento(arguments);

        Assert.assertFalse(isRight);
    }
}
