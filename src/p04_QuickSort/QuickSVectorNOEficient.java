package p04_QuickSort;

import java.util.Random;

public class QuickSVectorNOEficient {

    public static void main (String [] args) {
    	// genera un vector de 2000 posicions a l'atzar
    	// l'ordena i comprova que l'ordenació és correcta
        Random random = new Random();

        int [] elVector = new int[2000];
        for (int i=0; i<elVector.length; i++)
            elVector[i] = random.nextInt(10000000);

        QuickSort(elVector, elVector.length);

        for (int i=0; i<elVector.length-1; i++) {
            if (elVector[i]>elVector[i+1]) {
                System.out.println("ERROR");
                System.exit(0);
            }
        }

        System.out.println("\nOK, ordenació correcta");

    }

    private static void QuickSort (int [] vector, int mida) {
        int pivot, indexPetit, indexGran, index;
        int [] mesPetits, mesGrans;

        if (mida<=1) return; // amb un o cap element, ja està ordenat

        // triar un element que faci de pivot
        pivot = vector[mida-1];

        // font d'ineficiència espacial: a cada crida es creen
        // dos nous vectors de la mateixa mida...
        mesPetits = new int[mida];
        mesGrans = new int[mida];

        // repartir
        indexPetit = 0;
        indexGran = 0;
        for (int i=0; i<mida; i++) {
            if (vector[i]<pivot){mesPetits[indexPetit]=vector[i]; indexPetit++;}
            if (vector[i]>pivot){mesGrans[indexGran]=vector[i]; indexGran++;}
        }

        // ordenar els dos fragments
        QuickSort (mesPetits, indexPetit);
        QuickSort (mesGrans, indexGran);

        // concatenar
        index = 0;
        for (int i=0; i<indexPetit; i++) {vector[index]=mesPetits[i]; index++;}
        vector[index] = pivot; index++;
        for (int i=0; i<indexGran; i++) {vector[index]=mesGrans[i]; index++;}
    }

    private static void swap (int [] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

}
