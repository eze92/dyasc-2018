package ar.edu.untref.dyasc;



public class fibo{

  
    public fibo() {
    } 
    
  // metodo main que muestra el resultado

public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
	System.out.print("fibo");
	System.out.print("<");
	System.out.print(N);
	System.out.print(">:");
        for (int i = 0; i < N; i++) {
            System.out.print(fibonacci(i)+ " ");
    }
    System.out.println();  
}
    public static int fibonacci(int n){
           if (n > 1){
              return fibonacci(n-1) + fibonacci(n-2); 
           }
           else if (n == 1) {
               return 1;
           }
           else if (n == 0 ){
               return 0;
           }
           else{
               System.out.println("Debes ingresar un tamaño mayor o igual a 1");
               return -1; 
           }

   	}
}