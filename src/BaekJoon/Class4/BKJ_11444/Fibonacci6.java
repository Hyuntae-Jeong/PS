package BaekJoon.Class4.BKJ_11444;

import java.io.*;
import java.util.HashMap;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<Long, Long> savedFibo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        savedFibo.put(0L, 0L);
        savedFibo.put(1L, 1L);
        savedFibo.put(2L, 1L);

        long answer = fibo(Long.parseLong(br.readLine()));
        System.out.println(answer);
    }

    static long fibo(long n) {
        if (savedFibo.containsKey(n)) return savedFibo.get(n);

        long half = n / 2;
        long halfUp = (n + 1) / 2;

        savedFibo.put(n, (fibo(halfUp) * fibo(n + 1 - halfUp) + fibo(half) * fibo(n - 1 - half)) % 1_000_000_007);
        return savedFibo.get(n);
    }
}
/**
 * f(0) = 0
 * f(1) = 1
 * f(2) = 1
 * f(3) = f(2) + f(1) = {f(1) + f(0)} + f(1) = 2f(1) + f(0) = f(2)f(1) + f(2)f(0)
 * f(4) = f(3) + f(2) = {f(2) + f(1)} + f(2) = 2f(2) + f(1) = f(3)f(2) + f(2)f(1)
 * f(5) = f(4) + f(3) = {f(3) + f(2)} + f(3) = 2f(3) + f(2) = f(3)f(3) = f(2)f(2)
 *
 * f(6) = f(5) + f(4) = f(2)f(5) + f(1)f(4)
 *      = 2f(4) + f(3) = f(3)f(4) + f(2)f(3)
 *      = 3f(3) + 2f(2) = f(4)f(3) + f(3)f(2)
 *      ...
 *
 * f(7) = f(6) + f(5) = f(2)f(6) + f(1)f(5)
 *      = 2f(5) + f(4) = f(3)f(5) + f(2)f(4)
 *      = 3f(4) + 2f(3) = f(4)f(4) + f(3)f(3)
 *      = 5f(3) + 3f(2) = f(5)f(3) + f(4)f(2)
 *      ...               -> 5+3 = 8   -> 4+2 = 6
 *                        ->     = 7 + 1      = 7 - 1
 *
 * f(8) = f(7) + f(6) = f(2)f(7) + f(1)f(6)
 *      = 2f(6) + f(5) = f(3)f(6) + f(2)f(5)
 *      = 3f(5) + 2f(4) = f(4)f(5) + f(3)f(4)
 *      = 5f(4) + 3f(3) = f(5)f(4) + f(4)f(3)
 *      = 8f(3) + 5f(2) = f(6)f(3) + f(5)f(2)
 *      ...              -> 6+3 = 9    -> 5+2 = 7
 *                       ->     = 8 + 1       = 8 - 1
 *
 *
 * f(n) = f(n/2)f(n+1 - n/2) + f((n+1)/2)f(n-1 - (n+1)/2)
 * => 이 공식은 n이 홀수이던, 짝수이던 모두 적용이 되는 공식이다
 *
 */

public class Fibonacci6 {
}
