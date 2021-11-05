public class AlgorithmA {
  public static int bFind(int toFind, int[] array) {
    int left = 0;
    int right = array.length - 1;

    while(left <= right) {
      int mid = (left + right) / 2;
      if (array[mid] == toFind) {
        return mid;
      } else if(toFind < array[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
