package BaekJoon.Class4.BKJ_1629;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int A, B, C;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        A = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        System.out.println(getMod(B));
    }

    static long getMod(int x) {
        if (x == 1) return A % C;

        long result = getMod(x / 2) % C;
        result = (result * result) % C;

        return x % 2 == 0 ? result : (result * getMod(1)) % C;
    }
}

public class Multiplication {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class4.BKJ_1629/input.txt"));
        Main.main(args);
    }
}
