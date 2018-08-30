package ar.edu.untref.dyasc;

public class Program {

    private static int limite = 0;

    public static void main(String[] args) {

        boolean estaCorrecto = new Validador().checkArguments(args);
        if (estaCorrecto) {
            args = completeArguments(args);
            fibo unFibo = creaFibo(args);

            Boolean esVertical = ("-o=vd".equals(args[0]) || "-o=vi".equals(args[0]));
            String sucesionF = giveShapeToFibonacci(unFibo, esVertical);
            String salida = obtainOutput(args, unFibo, esVertical, sucesionF);
            System.out.println(salida);
        } else {
            System.out.println("Opciones no validas.");
        }
    }

    private static String obtainOutput(String[] args, fibo unFibo, Boolean esVertical, String sucesionF) {
        String output;
        if(escribeArchivo(args[1])) {
            String archivo = obtainNameFile(args[1]);
            FiboW fiboW = new FiboW();
            String contenido = obtainTextToShow(args[2], sucesionF, unFibo, esVertical);
            fiboW.write(archivo, contenido);
            output = "fibo<" + limite + "> guardado en " + archivo;
        } else {
            output = obtainTextToShow(args[1], sucesionF, unFibo, esVertical);
        }
        return output;
    }

    private static fibo creaFibo(String[] args) {
        limite = obtenerLimite(args);
        Boolean isInverted = ("-o=hi".equals(args[0]) || "-o=vi".equals(args[0]));
        return new fibo(limite, isInverted);
    }

    private static String obtainNameFile(String argument) {
        String[] arrayArgument = argument.split("=");
        return arrayArgument[1];
    }

    private static String giveShapeToFibonacci(fibo unFibo, Boolean esVertical) {
        ShapeToFibonacci shapeToFibonacci;
        if (esVertical) {
            shapeToFibonacci = new FiboVertical();
        } else {
            shapeToFibonacci = new FiboHorizontal();
        }
        return shapeToFibonacci.giveShape(unFibo.getSucesion());
    }


    private static String obtainTextToShow(String argument, String sucesion, fibo unFibo, Boolean esVertical) {
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

    private static String[] completeArguments(String[] args) {
        String[] arguments = args;
        if (arguments.length == 1) {
            arguments = new String[]{"-o=hd", args[0]};
        }
        return arguments;
    }

	

}
