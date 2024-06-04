package p01_exemplesInicials;

import eines.Teclat;

public class E03_Sumar {

        public static void main (String [] args) {
            int a, b;
            System.out.println("\nSumar(recursivament)");
            System.out.println("--------------------\n");
            System.out.print("primer sumand: ");
            a = Teclat.llegirEnter();
            System.out.print("segon sumand: ");
            b = Teclat.llegirEnter();
            if (b<0) {
                System.err.println("\nEl segon sumand ha de ser positiu");
            }
            else {
                System.out.println("\n"+a+" + "+b+" = "+sumarRec(a,b));
            }
        }

        private static int sumarRec (int a, int b) {
            if (b==0)
                return a;
            else
                return sumarRec(a+1, b-1);
        }
    }