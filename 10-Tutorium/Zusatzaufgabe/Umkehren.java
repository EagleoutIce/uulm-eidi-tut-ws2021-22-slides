class Umkehren {

	/**
	 * kehrt die Reihenfolge der Eintraege in arr[0..i] um (von Index 0 bis einschl.
	 * i)
	 **/
	static void reverse(int[] arr, int i) {
		for (int begin = 0; begin < i; begin += 1, i -= 1) {
			swap(arr, i, begin);
		}
	}

	private static void swap(int[] arr, int i, int begin) {
		final int tmp = arr[begin];
		arr[begin] = arr[i];
		arr[i] = tmp;
	}

	/*
	 * Returns index of the maximum element in arr[0..n-1]
	 */
	static int findMax(int[] arr, int n) {
		int maxIndex = 0;
		for (int i = 1; i < n; i += 1) {
			if (arr[i] > arr[maxIndex])
				maxIndex = i;
		}
		return maxIndex;
	}

	static void sort(int[] arr, int n) {
		// Start from the complete
		// array and one by one
		// reduce current size by one
		for (int currSize = n; currSize > 1; currSize -= 1) {
			// Find index of the
			// maximum element in
			// arr[0..curr_size-1]
			int maxIndex = findMax(arr, currSize);

			// Move the maximum element
			// to end of current array
			// if it's not already at
			// the end
			if (maxIndex != currSize - 1) {
				// To move at the end,
				// first move maximum
				// number to beginning
				reverse(arr, maxIndex);

				// Now move the maximum
				// number to end by
				// reversing current array
				reverse(arr, currSize - 1);
			}
		}
	}

	// zum Testen
	public static void main(String[] args) {
		int[] arr = { 13, 20, 24, 1, 125, 46, 17 };
		int n = arr.length;

		sort(arr, n);

		System.out.println("Sortiertes Array: ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}
