package BaekJoon.Class2.BKJ_1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        long i = 665, x;
        int count = 0;

        while (count < N) {
            x = ++i;
            while (x > 0) {
                if (x % 1000 == 666) {
                    count++;
                    break;
                }
                x /= 10;
            }
        }

        System.out.print(i);
    }
}

