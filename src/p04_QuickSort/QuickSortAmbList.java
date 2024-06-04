package p04_QuickSort;

import java.util.*;

public class QuickSortAmbList {

    public static void main (String [] args) {
        Random random = new Random();

        List<Comparable> llista = new LinkedList<Comparable>();
        for (int i=1; i<=1000; i++) {
            llista.add(random.nextInt(1000000));
        }

        quickSort(llista);

        for (int i=0; i<llista.size()-1; i++) {
            if ((Integer)llista.get(i)>(Integer)llista.get(i+1)) {
                System.out.println("ERROR");
                System.exit(0);
            }
        }

        System.out.println("\nOK!!, ordenació correcta");
    }

    private static void quickSort (List<Comparable> llista) {

        Comparable pivot;
        int cmp;

        // cas base: una llista buida o amb 1 element segur que està ordenada
        if (llista.size()<=1) return;

        // triar un element que faci de pivot
        pivot = llista.get(llista.size()/2);

        // crear un parell de llistes
        List<Comparable> menor = new LinkedList();
        List<Comparable> major = new LinkedList();

        // recórrer la llista original per classificar els elements
        // en dues subllistes
        for (Comparable e : llista) {
            cmp = e.compareTo(pivot);
            if (cmp<0) menor.add(e);
            else if (cmp>0) major.add(e);
        }
        // ordenar les llistes
        quickSort(menor);
        quickSort(major);

        //refer la llista original a partir de les llistes ordenades i
        //l'element pivot
        llista.clear();
        llista.addAll(menor);
        llista.add(pivot);
        llista.addAll(major);
    }

}
