package BKJ_1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        long i = 0, x = 0;
        int count = 0, sixCount;

        while (count < N) {
            x = ++i;
            sixCount = 0;

            while (x > 0) {
                if (x % 10 == 6) sixCount++;
                else sixCount = 0;

                x /= 10;

                if (sixCount == 3) {
                    count++;
                    break;
                }
            }

        }

        System.out.print(i);
    }
}

