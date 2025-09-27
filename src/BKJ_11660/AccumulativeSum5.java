package BKJ_11660;


import java.io.*;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] chart;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        chart = new int[N + 1][N + 1];
        getInput();
        startProcess();
    }

    static void getInput() throws IOException {
        // accumulative as getting input
        for (int i = 1; i <= N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                chart[i][j] = chart[i][j - 1] + Integer.parseInt(token.nextToken());
            }
        }
    }

    static void startProcess() throws IOException {
        int x1, x2, y1, y2;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(token.nextToken());
            y1 = Integer.parseInt(token.nextToken());
            x2 = Integer.parseInt(token.nextToken());
            y2 = Integer.parseInt(token.nextToken());

            int sum = 0;
            for (int j = x1; j <= x2; j++) {
                sum += chart[j][y2] - chart[j][y1 - 1];
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}

public class AccumulativeSum5 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_11660/input.txt"));
        Main.main(args);
    }
}
