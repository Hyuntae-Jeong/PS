package BaekJoon.Class1.BKJ_10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] word = br.readLine().toCharArray();
        int[] letterCount = new int[27];
        int cnt = 0;
        for (char letter : word) {
            cnt++;
            int value = Integer.valueOf(letter) - 96;
            if (letterCount[value] == 0) letterCount[value] = cnt;
        }

        for (int i = 1; i <= 26; i++) {
            if (letterCount[i] == 0) sb.append("-1 ");
            else sb.append(letterCount[i] - 1).append(" ");
        }

        System.out.print(sb);
    }
}
