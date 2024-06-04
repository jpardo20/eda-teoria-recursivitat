package p01_exemplesInicials;

import eines.Teclat;

public class E04_Fibonacci {

    public static void main (String [] args) {
        int n;
        System.out.println("\nFibonacci");
        System.out.println("---------");
        System.out.print("\nquin terme (n>=0) de la succ de fibonnaci vols calcular? ");
        n = Teclat.llegirEnter();
        if (n<0) {
            System.out.println("\nTu t'ho has buscat...");
            System.out.print("... prem return per continuar");
            Teclat.llegirCadena();
        }
        System.out.println("\nfib("+n+")= "+fibonacciRec(n));
    }

    private static int fibonacciRec (int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        return fibonacciRec(n-1)+fibonacciRec(n-2);
    }

}