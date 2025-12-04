package BaekJoon.Class2.BKJ_18110;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] points;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        points = new int[N];

        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(points);

        int cutline = (int) Math.round((double)N * 0.15);
        double sum = 0;
        for (int i = cutline; i < N - cutline; i++) {
            sum += points[i];
        }

        System.out.print(Math.round(sum / (N - cutline * 2)));
    }
}

public class SolvedAC {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class2.BKJ_18110/input.txt"));
        Main.main(args);
    }
}
