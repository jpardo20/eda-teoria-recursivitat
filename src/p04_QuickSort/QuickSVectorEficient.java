package p04_QuickSort;

import java.util.Random;

public class QuickSVectorEficient {

	public static void main (String [] args) {
    	// genera un vector de 2000 posicions a l'atzar
    	// l'ordena i comprova que l'ordenació és correcta
        Random random = new Random();

        int [] elVector = new int[2000];
        for (int i=0; i<elVector.length; i++)
            elVector[i] = random.nextInt(10000000);

        QuickSort(elVector, 0, elVector.length-1);

        for (int i=0; i<elVector.length-1; i++) {
            if (elVector[i]>elVector[i+1]) {
                System.out.println("ERROR");
                System.exit(0);
            }
        }

        System.out.println("\nOK!, ordenació correcta");

    }

    private static void QuickSort (int [] vector, int primer, int ultim) {
        int pivot;
        int i,j;

        if ( primer >= ultim) return; // vector exhaurit

        // triar un element que faci de pivot
        pivot = vector[(primer+ultim)/2];

        // moure tots els elements més petits que el pivot a l'esquerra
        // i els mes grans a la dreta
        i = primer;
        j = ultim;
        while (i<=j) {
            // buscar un element més gran que estigui a l'esquerra
            while (vector[i]<pivot) i++;
            // buscar un element més petit que estigui a la dreta
            while (vector[j]>pivot) j--;
            // intercanviar-los si cal
            if (i<=j) {
                swap(vector, i,j); 
                i++; j--;
            }
        }

        // ordenar els dos costats
        QuickSort (vector, primer, j);
        QuickSort (vector, i, ultim);
    }

    private static void swap (int [] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

}
