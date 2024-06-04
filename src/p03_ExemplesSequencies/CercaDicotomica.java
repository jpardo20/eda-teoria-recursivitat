package p03_ExemplesSequencies;

import eines.Teclat;
import java.util.*;

public class CercaDicotomica {

    public static void main (String [] args) {
        int element;
        int pos;
        int[] elVector = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        
        System.out.println("\nCerca DICOT�MICA");
        System.out.println("----------------\n");

        System.out.println("Cerca sobre el vector ");
        System.out.println("   "+Arrays.toString(elVector)+"\n");
        System.out.print("element a cercar (-1000 per finalitzar): ");
        element = Teclat.llegirEnter();
        while (element != -1000) {
            pos = cercaDicotomica(elVector, element, 0, elVector.length-1);
            System.out.println(element+" --> "+pos);
            System.out.println();
            
            System.out.print("element a cercar (-1000 per finalitzar): ");
            element = Teclat.llegirEnter();
        }

    }

    private static int cercaDicotomica (int vector[], int element,
                                        int primer, int darrer) {

        int centre;

        if (primer > darrer) // indexs "creuats" = vector exhaurit
            return -1;

        centre = (primer+darrer)/2;

        if (vector[centre] == element)
            return centre;

        if (vector[centre]<element)
            return cercaDicotomica(vector, element, centre+1, darrer); // dreta
        else
            return cercaDicotomica(vector, element, primer, centre-1); // esquerra

    }

}