import java.util.Arrays;
import java.util.Scanner;

/**
 * Quicksort inklusive verschiedener Varianten und Möglichkeiten das
 * PIVOT-Element zu wählen.
 * <p>
 * Dies ist die Version ohne Lambdas, in diesem Fall erstelle ich aber dennoch
 * ein Objekt (nur um das zu zeigen).
 * <p>
 * Diese Variante enthält einen unnötigen Debug der die Tiefe der Rekursion ausgibt.
 * Andere Varianten können auf Anfrage generiert werden.
 *
 * @author Florian Sihler
 * @version 1.0, 07/05/2020
 */
public class Quicksort {

    public static void main(String[] args) {

        // impliziter Konstruktor! (dies ist kein guter Kommentar)
        Quicksort qs = new Quicksort();

        System.out.println("Gebe ein Array ein. Gewünschte Notation: 1, 2, 3, 4, -12, 42");

        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(",\\s*");
        scanner.close();

        // Wir wandeln das String-Array nun in ein Integer-Array um.
        // Ohne Voodoo:
        int[] arrayToSort = new int[data.length];
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = Integer.parseInt(data[i]);
        }

        // Ich habe mir hier eine eigene Ausgabe des Arrays gespart.
        // Ein exemplarischer Code hierzu ist in den Vorlesungsunterlagen:

        qs.quicksort(arrayToSort, PivotDecision.FIRST_ELEMENT);

        System.out.println(Arrays.toString(arrayToSort));
    }


    /**
     * Sortiert das übergebene Array (schlecht, da: Parameter ist Ausgabeparameter,
     * Seiteneffekte sorgen oft für Probleme!)
     *
     * @param arr Das Array, ist nach Ausführung sortiert.
     * @param decision Die Entscheidung für das Pivot-Element
     */
	public void quicksort(int[] arr, PivotDecision decision) {
		quicksort(arr, 0, arr.length-1, decision, 0);
	}


    // Hilfsfunktionen nach Vorlesung (leicht modifiziert)
    // Übungsaufgabe: reduziere die Parameteranzahl aller Metoden auf 3
    private void quicksort(int[] arr, int start, int end, PivotDecision decision, int recDepth) {
        System.out.println("In Rekursionstiefe: " + recDepth);
        System.out.println("Array: " + Arrays.toString(arr));

        if (start >= end) {
            return; // nothing to sort as markers overlap
        }
        int divider = partition(arr, start, end, decision); // 'hard split'
        System.out.println("Swapped: " + Arrays.toString(arr));

        // Sort sub-parts
        quicksort(arr, start, divider - 1, decision, recDepth + 1);
        quicksort(arr, divider + 1, end, decision, recDepth + 1);
    }


	protected static int partition(int[] arr, int beg, int end, PivotDecision decision) {
        int pivotIndex = PivotDecider.getMeAPivot(arr, beg, end, decision);
        int pivot = arr[pivotIndex];

	    int left  = beg - 1;
	    int right = end;

        // Wichtig: Wir tauschen ja die Pivot-Position
        // an die neue (sortierte) Stelle. Um sie im Folgenden
        // nicht woanders hin zu tauschen
        swap(arr, pivotIndex, end);

		while (left < right) {
			do {
				left++;
			} while (arr[left] < pivot);
			do {
				right--;
			} while (arr[right] >= pivot && left < right);

			if (left < right) {
                swap(arr, left, right);
            }
        }


        // Übungsfrage: Warum ist es deswegen schlecht, hier
        // einfach 'end' zu verwenden?
        swap(arr, left, end);

		return left;
	}

    /**
     * Vertausche zwei Elemente (auch dieser Kommentar ist übrigens nicht notwendig)
     * <p>
     * Wieder problematisch: Seiteneffekte!
     *
     * @param arr Das Array in dem die Elemente getauscht werden sollen
     * @param i1  Erster Index
     * @param i2  Zweiter Index
     *
     * @return Vertauscht die Elemente an den Stellen i1 und i2
     */
    public static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
        // Übungsaufgabe: Versucht es einmal ohne Zwischenspeichervariable
    }

}