package BaekJoon.Class2.BKJ_7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] info;
    static int[] bigger;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        info = new int[N][2];
        bigger = new int[N];

        getInput();
        getBiggerCount();
        print();
    }

    static void getInput() throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(token.nextToken());
            info[i][1] = Integer.parseInt(token.nextToken());
        }
    }

    static void getBiggerCount() {
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (info[i][0] < info[j][0] && info[i][1] < info[j][1]) count++;
            }
            bigger[i] = count;
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(bigger[i] + 1).append(" ");
        System.out.print(sb);
    }
}

public class BigGuy {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class2/BKJ_7568/input.txt")));
        Main.main(args);
    }
}
