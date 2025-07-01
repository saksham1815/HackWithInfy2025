import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        int a[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        double maxValue = fractionalKnapsack(a, capacity);
        System.out.println(maxValue);
        sc.close();

    }

    public static double fractionalKnapsack(int a[][], int capacity) {
        Arrays.sort(a, (x, y) -> Double.compare((double) y[0] / y[1], (double) x[0] / x[1]));
        double totalValue = 0;
        for (int i = 0; i < a.length; i++) {
            if (capacity == 0) {
                break;
            }
            if (a[i][1] <= capacity) {
                totalValue += a[i][0];
                capacity -= a[i][1];
            } else {
                totalValue += (int) ((double) a[i][0] * capacity / a[i][1]);
                capacity = 0;
            }
        }
        return totalValue;

    }
}