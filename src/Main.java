
import java.util.Arrays;

class Runner {
    static long[] arr = new long[100];

    static long COUNT = 0;

    public static void main(String[] args) {
        Arrays.fill(arr, 0, arr.length - 1, -1);

        //   На основе кода из гитхаба сравнить производительность разных способов вычисления n-ого члена ряда Фибоначчи.
        //    Добавить счетчики количества итераций
        //  Добавить замеры времени вызова в мс (resultTime / 1000000)
        //   Протестировать на входных значениях 5, 10, 25, 50 каждый из методов
        //  Выполнение кода с тестами может занимать 5-7 минут, это нормально, если будет больше 10, вряд ли есть смысл продолжать, нужно будет уменьшить вернюю границу на 5 и уменьшать до тех пор, пока не будет более-менее адекватное время (в пределах 5 минут на все тесты для 50)

        System.out.println("Test fib");
        testFib(arr, 5);
        testFib(arr, 10);
        testFib(arr, 20);
        testFib(arr, 50);

        System.out.println("Test fibTab");
        testfibTab(arr, 5);
        testfibTab(arr, 10);
        testfibTab(arr, 20);
        testfibTab(arr, 50);

        System.out.println("Testing fibMemo");
        testFibMemo(arr, 5);
        testFibMemo(arr, 10);
        testFibMemo(arr, 20);
        testFibMemo(arr, 50);
    }


    public static void testFib(long[] arr, int... ns) {
        for (int n : ns) {
            COUNT = 0;

            long start = System.currentTimeMillis();
            long value = fib(n);
            long stop = System.currentTimeMillis();

            System.out.printf("numbers(%d) = %d, count=%d, timeMs=%d\n", n, value, COUNT, stop - start);
        }
    }

    public static void testfibTab(long[] arr, int... ns) {
        for (int n : ns) {
            COUNT = 0;

            long start = System.currentTimeMillis();
            long value = fibTab(n);
            long stop = System.currentTimeMillis();

            System.out.printf("numbers(%d) = %d, count=%d, timeMs=%d\n", n, value, COUNT, stop - start);
        }
    }

    public static void testFibMemo(long[] arr, int... ns) {
        for (int n : ns) {
            COUNT = 0;

            long start = System.currentTimeMillis();
            long value = fibMemo(n);
            long stop = System.currentTimeMillis();

            System.out.printf("numbers(%d) = %d, count=%d, timeMs=%d\n", n, value, COUNT, stop - start);
        }
    }

    public static long fib(int n) {
        COUNT++;

        if (n < 2) {
            return 1;
        }
        // System.out.println(COUNT);
        return fib(n - 1) + fib(n - 2);

    }

    public static long fibTab(int n) {
        if (n < 2) {
            return 1;
        }

        long[] arr2 = new long[n + 1];
        arr2[0] = 1;
        arr2[1] = 1;

        for (int i = 2; i <= n; i++) {
            COUNT++;

            arr2[i] = arr2[i - 1] + arr2[i - 2];
        }

        return arr2[n];
    }

    public static long fibMemo(int n) {
        COUNT++;

        if (arr[n] != -1) {
            return arr[n];
        }
        if (n < 2) {
            return 1;
        }

        arr[n] = fibMemo(n - 1) + fibMemo(n - 2);
        //  System.out.println(COUNT);
        return arr[n];
    }
}


