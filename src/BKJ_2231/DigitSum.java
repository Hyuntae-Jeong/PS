package BKJ_2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int digitSum = Integer.parseInt(br.readLine());
        int generator = 0;

        for (int i = 1; i <= digitSum; i++) {
            int i_digitSum = i;
            int num = i;
            while (num / 10 > 0) {
                i_digitSum += num % 10;
                num /= 10;
            }
            i_digitSum += num;

            if (i_digitSum == digitSum) {
                generator = i;
                break;
            }
        }

        System.out.print(generator);
    }
}

public class DigitSum {
}
