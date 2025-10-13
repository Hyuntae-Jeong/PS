package BKJ_9465;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int TC;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            getInput();
            sb.append(Math.max(dp[0][N + 1], dp[1][N + 1])).append("\n");
        }
        System.out.print(sb);
    }

    static int[][] sticker, dp;
    static StringTokenizer firstRow;
    static StringTokenizer secondRow;
    static int firstNumber, secondNumber;

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        sticker = new int[2][N + 1];
        dp = new int[2][N+3];

        firstRow = new StringTokenizer(br.readLine());
        secondRow = new StringTokenizer(br.readLine());

        for (int j = 2; j < N + 2; j++) {
            firstNumber = Integer.parseInt(firstRow.nextToken());
            secondNumber = Integer.parseInt(secondRow.nextToken());

            dp[0][j] = Math.max(Math.max(dp[0][j - 2], dp[1][j - 2]), dp[1][j - 1]) + firstNumber;
            dp[1][j] = Math.max(Math.max(dp[0][j - 2], dp[1][j - 2]), dp[0][j - 1]) + secondNumber;
        }
    }
}

public class Sticker {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_9465/input.txt"));
        Main.main(args);
    }
}
