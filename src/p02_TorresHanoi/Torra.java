package p02_TorresHanoi;

import java.util.LinkedList;

public class Torra {
    /* Es crea la classe Torra que té:
     * un nom de tipus String,
     * i els mètodes obte disc, posar disc
     * les funcions posar/obtenir, sempre posen a sobre de l'últim o obtenen l'últim
     */
    private char nom;
    private LinkedList<Integer> elements;

    public Torra(char _nom) {
        this.nom = _nom;
        elements = new LinkedList<>();
    }

    // Sempre afegim i trèiem del final
    public void posa(int _disc) {
        elements.addLast(_disc);
    }

    // Sempre afegim i trèiem del final
    public int treu() {
        return elements.pollLast();
    }

    public char tornaNom() {
        return this.nom;
    }

    public String obte(int pos) {
        if (pos >= elements.size()) return "  ";
        // %2d fa que sempre siguin 2 caràcters.
        return String.format("%2d", elements.get(pos));

    }
}
