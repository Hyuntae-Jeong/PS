package BKJ_1932;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static boolean debug = false;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        getInput();
        if (debug) printInput();
        startProcess();
        if (debug) printInput();
    }

    static int[][] triangle;
    static void getInput() throws IOException {
        triangle = new int[N][N + 1];
        StringTokenizer token;

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i + 1; j++) {
                triangle[i][j] = Integer.parseInt(token.nextToken());
            }
        }
    }

    static void startProcess() {
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= i + 1; j++) {
                triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]) + triangle[i][j];
            }
        }

        int maxValue = 0;
        for (int j = 1; j <= N; j++) {
            maxValue = Math.max(maxValue, triangle[N - 1][j]);
        }

        System.out.print(maxValue);
    }

    static void printInput() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i + 1; j++) {
                System.out.printf("%d\t", triangle[i][j]);
            }
            System.out.println();
        }
    }

}

public class IntegerTriangle {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BKJ_1932/input.txt"));
        Main.main(args);
    }
}
