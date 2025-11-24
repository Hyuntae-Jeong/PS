package BKJ_2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int i = 1, step = 1;
        while (i < N) {
            i += 6 * step++;
        }
        System.out.println(step);
    }
}


public class BeeHouse {
}
