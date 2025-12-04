package BaekJoon.Skeleton;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        getInput();
    }

    static int[][] inputArray;
    static StringTokenizer token;

    static void getInput() throws IOException {
        inputArray = new int[2][N + 1];
        token = new StringTokenizer(br.readLine());

        for (int j = 0; j < N; j++) {
            int firstNumber = Integer.parseInt(token.nextToken());
            inputArray[0][j] = firstNumber;
        }
    }
}

public class Skeleton {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BOJ_Skeleton/input.txt"));
        Main.main(args);
    }

    /* using local package */
    // System.setIn(new FileInputStream("src/.../input.txt"));

    /* input */
    // String tokenizer = tokenize(br.readLine());

    /* output */
    // StringBuilder sb = new StringBuilder();
    // System.out.println(sb);
}
