package BaekJoon.Class2.BKJ_1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = (N / 5) + (N / (5 * 5)) + (N / (5 * 5 * 5));
        System.out.print(answer);
    }
}

public class FactorialZeros {
    /**
     * 5와 짝수가 만나면 0이 하나 생긴다
     * 즉, 5의 배수마다 0이 하나씩 생긴다
     *
     * 이때, 25의 경우에는 5가 2개 들어있다 (5x5=25)
     * 그러므로 0이 두개 생긴다
     *
     * 똑같은 원리로 125의 경우에는 5가 3개 생긴다 (5x5x5=125)
     */
}

