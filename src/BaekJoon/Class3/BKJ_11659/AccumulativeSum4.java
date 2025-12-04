package BaekJoon.Class3.BKJ_11659;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] accSum;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        accSum = new int[N + 1];
        getInput();
        startProcess();

    }

    static void getInput() throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());

        accSum[1] = Integer.parseInt(token.nextToken());
        for (int i = 2; i <= N; i++) {
            accSum[i] = accSum[i - 1] + Integer.parseInt(token.nextToken());
        }
    }

    static void startProcess() throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            sb.append((-1 * accSum[Integer.parseInt(token.nextToken()) - 1]) + accSum[Integer.parseInt(token.nextToken())]).append("\n");
        }

        System.out.println(sb);
    }
}

public class AccumulativeSum4 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class3.BKJ_11659/input.txt"));
        Main.main(args);
    }
}
