import java.util.Objects;

/**
 * Hier testen wir die Quicksort Implementation.
 * Eigentlich würde man das auf mehrere Dateien aufteilen (für das Pivot getrennt)
 * Aber für diesen einfachen Fall hier gruppiere ich das.
 *
 * Hier ohne Junit sondern mit exceptions; Mehr dazu im Junit-Test-Teil
 */
public class QuicksortTest {

    private void expectEquals(Object expected, Object got, String message) {
        if(!Objects.equals(expected, got)) {
            // Hier würde man eigentlich eine eigene Exception machen
            throw new RuntimeException(message + "\nBut was: " + got + " when expected: " + expected);
        }
    }

    // Hier lässt sich viel machen, zur Übung gilt es die Randfälle für alle anderen
    // Verfahren auch zu testen
    public void testPivotSelectionMiddle() {

        expectEquals(1, PivotDecider.getMiddleElement(0, 2), "Should be as expected: 1 for (0,2) on middle.");

    }

    public static void main(String[] args) {
        // Hier können wir mal exemplarisch alle durchlaufen lassen

        QuicksortTest qt = new QuicksortTest();
        qt.testPivotSelectionMiddle();
    }


}