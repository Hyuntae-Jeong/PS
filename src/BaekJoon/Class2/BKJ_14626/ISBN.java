package BaekJoon.Class2.BKJ_14626;

import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String brokenISBNraw = br.readLine();
        char[] brokenISBN = brokenISBNraw.toCharArray();
        int sum = 0, factor, value, targetFactor = 1;
        for (int i = 0 ; i < brokenISBN.length - 1; i++) {
            factor = 1 + ((i % 2) * 2);                 // i가 짝수면 1, 홀수면 3
            if (brokenISBN[i] == '*') {
                targetFactor = factor;
            }
            else {
                value = Character.getNumericValue(brokenISBN[i]);
                sum += value * factor;
                sum %= 10;
            }
        }

        int lastNum = Character.getNumericValue(brokenISBN[brokenISBN.length - 1]);
        for (int i = 0; i <= 9; i++) {
            if ((sum + (i * targetFactor) + lastNum) % 10 == 0) {
                System.out.print(i);
                break;
            }
        }
    }
}

public class ISBN {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BaekJoon/Class2/BKJ_14626/input.txt"));
        Main.main(args);
    }
}

