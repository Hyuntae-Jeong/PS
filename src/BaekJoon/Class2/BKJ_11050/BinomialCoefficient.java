package BaekJoon.Class2.BKJ_11050;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, smallC, bigC;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        int a = Integer.parseInt(token.nextToken());
        int b = N - a;

        smallC = Integer.min(a, b);
        bigC = Integer.max(a, b);

        getBinomialCoefficient();
    }

    public static void getBinomialCoefficient() {
        int total = 1;

        /*   ___5!___
             3! * 2!   */

        // 5! / 3! = 5 * 4 calculation
        while (N > bigC) {
            total *= N;
            N--;
        }

        // divide by 2! calculation
        while (smallC > 0) {
            total /= smallC;
            smallC--;
        }

        System.out.println(total);
    }
}

public class BinomialCoefficient {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/BaekJoon.Class2.BKJ_11050/input.txt"));
        Main.main(args);
    }
}
