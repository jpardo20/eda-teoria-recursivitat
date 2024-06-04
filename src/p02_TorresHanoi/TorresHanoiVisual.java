package p02_TorresHanoi;

import static eines.EinesJoan.pitjaTeclaPerContinuar;
import java.util.*;

public class TorresHanoiVisual {
    // Quantitat de discos
    private int nivell;
    private Torra torraA;
    private Torra torraB;
    private Torra torraC;
    boolean pasAPas;
    Scanner teclat;


    public TorresHanoiVisual(int quatitatDeDiscos) {
        nivell = quatitatDeDiscos;
        torraA = new Torra('A');
        torraB = new Torra('B');
        torraC = new Torra('C');
        for (int numeroElementActual = nivell; numeroElementActual > 0; numeroElementActual--)
            torraA.posa(numeroElementActual);
    }

    private void resol(boolean pasAPas) {
        this.pasAPas = pasAPas;
        if (pasAPas) {
            teclat = new Scanner(System.in);
        }
        resol(nivell, torraA, torraB, torraC);
    }

    // Funció recursiva que mou els discos. Fixeu-vos que les
    // torres a, b, i c, no són sempre les mateixes sinó que
    // s'intercanvien les posicions.
    private void resol(int nivell, Torra torraA, Torra torraB, Torra torraC) {
        if (nivell > 0) {
            if (pasAPas) {
                System.out.println(String.format("Crida a 'resol()' amb" +
                    "%2d nivells, i les torres: %s, %s, %s.",
                        nivell,
                        torraA.tornaNom(),
                        torraB.tornaNom(),
                        torraC.tornaNom()));
            }
            // Intercanviem els les torres 2a i 3a
            // això fa que els n-1 superiors es moguin de "a" a "b" (usant c).
            resol(nivell-1, torraA, torraC, torraB);

            // movem el disc que queda a "a" de "a" a "c"
            int d = torraA.treu();
            torraC.posa(d);
            display();
            if (pasAPas) {
                System.out.println(String.format("Nivell %d\n\t" +
                        "Moviment de %d de: %s, a %s.\n",
                        nivell, d ,torraA.tornaNom(),torraC.tornaNom()));
                pitjaTeclaPerContinuar("Prem 'Enter' per seguir!");
            }
            // intercanviem les torres 1a i 2a
            // movem els que haviem posat a "b" a sobre del disc que hem posat a "c"
            // per fer-ho usem b
            resol(nivell-1, torraB, torraA, torraC);
        }
    }

    /*  per dibuixar les torres */
    public void display() {
        for(int i = nivell - 1; i >= 0; i--) {
            String d1 = " ", d2 = " ", d3 = " ";
            d1 = torraA.obte(i);
            d2 = torraB.obte(i);
            d3 = torraC.obte(i);
            System.out.println(" "+d1+"  | "+d2+"  | "+d3);
        }
        System.out.println("-----------------");
        System.out.format("  %s  |  %s  |  %s", torraA.tornaNom(), torraB.tornaNom(), torraC.tornaNom());
//        System.out.println("  A  |  B  |  C  ");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        // Llegim la quantitat de discos
        System.out.print("Indica el nombre de discos: ");
        int num = new Scanner(System.in).nextInt();
        TorresHanoiVisual hanoi = new TorresHanoiVisual(num);
        hanoi.display();
        System.out.print("Si vols executar pas a pas, contesta 'si':");
        String pasAPas = new Scanner(System.in).next();
        hanoi.resol(pasAPas.equals("si"));
        System.out.println("S'ha acabat!");
    }



}