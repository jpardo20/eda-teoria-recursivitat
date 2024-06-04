package p01_exemplesInicials;

import eines.Teclat;

public class E02_Potencia {
    public static void main (String [] args) {
        int base, exponent, pot;
        System.out.println("\nPotència");
        System.out.println("--------\n");
        System.out.print("base: ");
        base = Teclat.llegirEnter();
        System.out.print("exponent: ");
        exponent = Teclat.llegirEnter();
        System.out.print("\n"+base+" elevat a "+exponent+" = ");
        if (exponent<0) {
            pot = potenciaRec(base, -exponent);
            System.out.println("1/"+pot+" = "+1.0/pot);
        }
        else {
            pot = potenciaRec(base, exponent);
            System.out.println(pot);
        }
    }

    private static int potenciaRec (int a, int b) {
        if (b==0)
            return 1;
        else
            return a * potenciaRec(a, b-1);
    }
}
