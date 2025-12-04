package BaekJoon.Class4.BKJ_15650;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder finalSb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        func(0, M + 1);
        System.out.print(finalSb);
    }

    static void func(int index, int count) {
        if (index > 0) sb.append(index);

        if (count == 1) {
            sb.append("\n");
            finalSb.append(sb.toString());
            return;
        }
        if (index > 0) sb.append(" ");

        for (int i = index + 1; i <= N + 1 - (count - 1); i++) {
            func(i, count - 1);
            // Delete white space & last number
            sb.delete(sb.length() - 2, sb.length());
        }
    }
}

public class NandM_2 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class4.BKJ_15650/input.txt"));
        Main.main(args);
    }
}
