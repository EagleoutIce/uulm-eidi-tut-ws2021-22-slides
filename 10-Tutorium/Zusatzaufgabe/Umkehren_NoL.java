import java.io.*;

class Umkehren {

	/* kehrt die Reihenfolge der Eintraege in arr[0..i] um (von Index 0 bis einschl. i) */
	static void reverse(int [] arr, int i)	{
		int tmp, begin = 0;
		while (begin < i)
		{
			tmp = arr[begin];
			arr[begin] = arr[i];
			arr[i] = tmp;
			begin++;
			i--;
		}
	}


	// To Do: Sortiermethode, die das Array in-place sortiert
	// mit Hilfe der reverse-Methode
	// @param arr: zu sortierendes array
	// @param n: Länge des Arrays (arr.length)
	static void sort(int [] arr, int n)	{
		// To Do
	}



	// zum Testen
	public static void main (String[] args) {
		int [] arr = {13, 20, 24, 1, 125, 46, 17};
		int len = arr.length;

		sort(arr, len);

		System.out.println("Sortiertes Array: ");
		for (int i = 0; i < len; i++) {
        		System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}
