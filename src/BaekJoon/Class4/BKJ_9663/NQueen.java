    package BaekJoon.Class4.BKJ_9663;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static boolean[] occupiedSum, occupiedSub, occupiedY;
    static int count = 0;
    static boolean debug = false;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        occupiedSum = new boolean[N * 4 + 1];
        occupiedSub = new boolean[N * 4 + 1];
        occupiedY = new boolean[N + 1];
        check(0);
        System.out.print(count);
    }


    static void check(int x) {
        if (x == N) {
            if (debug) System.out.println("found!!");
            count++;
            return;
        }

        for (int y = 0; y < N; y++) {
            int sub = (y - x) + N, sum = (x + y) + N;
            if (occupiedSub[sub] || occupiedSum[sum] || occupiedY[y]) continue;

            if (debug) System.out.printf("Checking... (%d , %d)\n", x, y);

            // occupy current queen's boundaries
            { occupiedSum[sum] = true; occupiedSub[sub] = true; occupiedY[y] = true; }
            check(x + 1);
            { occupiedSum[sum] = false; occupiedSub[sub] = false; occupiedY[y] = false; }
        }
    }
}

public class NQueen {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class4.BKJ_9663/input.txt"));
        Main.main(args);
    }
}
