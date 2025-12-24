package BaekJoon.Class2.BKJ_15829;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static final int r = 31, M = 1234567891;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        String inputString = br.readLine();
        char[] inputs = inputString.toCharArray();

        long ri = 1, hash = 0;
        for (char letter : inputs) {
            int value = Character.getNumericValue(letter) - 9;
            hash = (hash + value * ri) % M;
            ri = ri * r % M;
        }

        System.out.println(hash);
    }
}

public class Hashing {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon/Class2/BKJ_15829/input.txt"));
        Main.main(args);
    }
}
