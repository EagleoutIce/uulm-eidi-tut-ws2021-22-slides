/**
 * Diese Enumeration erlaubt uns das Verfahren bei der Konstruktion des Objekts
 * auszuwählen. Die Vor- und Nachteile des Ansatzes werden im Tutorium
 * diskutiert.
 *
 * @author Florian Sihler
 * @version 1.1, 31/12/2020
 */
public enum PivotDecision {
    /**
     * Nicht zwangsläufig der Median. Verbessert aber den Fall einer bereits
     * sortierten Liste
     */
    MIDDLE_ELEMENT,
    /**
     * Der richtige Median ist für Quicksort der beste Fall, die Berechnung macht
     * das Verfahren aber wieder ineffizient.
     */
    CALCULATE_CORRECT,
    /**
     * Sucht den Median mithilfe eines schnellen Quicksort-Ansatz für das k-kleinste
     * Element.
     */
    QUICKSELECT,
    /**
     * Berechnet das Mittlere aus drei Elementen (kann weiter Optimiert werden z.B. wenn
     * die Sortierung bereits im Array erfolgt)
     */
    MEDIAN_OF_THREE,
    /**
     * Nimmt immer das erste Element
     */
    FIRST_ELEMENT,
    /**
     * Nimmt immer das letzte Element
     */
    LAST_ELEMENT
}