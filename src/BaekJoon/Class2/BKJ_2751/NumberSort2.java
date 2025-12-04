package BaekJoon.Class2.BKJ_2751;

import java.io.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static boolean[] negativeNumbers = new boolean[1000001];
    static boolean[] positiveNumbersAndZero = new boolean[1000001];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        getInputNumbers(N);
        printSortedNumbers();
    }

    public static void getInputNumbers(int N) throws IOException {
        int number;
        for (int i = 0; i < N; i++){
            number = Integer.parseInt(br.readLine());
            if (number < 0) negativeNumbers[-1 * number] = true;
            else positiveNumbersAndZero[number] = true;
        }
    }

    public static void printSortedNumbers() {
        for (int i = 1000000; i >= 1; i--) {
            if (negativeNumbers[i]) sb.append("-").append(i).append("\n");
        }

        for(int i = 0; i <= 1000000; i++) {
            if (positiveNumbersAndZero[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}


/**
 * 문제
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 *
 * 출력
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 *
 */

public class NumberSort2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BaekJoon.Class2.BKJ_2751/input.txt"));
        Main.main(args);
    }
}
