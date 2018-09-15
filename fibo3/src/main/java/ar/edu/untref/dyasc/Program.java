package ar.edu.untref.dyasc;

public class Program {

  private static int limite = 0;

    public static void main(String[] args) {

        boolean estaCorrecto = new Validador().chequeoArgumento(args);
        if (estaCorrecto) {
            args = argumentoCompleto(args);
            fibo unFibo = creaFibo(args);

            Boolean esVertical = ("-o=vd".equals(args[0]) || "-o=vi".equals(args[0]));
            String sucesionF = darFormaAFibonacci(unFibo, esVertical);
            String salida = obtenerSalida(args, unFibo, esVertical, sucesionF);
            System.out.println(salida);
        } else {
            System.out.println("Opciones no validas.");
        }
    }

    private static String obtenerSalida(String[] args, fibo unFibo, Boolean esVertical, String sucesionF) {
        String output;
        if(escribeArchivo(args[1])) {
            String archivo = obtenerNombreArchivo(args[1]);
            FiboW fiboW = new FiboW();
            String contenido = obtenerTexto(args[2], sucesionF, unFibo, esVertical);
            fiboW.write(archivo, contenido);
            output = "fibo<" + limite + "> guardado en " + archivo;
        } else {
            output = obtenerTexto(args[1], sucesionF, unFibo, esVertical);
        }
        return output;
    }

    private static fibo creaFibo(String[] args) {
        limite = obtenerLimite(args);
        Boolean estaInvertido = ("-o=hi".equals(args[0]) || "-o=vi".equals(args[0]));
        return new fibo(limite, estaInvertido);
    }

    private static String obtenerNombreArchivo(String argument) {
        String[] arrayArgument = argument.split("=");
        return arrayArgument[1];
    }

    private static String darFormaAFibonacci(fibo unFibo, Boolean esVertical) {
        FormaFibonacci forma;
        if (esVertical) {
            forma = new FiboVertical();
        } else {
            forma = new FiboHorizontal();
        }
        return forma.devolverForma(unFibo.getSucesion());
}


    private static String obtenerTexto(String argument, String sucesion, fibo unFibo, Boolean esVertical) {
        StringBuffer stringBuffer = new StringBuffer();
        if(sumaFibo(argument)) {
            stringBuffer.append("fibo<" + limite + ">s: ");
            if(esVertical) {
                stringBuffer.append("\n");
            }
            stringBuffer.append(unFibo.sumarSucesion());
        } else {
            stringBuffer.append("fibo<" + limite + ">:");
            stringBuffer.append(sucesion);
        }
        return stringBuffer.toString();
    }

    private static int obtenerLimite(String[] args) {
        return Integer.valueOf(args[args.length - 1]);
    }

    private static Boolean escribeArchivo(String arg) {
        return arg.contains("-f");
    }

    private static Boolean sumaFibo(String arg) {
        return arg.contains("-m=s");
    }

    private static String[] argumentoCompleto(String[] args) {
        String[] arguments = args;
        if (arguments.length == 1) {
            arguments = new String[]{"-o=hd", args[0]};
        }
        return arguments;
    }
	

}
