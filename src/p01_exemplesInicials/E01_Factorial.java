package p01_exemplesInicials;

import eines.Teclat;

public class E01_Factorial {
    public static void main (String [] args) {
        int numeroLlegit, factorial;
        System.out.println("\nFactorial");
        System.out.println("----------\n");
        System.out.print("De quin número en vols calcular el factorial?: ");
        numeroLlegit = Teclat.llegirEnter();
        if (numeroLlegit<0) {
            System.err.println("\nNo és pot calcular el factoria d'un número negatiu");
        }
        else {
            factorial = factorialRec(numeroLlegit);
            System.out.println("\nel factorial de "+numeroLlegit+" és "+factorial);
        }
    }
    private static int factorialRec (int n) {
        if (n==0)
            return 1;
        else
            return n * factorialRec(n-1);
    }
}