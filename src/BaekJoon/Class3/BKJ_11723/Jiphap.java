package BaekJoon.Class3.BKJ_11723;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, SIZE = 21;
    static int[] set;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        set = new int[SIZE];
        startProcess();

    }

    private static void startProcess() throws IOException {
        StringTokenizer token;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());

            switch (token.nextToken()) {
                case "add":
                    set[Integer.parseInt(token.nextToken())] = 1;
                    break;
                case "remove":
                    set[Integer.parseInt(token.nextToken())] = 0;
                    break;
                case "check":
                    sb.append(set[Integer.parseInt(token.nextToken())]).append("\n");
                    break;
                case "toggle":
                    set[Integer.parseInt(token.nextToken())] ^= 1;
                    break;
                case "all":
                    for (int x = 1; x < SIZE; x++) set[x] = 1;
                    break;
                case "empty":
                    set = new int[SIZE];
                    break;
            }
        }

        System.out.println(sb);
    }
}


public class Jiphap {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class3.BKJ_11723/input.txt"));
        Main.main(args);
    }
}
