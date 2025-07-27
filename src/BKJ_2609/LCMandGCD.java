package BKJ_2609;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int small, big;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        small = Integer.parseInt(token.nextToken());
        big = Integer.parseInt(token.nextToken());

        if (small > big) {
            int temp = small;
            small = big;
            big = temp;
        }

        System.out.println(getGCD());
        System.out.println(getLCM());

    }

    public static int getGCD() {
        int divisor = small;

        while (divisor > 0) {
            if (small % divisor ==  0 && big % divisor == 0) return divisor;
            divisor--;
        }

        return 1;
    }

    public static int getLCM() {
        int smallMulti = small, bigMulti = big;

        while (smallMulti != bigMulti){
            if (smallMulti < bigMulti) smallMulti += small;
            else if (smallMulti > bigMulti) bigMulti += big;
        }

        return smallMulti;
    }
}
public class LCMandGCD {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_2609/input.txt"));
        Main.main(args);
    }
}
