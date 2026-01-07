package BaekJoon.Class5.BKJ_2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

class Mixture {
    long liquidA, liquidB, valueABS;

    Mixture () {
        liquidA = 0;
        liquidB = 0;
        valueABS = Long.MAX_VALUE;
    }
}
class Main2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[] liquidList;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        getInput();
        twoPointerSearch();
    }

    static void getInput() throws IOException {
        liquidList = new long[N];
        StringTokenizer token = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            liquidList[i] = Long.parseLong(token.nextToken());
        }
    }

    static void twoPointerSearch() {
        Mixture mixture = new Mixture();
        int left = 0, right = N - 1;

        while (left < right) {
            long mix = liquidList[left] + liquidList[right];
            if (Math.abs(mix) < mixture.valueABS) {
                mixture.liquidA = liquidList[left];
                mixture.liquidB = liquidList[right];
                mixture.valueABS = Math.abs(mix);
            }

            // 혼합 용액이 음수일 경우 0에 가까워지려면 합이 더 커져야 한다
            // 합이 커질려면 index가 더 큰 숫자를 선택해야하므로 left 포인터를 1 증가시킨다
            // 반대로 합이 작아지려면 index가 더 작은 숫자를 선택해야하므로 right 포인터를 1 감소시킨다
            if (mix < 0) left++;
            else if (mix > 0) right--;
            else {
                printAnswer(mixture);
                return;
            }
        }
        printAnswer(mixture);
    }

    static void printAnswer(Mixture mixture) {
        System.out.printf("%d %d", mixture.liquidA, mixture.liquidB);
    }
}

public class LiquidAnother {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class5/BKJ_2467/input.txt")));
        Main2.main(args);
    }
}
