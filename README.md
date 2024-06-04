# Exemples inicials

```java
public class E01_Factorial {
    public static void main (String [] args) {
        int numeroLlegit, factorial;
        System.out.println("\nFactorial");
        System.out.println("----------\n");
        System.out.print("De quin número en vols calcular el factorial?: ");
        numeroLlegit = Teclat.llegirEnter();
        if (numeroLlegit<0) {
            System.err.println("\nNo és pot calcular el factoria d'un número negatiu");
        }
        else {
            factorial = factorialRec(numeroLlegit);
            System.out.println("\nel factorial de "+numeroLlegit+" és "+factorial);
        }
    }
    private static int factorialRec (int n) {
        if (n==0)
            return 1;
        else
            return n * factorialRec(n-1);
    }
}
```

```java
public class E02_Potencia {
    public static void main (String [] args) {
        int base, exponent, pot;
        System.out.println("\nPotència");
        System.out.println("--------\n");
        System.out.print("base: ");
        base = Teclat.llegirEnter();
        System.out.print("exponent: ");
        exponent = Teclat.llegirEnter();
        System.out.print("\n"+base+" elevat a "+exponent+" = ");
        if (exponent<0) {
            pot = potenciaRec(base, -exponent);
            System.out.println("1/"+pot+" = "+1.0/pot);
        }
        else {
            pot = potenciaRec(base, exponent);
            System.out.println(pot);
        }
    }

    private static int potenciaRec (int a, int b) {
        if (b==0)
            return 1;
        else
            return a * potenciaRec(a, b-1);
    }
}
```

```java
public class E03_Sumar {
    public static void main(String[] args) {
        int a, b;
        System.out.println("\nSumar(recursivament)");
        System.out.println("--------------------\n");
        System.out.print("primer sumand: ");
        a = Teclat.llegirEnter();
        System.out.print("segon sumand: ");
        b = Teclat.llegirEnter();
        if (b < 0) {
            System.err.println("\nEl segon sumand ha de ser positiu");
        } else {
            System.out.println("\n" + a + " + " + b + " = " + sumarRec(a, b));
        }
    }

    private static int sumarRec(int a, int b) {
        if (b == 0)
            return a;
        else
            return sumarRec(a + 1, b - 1);
    }
}
```

```java
public class E04_Fibonacci {
    public static void main(String[] args) {
        int n;
        System.out.println("\nFibonacci");
        System.out.println("---------");
        System.out.print("\nquin terme (n>=0) de la succ de fibonnaci vols calcular? ");
        n = Teclat.llegirEnter();
        if (n < 0) {
            System.out.println("\nTu t'ho has buscat...");
            System.out.print("... prem return per continuar");
            Teclat.llegirCadena();
        }
        System.out.println("\nfib(" + n + ")= " + fibonacciRec(n));
    }

    private static int fibonacciRec(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }
}
```

# Exemple: Les torres de Hanoi

```java
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
```

# Exemples: Seqüències

Cerca sobre vectors (desordenats i ordenats)

```java
private static int cerca(int[] vector, int cap, int element) {
// cerca a vector la posició on es troba element, començant
// des de la posició indicada per cap
    if (cap == vector.length) // el vector ha quedat exhaurit
        return -1;
    if (vector[cap] == element) // està al cap
        return cap;
    else return cerca(vector, cap + 1, element); // no està al cap
// buscar a la cua
}
```

```java
private static int cercaOrdenada(int[] vector,
                                 int cap, int element) {
// cerca a vector la posició on es troba element, començant
// des de la posició indicada per cap. El vector ha d'estar ordenat
    if (cap == vector.length) // el vector ha quedat exhaurit
        return -1;
    if (vector[cap] == element) // està al cap
        return cap;
    if (vector[cap] > element) // ens hem "passat"
        return -1;
    return cercaOrdenada(vector, cap + 1, element); // potser hi és.
}
```

La cerca DICOTÒMICA (sobre vectors ordenats)

```java
private static int cercaDicotomica(int vector[], int element,
                                   int primer, int darrer) {
    int centre;
    if (primer > darrer) // indexs "creuats" = vector exhaurit
        return -1;
    centre = (primer + darrer) / 2;
    if (vector[centre] == element)
        return centre;
    if (vector[centre] < element)
        return cercaDicotomica(v, element, centre + 1, darrer); // dreta
    else
        return cercaDicotomica(v, element, primer, centre - 1); // esquerra
}
```

Quick Sort (Versió espacialment poc eficient)

```java
private static void QuickSort(int[] vector, int mida) {
    int pivot, indexPetit, indexGran, index;
    int[] mesPetits, mesGrans;
    if (mida <= 1) return; // amb un o cap element, ja està ordenat
// triar un element que faci de pivot
    pivot = vector[mida - 1];
// font d'ineficiència espacial: a cada crida es creen
// dos nous vectors de la mateixa mida...
    mesPetits = new int[mida];
    mesGrans = new int[mida];
// repartir
    indexPetit = 0;
    indexGran = 0;
    for (int i = 0; i < mida; i++) {
        if (vector[i] < pivot) {
            mesPetits[indexPetit] = vector[i];
            indexPetit++;
        }
        if (vector[i] > pivot) {
            mesGrans[indexGran] = vector[i];
            indexGran++;
        }
    }
// ordenar els dos fragments
    QuickSort(mesPetits, indexPetit);
    QuickSort(mesGrans, indexGran);
// concatenar
    index = 0;
    for (int i = 0; i < indexPetit; i++) {
        vector[index] = mesPetits[i];
        index++;
    }
    vector[index] = pivot;
    index++;
    for (int i = 0; i < indexGran; i++) {
        vector[index] = mesGrans[i];
        index++;
    }
}

private static void swap(int[] vector, int i, int j) {
    int aux = vector[i];
    vector[i] = vector[j];
    vector[j] = aux;
}
```

Quick Sort (versió sense ineficiència espacial)

```java
private static void QuickSort(int[] vector,
                              int primer, int ultim) {
    int pivot;
    int i, j;
    if (primer >= ultim) return; // vector exhaurit
// triar un element que faci de pivot
    pivot = vector[(primer + ultim) / 2];
// moure tots els elements més petits que el pivot a l'esquerra
// i els més grans a la dreta
    i = primer;
    j = ultim;
    while (i <= j) {
// buscar un element més gran que estigui a l'esquerra
        while (vector[i] < pivot) i++;
// buscar un element més petit que estigui a la dreta
        while (vector[j] > pivot) j--;
// intercanviar-los si cal
        if (i <= j) {
            swap(vector, i, j);
            i++;
            j--;
        }
    }
// ordenar els dos costats
    QuickSort(vector, primer, j);
    QuickSort(vector, i, ultim);
}

private static void swap(int[] v, int i, int j) {
    int aux = vector[i];
    vector[i] = vector[j];
    vector[j] = aux;
}
```

Quick Sort amb List<Comparable> (espacialment ineficient)

```java
private static void quickSort(List<Comparable> llista) {
    Comparable pivot;
    int cmp;
// cas base: una llista buida o amb 1 element segur que està ordenada
    if (llista.size() <= 1) return;
// triar un element que faci de pivot
    pivot = llista.get(llista.size() / 2);
// crear un parell de llistes
    List<Comparable> menor = new LinkedList();
    List<Comparable> major = new LinkedList();
// recórrer la llista original per classificar els elements
// en dues subllistes
    for (Comparable e : llista) {
        cmp = e.compareTo(pivot);
        if (cmp < 0) menor.add(e);
        else if (cmp > 0) major.add(e);
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
```
