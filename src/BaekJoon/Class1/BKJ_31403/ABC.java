package BaekJoon.Class1.BKJ_31403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A, B, C;
        A = br.readLine();
        B = br.readLine();
        C = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C)).append("\n");
        sb.append(Integer.parseInt(A + B) - Integer.parseInt(C));

        System.out.print(sb);
    }
}

public class ABC {
}
