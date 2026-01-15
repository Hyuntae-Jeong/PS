package BaekJoon.Class2.BKJ_10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        int p = -1;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                list[++p] = num;
            } else {
                list[p--] = 0;
            }
        }

        int total = 0;
        for (int ii = 0; ii <= p; ii++) total += list[ii];
        System.out.println(total);
    }
}

public class Zero {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class2/BKJ_10773/input.txt")));
        Main.main(args);
    }
}
