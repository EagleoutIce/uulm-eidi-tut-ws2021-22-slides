public class Knapsack {
    public static List knapsack(int capacity, int[] values, int[] weights) {
        if (capacity < 0)
            throw new IllegalArgumentException("Negative capacity");
        if(values.length != weights.length)
            throw new IllegalArgumentException("Array lengths differ");
        return knapsack(capacity, 0, values, weights);
    }

    private static List knapsack(int capacity, int index, int[] values, int[] weights) {
        if(index >= values.length)
            return new List();
        // W < w_i
        if(capacity < weights[index])
            return knapsack(capacity, index + 1, values, weights);
        List withItem = knapsack(capacity - weights[index], index + 1, values, weights).push(index);
        List withoutItem = knapsack(capacity, index + 1, values, weights);

        int valueWithItem = getValueOfList(withItem, values);
        int valueWithoutItem = getValueOfList(withoutItem, values);

        return valueWithItem > valueWithoutItem ? withItem : withoutItem;
    }

    private static int getValueOfList(List list, int[] values) {
        int sum = 0;
        for(int i = 0; i < list.length; i++) {
            sum += values[list.getByIndex(i)];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(knapsack(6, new int[]{7, 3, 9, 12, 1}, new int[]{5, 4, 3, 2, 1}));
    }
}