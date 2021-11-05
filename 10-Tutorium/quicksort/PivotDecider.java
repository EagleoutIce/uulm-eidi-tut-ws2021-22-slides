import java.util.Arrays;

/**
 * Diese Hilfsklasse enthält nur statische Methoden, welche die verschiedenen
 * Auswahlverfahren enthalten. Keiner dieser Verfahren darf das übergebene Array
 * verändern, deswegen kopieren wir es, falls es nicht anders geht.
 * <p>
 * Keine der Methoden hier prüft, ob start und Ende des Subsegments gültig sind --
 * dies kann zur Übung aber leicht implementiert werden.
 *
 * @author Florian Sihler
 * @version 1.1, 31/12/2020
 */
public class PivotDecider {

    // Da es von dieser Klasse kein Objekt geben soll,
    // sorgen wir dafür, dass es keinen öffentlichen Konstruktor
    // gibt.
    private PivotDecider() {}

    /**
     * Liefert das Pivot-Element nach einem angegebenen Verfahren
     * <p>
     * Hinweis: diese Methode lässt sich in vieeeelerlei Hinsicht schöner gestalten
     *
     * @param arr Das Array aus dem das Element zu wählen ist, wird nie verändert.
     * @param beg Der Beginn des Array-Ausschnitts
     * @param end Das Ende des Array-Ausschnitts
     * @param decision Das Verfahren nach dem das PivotElement zu wählen ist.
     *
     * @return Der Index an dem sich das Pivot-Element in arr befindet.
     */
    public static int getMeAPivot(int[] arr, int beg, int end, PivotDecision decision) {
        switch (decision) {
            case MEDIAN_OF_THREE:
                return getMedianOfThree(arr, beg, end);
            case CALCULATE_CORRECT:
                return getCorrectMedian(arr, beg, end);
            case QUICKSELECT:
                return getWithQuickSelect(arr, beg, end);
            case FIRST_ELEMENT:
                return beg;
            case LAST_ELEMENT:
                return end;
            default:
            case MIDDLE_ELEMENT:
                return getMiddleElement(beg, end);
        }
    }


    protected static int getMiddleElement(int beg, int end) {
        return beg + (end - beg)/2;
    }

    protected static int getMedianOfThree(int[] arr, int beg, int end) {
        int mid = getMiddleElement(beg, end);
        int a = arr[beg];
        int b = arr[mid];
        int c = arr[end];
        // a > b XOR a > c. a ist genau größer wie eines der beiden Anderen
        if ((a > b) != (a > c)) {
            return beg;
        }
        // Analog für b
        else if ((b > a) != (b > c)) {
            return mid;
        }
        // Sonst muss es für c stimmen
        else {
            return end;
        }
    }

    protected static int getCorrectMedian(int[] arr, int beg, int end) {
        // Hier berechnen wir den richtigen Median. Ich werde
        // ihr einfach Arrays.sort verwenden. Aber hier kann jedes
        // Sortierverfahren verwendet werden (wenn die Komplexität egal ist)
        // Um sicherzugehen, dass es das Array nicht verändert,
        // kopieren wir es.
        int[] newArray = copyArray(arr);
        // sortiert zwischen beg und end
        Arrays.sort(newArray, beg, end);

        // da wir den Index benötigen, ist der Median nie eine Kommazahl
        int medianValue = newArray[getMiddleElement(beg, end)];

        // nun brauchen wir den Index des median-Wertes im unsortierten Array (Ausschnitt)
        // da hier die Effizienz egal ist, suchen wir es einfach mal linear

        return linearSearch(arr, beg, end, medianValue);
    }

    protected static int getWithQuickSelect(int[] arr, int beg, int end) {

        // Das Element, das wir Suchen, liegt am Ende in der Mitte
        int kMin = getMiddleElement(beg, end);

        // Funktioniert an sich wie quick-sort
        int[] newArray = copyArray(arr);

        // Wir partitionieren, lustigerweise brauchen wir hierfür wieder eine Strategie.
        // Alles außer dieser hier ist ok
        int elem = getWithQuickSelectHelper(newArray, beg, end, kMin);

        // Jetzt können wir wieder den Wert dieses Elements im alten
        // Ausschnitt suchen
        return linearSearch(arr, beg, end, elem);
    }

    private static int getWithQuickSelectHelper(int[] arr, int beg, int end, int searchIdx) {
        // Wir partitionieren, lustigerweise brauchen wir hierfür wieder eine Strategie.
        // Alles außer dieser hier ist ok
        int divider = Quicksort.partition(arr, beg, end, PivotDecision.MIDDLE_ELEMENT);


        if(divider == searchIdx) {
            return arr[divider];
        }


        // wenn die Position des Pivots größer ist als die Gesuchte, suchen
        // wir in der "unteren" Hälfte weiter:
        if(divider > searchIdx) {
            return getWithQuickSelectHelper(arr, beg, divider - 1, searchIdx);
        }
        // sonst: wenn die Position des Pivots kleiner ist als die Gesuchte, suchen
        // wir in der "oberen" Hälfte weiter:
        else {
            return getWithQuickSelectHelper(arr, divider + 1, end, searchIdx);
        }


    }


    public static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = arr[i];
        }

        // Arrays.copyOf, System.arraycopy, ...
        return copy;
    }

    // Liefert den Index per linearer Suche
    private static int linearSearch(int[] arr, int beg, int end, int val) {
        for (int i = beg; i <= end; i++) {
            if(arr[i] == val) { // wenn es mehrere gibt, ist dies egal
                return i;
            }
        }
        return -1; // Dies ist der Fehlerfall der per Definition nicht auftreten soll
        // Hier würde man eine exception werfen
    }

}