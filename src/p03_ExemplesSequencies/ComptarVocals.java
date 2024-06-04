package p03_ExemplesSequencies;

import eines.Teclat;

public class ComptarVocals {
    public static void main(String[] args) {
        String unaCadena;
        int vocals;

        System.out.println("\nComptar les vocals");
        System.out.println("------------------\n");

        System.out.print("Escriu una frase: ");
        unaCadena = Teclat.llegirCadena();

        vocals = comptarLesVocals_01(unaCadena);
        System.out.format("Amb el mètode comptarLesVocals_01\nLa frase '%s' té %d vocals.\n", unaCadena, vocals);

        vocals = comptarLesVocals_02(unaCadena, 0);
        System.out.format("Amb el mètode comptarLesVocals_02\ntambé té %d vocals.\n", vocals);
    }

    public static int comptarLesVocals_01(String sequencia) {
        if (sequencia.length() == 0)
            return 0;
        char cap = sequencia.charAt(0);
        String cua = sequencia.substring(1);
        if (esVocal(cap)) {
            return 1 + comptarLesVocals_01(cua);
        } else {
            return comptarLesVocals_01(cua);
        }
    }

    public static int comptarLesVocals_02(String sequencia, int posCap) {
        if (posCap == sequencia.length())
            return 0;
        char cap = sequencia.charAt(posCap);
        if (esVocal(cap)) {
            return 1 + comptarLesVocals_02(sequencia, posCap + 1);
        } else {
            return comptarLesVocals_02(sequencia, posCap + 1);
        }
    }


    private static boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
