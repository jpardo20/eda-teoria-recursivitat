package p02_TorresHanoi;

import eines.Teclat;

public class TorresHanoi {
    public static void main(String[] args) {
        int discs;
        System.out.println("\nLes Torres de Hanoi");
        System.out.println("--------------------\n");
        System.out.print("Quina quantitat de discos vols moure? ");
        discs = Teclat.llegirEnter();
        System.out.println("\nLLISTA DE MOVIMENTS");
        System.out.println("------ -- ---------");
        hanoi(discs, "A", "B", "C");
    }

    private static void hanoi(int discs,
              String origen,
              String pivot,
              String desti) {
        if (discs == 1) {
            System.out.println("Moure de " + origen + " fins a " + desti);
        } else {
            hanoi(discs - 1, origen, desti, pivot);
            System.out.println("Moure de " + origen + " fins a " + desti);
            hanoi(discs - 1, pivot, origen, desti);
        }
    }
}
