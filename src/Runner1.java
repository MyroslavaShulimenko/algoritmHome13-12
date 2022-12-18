import java.util.Arrays;

public class Runner1 {

    static long[] arr;

    public static void main(String[] args) {
        (new Thread(() -> {
            try {
                Thread.sleep(20_000);
                System.out.println("Over 20 seconds!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        })).start();

        //System.out.println(fib(48));

        int n = 49;

        arr = new long[n + 1];

        /*for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }*/

        System.out.println(fibTab(n));
    }

    public static long fib(int n) {
        if (n < 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static long fibTab(int n) {
        long[] arr2 = new long[n];
        arr2[0] = 1;
        arr2[1] = 1;

        for (int i = 2; i < n; i++) {
            arr2[i] = arr2[i - 1] + arr2[i - 2];
        }
        return arr2[n - 1];
    }

    public static long fibMemo(int n) {
        //System.out.println(Arrays.toString(arr));
        if (arr[n] != -1) {
            return arr[n];
        }

        if (n < 2) {
            return 1;
        }

        arr[n] = fibMemo(n - 1) + fibMemo(n - 2);
        return arr[n];
    }
}