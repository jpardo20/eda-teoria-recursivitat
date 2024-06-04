package eines;

import java.io.*;

// eda-06-presentacio-streams

public class Teclat {
    // Canal d'entrada construït a partir
    // de l'entrada Standard(System.in)
    private static final BufferedReader buReCanal =
            new BufferedReader(
                    new InputStreamReader(System.in));

    // Mètode per llegir una cadena String fins al
    // final de la línia CR/LF
    public static String llegirCadena() {
        try {
            // llegir del canal i retornar el
            // resultat sense processar perquè
            // readline() ja retorna un String
            return buReCanal.readLine();
        } catch (IOException e) { // si hi ha
            // problemes amb la lectura o amb el canal...
            System.out.printf(e.getMessage()); // mostrar excepció
            System.exit(0); // aturar la màquina virtual
            return String.valueOf((0)); // Línia inaccessible
        }
    }

    // Mètode per llegir un enter de mida int
    public static int llegirEnterCtrl() {
        int enterATornar = -1;
            try {
                String cadena = buReCanal.readLine();
                // Llegir una línia del canal
                if (cadena.isEmpty()) {   // si la línia és buida
                    System.out.printf("No has entrat res!!");
                } else {
                    try {  // convertir a int
                        enterATornar = Integer.parseInt(cadena);
                    } catch (Exception ex1) { // si a la conversió ha anat malament
                        // o ha fallat la conversió
                        // System.out.printf(e.getMessage()); // mostrar excepció
                        System.out.printf("\n\tERROR!\tCal entrar un enter!\n");
                        // System.exit(0); // aturar la màquina virtual
                        // return(0); // Línia de codi inaccessible.
                    }
                }
                // return Integer.parseInt(cadena); // convertir a int
            } catch (IOException ex2) { // si a la lectura ha anat malament
                // o ha fallat la conversió
                // System.out.printf(e.getMessage()); // mostrar excepció
                System.out.printf("\n\tERROR!\t2Cal entrar un enter!\n");
                // System.exit(0); // aturar la màquina virtual
                // return(0); // Línia de codi inaccessible.
            }
       return enterATornar;
    }

    // Mètode per llegir un enter de mida int
    public static int llegirEnter() {
        try {
            String cadena = buReCanal.readLine();
            // Llegir una línia del canal
            if (cadena.isEmpty())   // si la línia és buida
                return llegirEnter();   // insistir
            else
                return Integer.parseInt(cadena); // convertir a int
        } catch (IOException e) { // si a la lectura ha anat malament
            // o ha fallat la conversió
            System.out.printf(e.getMessage()); // mostrar excepció
            System.exit(0); // aturar la màquina virtual
            return(0); // Línia de codi inaccessible
        }
    }

    // Mètode per llegir un enter de mida double
    public static double llegirDouble() {
        try {
            String cadena = buReCanal.readLine();
            // Llegir una línia del canal
            if (cadena.isEmpty())   // si la línia és buida
                return llegirEnter();   // insistir
            else
                return Double.parseDouble(cadena); // convertir a int
        } catch (IOException e) { // si a la lectura ha anat malament
            // o ha fallat la conversió
            System.out.printf(e.getMessage()); // mostrar excepció
            System.exit(0); // aturar la màquina virtual
            return(0); // Línia de codi inaccessible
        }
    }

    // Mètode per llegir un enter de mida double
    public static long llegirLong() {
        try {
            String cadena = buReCanal.readLine();
            // Llegir una línia del canal
            if (cadena.isEmpty())   // si la línia és buida
                return llegirEnter();   // insistir
            else
                return Long.parseLong(cadena); // convertir a int
        } catch (IOException e) { // si a la lectura ha anat malament
            // o ha fallat la conversió
            System.out.printf(e.getMessage()); // mostrar excepció
            System.exit(0); // aturar la màquina virtual
            return(0); // Línia de codi inaccessible
        }
    }

    public static char llegirCaracter() {
        try {
            String canal = buReCanal.readLine();
            return canal.isEmpty() ? llegirCaracter() : canal.charAt(0);
        } catch (Exception excepcio) {
            System.out.println(excepcio.getMessage());
            System.exit(0);
            return 'a';
        }
    }
}