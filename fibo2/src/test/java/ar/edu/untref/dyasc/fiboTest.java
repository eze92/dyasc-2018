package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
public class fiboTest {

	 @Test
	    public void getSuccessionShouldReturn5Values() {
		 List<Integer> resultado = fibo.calculoFibo(5);
	 }
	 @Test
	    public void devuelve5Valores() {
	        Integer limite = 5;
	        Boolean estaInvertido = false;
	        fibo fibonacci = new fibo(limite, estaInvertido);
	        List<Integer> resultado = fibonacci.getSucesion();

	        int[] actualsValues = new int[resultado.size()];
	        for (int i = 0; i < resultado.size(); i++) {
	            actualsValues[i] = resultado.get(i);
	        }
	        int[] expectedsValues = new int[]{0, 1, 1, 2, 3};
	        Assert.assertArrayEquals(expectedsValues, actualsValues);
	}
	 
	 @Test
	    public void devuelve8Valores() {
	        Integer limite = 8;
	        Boolean estaInvertido = false;
	        fibo fibonacci = new fibo(limite, estaInvertido);
	        List<Integer> resultado = fibonacci.getSucesion();

	        int[] actualsValues = new int[resultado.size()];
	        for (int i = 0; i < resultado.size(); i++) {
	            actualsValues[i] = resultado.get(i);
	        }
	        int[] expectedsValues = new int[]{0, 1, 1, 2, 3, 5, 8, 13};
	        Assert.assertArrayEquals(expectedsValues, actualsValues);
	}

}