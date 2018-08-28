package ar.edu.untref.dyasc;

import junit.framework.Assert;

import org.junit.Test;


public class fiboTest {

	//Test de la funcion fibonacci
	
	@Test
	public void prueba() {
		fibo fi = new fibo();
        int esperado = 55;
        int real= fi.fibonacci(10);
        Assert.assertEquals(esperado, real);
        
	  }
	@Test
	public void prueba2() {
		fibo fi = new fibo();
        int esperado = 1;
        int real= fi.fibonacci(1);
        Assert.assertEquals(esperado, real);
	}
	@Test
	public void prueba3() {
		fibo fi = new fibo();
        int esperado = 5;
        int real= fi.fibonacci(5);
        Assert.assertEquals(esperado, real);
 	}
	

}