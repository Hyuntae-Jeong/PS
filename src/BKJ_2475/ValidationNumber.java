package BKJ_2475;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        int number, sum = 0;
        for (int i = 1; i <= 5; i++) {
            number = Integer.parseInt(token.nextToken());
            sum += (int) Math.pow(number, 2);
            sum %= 10;
        }

        System.out.print(sum);
    }
}

public class ValidationNumber {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_2475/input.txt"));
        Main.main(args);
    }
}
