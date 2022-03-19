package Fibonacci;

public class Fibonacci {
    public int Fib_Improved(int n) {
        int fib_i = 0;
        int fib_j = 1;
        int fib_curr = -1;
         for (int i = 2; i <= n; i++) {
            fib_curr = fib_i + fib_j;
            fib_i = fib_j;
            fib_j = fib_curr;
        }

        return fib_curr;
    }

    public static void main(String[] args) {
        int n = 20;
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.Fib_Improved(n));

    }
}
