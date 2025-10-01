package BKJ_9663;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static HashMap<Integer, Boolean> occupiedSum, occupiedSub, occupiedY;
    static int count = 0;
    static boolean debug = false;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        occupiedSum = new HashMap<>();
        occupiedSub = new HashMap<>();
        occupiedY = new HashMap<>();
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
            if (occupiedSub.getOrDefault(y - x, false) || occupiedSum.getOrDefault(x + y, false) || occupiedY.getOrDefault(y, false)) continue;

            if (debug) System.out.printf("Checking... (%d , %d)\n", x, y);

            // occupy current queen's boundaries
            { occupiedSum.put(x + y, true); occupiedSub.put(y - x, true); occupiedY.put(y, true); }
            check(x + 1);
            { occupiedSum.put(x + y, false); occupiedSub.put(y - x, false); occupiedY.put(y, false); }
        }
    }
}

public class NQueen {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_9663/input.txt"));
        Main.main(args);
    }
}
