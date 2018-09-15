package ar.edu.untref.dyasc;

public class Program {

    private static int limite = 0;

    public static void main(String[] args) {

        boolean estaCorrecto = new Validador().chequeoArgumento(args);
        if (estaCorrecto) {
            args = argumentoCompleto(args);
<<<<<<< HEAD
            Fibo unFibo = creaFibo(args);
            Boolean esVertical = args[0].matches("-o=[v][a-zA-Z]");
            String sucesionF = darFormaAFibonacci(unFibo, args[0]);
=======
            fibo unFibo = creaFibo(args);

            Boolean esVertical = ("-o=vd".equals(args[0]) || "-o=vi".equals(args[0]));
            String sucesionF = darFormaAFibonacci(unFibo, esVertical);
>>>>>>> cd65047e28b41b10b8dbf65bcf1eab954540b889
            String salida = obtenerSalida(args, unFibo, esVertical, sucesionF);
            System.out.println(salida);
        } else {
            System.out.println("Opciones no validas.");
        }
    }

<<<<<<< HEAD
    private static String obtenerSalida(String[] args, Fibo unFibo, Boolean esVertical, String sucesionF) {
        String output;
        if (escribeArchivo(args[1])) {
=======
    private static String obtenerSalida(String[] args, fibo unFibo, Boolean esVertical, String sucesionF) {
        String output;
        if(escribeArchivo(args[1])) {
>>>>>>> cd65047e28b41b10b8dbf65bcf1eab954540b889
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

    private static Fibo creaFibo(String[] args) {
        limite = obtenerLimite(args);
<<<<<<< HEAD
        Boolean estaInvertido = args[0].matches("-o=[a-zA-Z][i]");
        return new Fibo(limite, estaInvertido);
=======
        Boolean estaInvertido = ("-o=hi".equals(args[0]) || "-o=vi".equals(args[0]));
        return new fibo(limite, estaInvertido);
>>>>>>> cd65047e28b41b10b8dbf65bcf1eab954540b889
    }

    private static String obtenerNombreArchivo(String argument) {
        String[] arrayArgument = argument.split("=");
        return arrayArgument[1];
    }

<<<<<<< HEAD
    private static String darFormaAFibonacci(Fibo unFibo, String args) {
        FormaFibonacci forma;
        if (args.matches("-o=[v][a-zA-Z]")) {
=======
    private static String darFormaAFibonacci(fibo unFibo, Boolean esVertical) {
        FormaFibonacci forma;
        if (esVertical) {
>>>>>>> cd65047e28b41b10b8dbf65bcf1eab954540b889
            forma = new FiboVertical();
        } else {
            forma = new FiboHorizontal();
        }
        return forma.devolverForma(unFibo.getSucesion());
<<<<<<< HEAD
    }
=======
}
>>>>>>> cd65047e28b41b10b8dbf65bcf1eab954540b889

    private static String obtenerTexto(String argument, String sucesion, Fibo unFibo, Boolean esVertical) {
        StringBuffer stringBuffer = new StringBuffer();
        if (sumaFibo(argument)) {
            stringBuffer.append("fibo<" + limite + ">s: ");
            if (esVertical) {
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
            arguments = new String[] { "-o=hd", args[0] };
        }
        return arguments;
    }

}
