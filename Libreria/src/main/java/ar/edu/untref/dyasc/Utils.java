package ar.edu.untref.dyasc;

import java.util.Calendar;
import java.util.Date;

public class Utils {

	
	public static Double descuento_cliente =1.05;
	public static Double suscripcion = 1.2;
	
	public static Integer obtenerMes(Date fecha){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal.get(Calendar.MONTH) + 1;
    }
	
	public static Integer obtenerAnio(Date fecha){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal.get(Calendar.YEAR);
    }
}
