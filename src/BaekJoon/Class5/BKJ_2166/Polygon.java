package BaekJoon.Class5.BKJ_2166;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] points;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        getInput();
        doShoeTieAlgorithm();
    }

    static void getInput() throws IOException {
        points = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(token.nextToken());
            points[i][1] = Integer.parseInt(token.nextToken());
        }
    }

    static void doShoeTieAlgorithm() {
        long result = 0;

        for (int i = 0; i < N; i++) {
            result += (long) points[i][0] * points[(i + 1) % N][1];
            result -= (long) points[i][1] * points[(i + 1) % N][0];
        }

        double finalResult = Math.abs((double) result / 2);
        System.out.printf("%.1f", finalResult);
    }
}

public class Polygon {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon/Class5/BKJ_2166/input.txt"));
        Main.main(args);
    }
}
