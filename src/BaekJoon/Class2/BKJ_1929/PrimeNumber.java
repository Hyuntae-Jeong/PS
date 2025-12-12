package BaekJoon.Class2.BKJ_1929;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static boolean[] isNotPrimeNumber;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        isNotPrimeNumber = new boolean[M + 1];
        filterPrimeNumber();
        printPrimeNumber();
    }

    static void filterPrimeNumber() {
        isNotPrimeNumber[1] = true;

        for (int i = 2; i <= M; i++) {
            if (!isNotPrimeNumber[i]) {
                int j = i + i;
                while (j <= M) {
                    isNotPrimeNumber[j] = true;
                    j += i;
                }
            }
        }
    }

    static void printPrimeNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = N; i <= M; i++) {
            if (!isNotPrimeNumber[i]) sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}

public class PrimeNumber {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon/Class2/BKJ_1929/input.txt"));
        Main.main(args);
    }
}
