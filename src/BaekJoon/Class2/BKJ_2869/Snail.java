package BaekJoon.Class2.BKJ_2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());
        int V = Integer.parseInt(token.nextToken());

        if ((V - A) % (A - B) == 0) {
            System.out.print(((V - A) / (A - B)) + 1);
        } else {
            if (V - (((V - A) / (A - B)) * (A - B)) > A) {
                System.out.print(((V - A) / (A - B)) + 2);
            } else {
                System.out.print(((V - A) / (A - B)) + 1);
            }
        }
    }
}

public class Snail {
}
