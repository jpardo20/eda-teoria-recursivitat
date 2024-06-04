package p03_ExemplesSequencies;

import java.util.*;
import eines.Teclat;

public class CercaVector {

	public static void main (String [] args) {
		String seqString;
		int [] vector = null, vectorOrdenat = null;
		int objectiu, posicio;
		
		System.out.println("\nCerca en vectors");
		System.out.println("----------------\n");
		
		System.out.println("Escriu una seq��ncia");
		System.out.print("de numeros enters (separats amb blancs): ");
		seqString = Teclat.llegirCadena();
		try {
			vector = convertirEnVector(seqString);
		}
		catch (Exception e) {
			System.out.println("sequ�ncia incorrecta");
			System.exit(0);
		}
		System.out.print("\nIndica un enter per cercar-lo a ");
		System.out.print(Arrays.toString(vector)+" ");
		objectiu = Teclat.llegirEnter();
		posicio = cerca(vector, 0, objectiu);
		if (posicio<0) {
			System.out.println("Element no trobat!");
		}
		else {
			System.out.println("Elment trobat a la posici�: "+posicio);
		}
		vectorOrdenat = Arrays.copyOf(vector, vector.length);
		Arrays.sort(vectorOrdenat);
		System.out.print("\nAra indica un enter per cercar-lo a ");
		System.out.print(Arrays.toString(vectorOrdenat)+" ");
		objectiu = Teclat.llegirEnter();
		posicio = cercaOrdenada(vectorOrdenat, 0, objectiu);
		if (posicio<0) {
			System.out.println("Element no trobat!");
		}
		else {
			System.out.println("Elment trobat a la posici�: "+posicio);
		}
	}
	
	private static int [] convertirEnVector (String s) {
		int i;
		String [] contingut = s.split("\\s+");
		int [] resultat = new int[contingut.length];
		i = 0;
		for (String num : contingut) {
			resultat[i] = Integer.parseInt(num);
			i++;
		}
		return resultat;
	}
	
   

    private static int cerca (int [] vector, int cap, int element) {
        // cerca a vector la posici� on es troba element, comen�ant
        // des de la posici� indicada per cap

        if (cap == vector.length)  // el vector ha quedat exhaurit
            return -1;

        if (vector[cap]==element) // est� al cap
            return cap;
        else return cerca(vector, cap+1, element); // no est� al cap
                                                   // buscar a la cua
    }

    private static int cercaOrdenada (int [] vector, int cap, int element) {
        // cerca a vector la posici� on es troba element, comen�ant
        // des de la posici� indicada per cap. El vector ha d'estar ordenat

        if (cap == vector.length)  // el vector ha quedat exhaurit
            return -1;

        if (vector[cap]==element) // est� al cap
            return cap;

        if (vector[cap] > element) // ens hem "passat"
            return -1;

        return cercaOrdenada(vector, cap+1, element); // potser hi �s.
    }

}
