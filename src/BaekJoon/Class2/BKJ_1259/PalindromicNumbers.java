package BaekJoon.Class2.BKJ_1259;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Optional;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int numberLength, pointer;

    public static void main(String[] args) throws IOException {
        String number;
        StringBuilder sb = new StringBuilder();

        while (true) {
            number = br.readLine();
            if (number.equals("0")) break;

            if (judgePalindromic(number)) sb.append("yes\n");
            else sb.append("no\n");
        }

        System.out.println(sb);
    }

    public static boolean judgePalindromic(String number) {
        numberLength = number.length() - 1;
        pointer = 0;

        while (pointer <= (numberLength) / 2) {
            if (! Objects.equals(Optional.of(number.charAt(pointer)), Optional.of(number.charAt(numberLength - pointer)))) {
                return false;
            }
            pointer++;
        }

        return true;
    }
}

public class PalindromicNumbers {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/BaekJoon.Class2.BKJ_1259/input.txt"));
        Main.main(args);
    }
}
