public class Sum {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,2,4,6,8,12,22,21};
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++) {
                for(int k = j+1; k < arr.length; k++) {
                    int summe = arr[i] + arr[j] + arr[k];
                    System.out.format("%d + %d + %d = %d%n", arr[i],
                            arr[j], arr[k], summe);
                }
            }
        }
    }
}
