package p03_ExemplesSequencies;

import eines.Teclat;

public class ComptarVocals {
	
	
	public static void main (String [] args) {
		String unaCadena;
		int vocals;
		
		System.out.println("\nComptar les vocals");
		System.out.println("------------------\n");
		
		System.out.print("Escriu una frase: ");
		unaCadena = Teclat.llegirCadena();
		
		vocals = comptarLesVocals_01(unaCadena);
		System.out.println("\nLa frase \""+unaCadena+"\" t� "+vocals+" vocals");
		
		vocals = comptarLesVocals_02(unaCadena, 0);
		System.out.println("s�, s�, "+vocals+" vocals");
		
	}
	
	public static int comptarLesVocals_01 (String seq) {
		if (seq.length()==0) return 0;
		
		char cap = seq.charAt(0);
		String cua = seq.substring(1);
		
		if (esVocal(cap)) {
			return 1 + comptarLesVocals_01(cua);
		}
		else {
			return comptarLesVocals_01(cua);
		}
	}
	
	
	public static int comptarLesVocals_02(String seq, int posCap) {
		if (posCap == seq.length()) return 0;
		
		char cap = seq.charAt(posCap);
		
		if (esVocal(cap)) {
			return 1 + comptarLesVocals_02(seq, posCap+1);
		}
		else {
			return comptarLesVocals_02(seq, posCap+1);
		}
	}
	
	
	private static boolean esVocal (char c) {
		return c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
		     ||c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
	}

}
