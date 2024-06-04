package eines;

import java.util.LinkedList;
import java.util.List;

public class EinesJoan {
    static String liniaDecoracio = "-".repeat(40);

    public static void mostraVector(String[] vectorAMostrar, String nomVector) {
        String cadenaTitol = "\tContingut de " + nomVector;
        System.out.println(cadenaTitol);
        for (int i = 0; i < vectorAMostrar.length; i++) {
            System.out.print(vectorAMostrar[i]);
            if (i < vectorAMostrar.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n\t" + liniaDecoracio);
    }

    public static void mostraObject(Object colleccioAMostrar, String nomColleccio) {
        String cadenaToString = colleccioAMostrar.toString();
        String cadenesAEliminar[] = {"Element", "], ", "]]"};
        String cadenaTitol = "\tContingut de " + nomColleccio;
        System.out.println(cadenaTitol);
        System.out.println("\t" + liniaDecoracio);
        for (int i = 0; i < cadenesAEliminar.length; i++) {
            cadenaToString = cadenaToString.replace(cadenesAEliminar[i], "");
        }
        String[] trossosCadenaToString = cadenaToString.split("\\[");
        String[] elements;
        String cadena = "";

        for (int i = 2; i < trossosCadenaToString.length; i++) {
            elements = trossosCadenaToString[i].split(" ");
            cadena += "[" + elements[0] + "," + elements[1] + "] ";
        }
        System.out.println(cadena);
        System.out.println("\t" + liniaDecoracio);
    }



    public static void mostraLinkedListCriatures(LinkedList collecioRebuda, String nomColleccio){
        String cadenaTitol = "\tContingut de " + nomColleccio;
        System.out.println(cadenaTitol);
        for (int i = 0; i < collecioRebuda.size(); i++) {
            System.out.println(collecioRebuda.get(i).toString());
//            System.out.format("Nom: %s\t%sEdat: %d\tSexe: %d.\n",
//                    collecioRebuda.get(i).toString(),
//                    (collecioRebuda.get(i).getNom().length()<7)?"\t":"",
//                    collecioRebuda.get(i).getEdat(),
//                    collecioRebuda.get(i).getSexe());
        }
        System.out.println("\t"+ liniaDecoracio);
    }
    public static void mostraListCriatures(
            List colleccioAMostrar, String nomColleccio) {
        final int ELEMENTS_PER_FILA = 4;
        String saltaSeguentLinia = "";
        String cadenaTitol = "\tContingut de " + nomColleccio;
        System.out.println(cadenaTitol);
        System.out.println("\t"+ liniaDecoracio);
        if(colleccioAMostrar.size() > ELEMENTS_PER_FILA){
            saltaSeguentLinia = "\n";
        }
        String cadenaToString = colleccioAMostrar.toString();
        String campsAEsborrar[] = {"[", "Criatura de nom: ", ".]"};
        String campsRegistre[] = {" té ", " anys. Sexe: "};
        for (int i = 0; i < campsAEsborrar.length; i++) {
            cadenaToString = cadenaToString.replace(campsAEsborrar[i], "");
        }
        for (int i = 0; i < campsRegistre.length; i++) {
            cadenaToString = cadenaToString.replace(campsRegistre[i], "#");
        }
        cadenaToString = cadenaToString.replace("., ", "|");
        String[] registres = cadenaToString.split("(\\|)");
        String cadena = "";
        String[] camps;

        for (int i = 0; i < registres.length; i++) {
            camps = registres[i].split("#");
            cadena += "(" + camps[0] + "," + camps[1] + "," + camps[2] + ")";
            if (i < registres.length - 1) {
                cadena += ", ";
            }
            if ( (i+1) % (ELEMENTS_PER_FILA) == 0)  {
                cadena += saltaSeguentLinia;
            }
        }
        System.out.println(cadena);
        System.out.println("\t"+ liniaDecoracio);
    }


    public static void pintaIniciPrograma(String nomAplicacio) {
        pintaComTitol("\tExecució del programa " + nomAplicacio + "!");
    }

    public static void pintaFinalPrograma(String nomAplicacio){
        pintaComTitol("\tEl programa '" + nomAplicacio + "' s'ha acabat!");
        pintaComiat();
    }
    public static void pintaComiat(){
        System.out.println("\tFins la propera !!!!!");
        System.out.println("\t"+ liniaDecoracio);
    }

    public static void pintaPartAcabada(int partAcabada){
        System.out.println("\t ======== " + partAcabada + "a Part acabada! ======== \n");
        pitjaTeclaPerContinuar();
    }

    public static void pintaExecucioComanda(String comanda) {
        System.out.println("===>  Execució de la comanda:");
        System.out.println(comanda);
        System.out.println("\t"+ liniaDecoracio);

    }
    public static void pintaLiniaSotaTitol(String titol){
        System.out.println("-".repeat(titol.length()));
    }

public static void pintaComSubTitolSenseSubratllar(String subTitol){
        System.out.println(subTitol);
    }

    public static void pintaComSubTitol(String subTitol){
        System.out.println(subTitol);
        System.out.println("-".repeat(subTitol.length()));
    }
    
    public static void pintaComTitol(String titol){
        System.out.println(titol);
        pintaLiniaSotaTitol(titol);
    }

    public static void saltDeLinia(){
        System.out.println();
    }

    public static void saltaLinies(int quantitatDeSalts){
        for (int i = 0; i < quantitatDeSalts; i++)
            saltDeLinia();
    }

    public static void pitjaTeclaPerContinuar(String...  missatgesRebuts){
        if (missatgesRebuts.length == 0)
            System.out.print("\tPitja INTRO per continuar...");
        else
            System.out.print(missatgesRebuts[0]);
        try { System.in.read();
        }
        catch(Exception e) {}
    }
}
