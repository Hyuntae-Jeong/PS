package BaekJoon.Class5.BKJ_2467;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringTokenizer token;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());

        getInputUntilPositiveNum();
        getInputPositiveNumAndDoBinarySearch();
    }

    static long[] minus;
    static int endIndexOfMinus = -1;
    static long firstPositive = 0, secondPositive = 0;

    static void getInputUntilPositiveNum() {
        minus = new long[N];
        while (token.hasMoreElements()) {
            long value = Long.parseLong(token.nextToken());
            if (value > 0) {
                firstPositive = value;
                break;
            } else {
                minus[++endIndexOfMinus] = value;
            }
        }
    }

    static void getInputPositiveNumAndDoBinarySearch() {
        if (firstPositive != 0) binarySearch(firstPositive);

        if (token.hasMoreTokens()) {
            secondPositive = Long.parseLong(token.nextToken());
            binarySearch(secondPositive);
        }

        while (token.hasMoreTokens()) {
            binarySearch(Integer.parseInt(token.nextToken()));
        }
    }

    static long binaryMin = Long.MAX_VALUE;

    static class SearchData {
        long negMin, posMin, positive;
        boolean foundZero;

        SearchData (long positive) {
            this.negMin = Long.MAX_VALUE * -1;
            this.posMin = Long.MAX_VALUE;
            this.positive = positive;
            this.foundZero = false;
        }

        int eval(int idx) {
            long mixture = positive + minus[idx];
            if (mixture < 0 && mixture > negMin) {
                negMin = mixture;
                negMinValue = minus[idx];
                return -1;
            } else if (mixture > 0 && mixture < posMin) {
                posMin = mixture;
                posMinValue = minus[idx];
                return 1;
            } else {
                foundZero = true;
                return 0;
            }
        }

        void printVariables() {
            System.out.println("[ " + positive + " ] " + "negMin = " + negMin + " posMin = " + posMin);
        }
    }

    static boolean binarySearch(long positive) {
        // 하나의 산성용액에 대해 가장 조합이 좋은 염기성용액을 이진탐색을 찾아낸다
        SearchData searchData = new SearchData(positive);
        int left = 0, right = endIndexOfMinus, mid;

        searchData.eval(left);
        searchData.printVariables();

        searchData.eval(right);
        searchData.printVariables();

        while (left < right) {
            mid = (left + right) / 2;
            if (mid == left) break;

            switch (searchData.eval(mid)) {
                case -1:
                    left = mid;
                    break;
                case 1:
                    right = mid;
                    break;
                case 0:
                    return true;
            }
            searchData.printVariables();
        }

        // negMin과 rightMin 비교

        return false;
    }
}

public class Liquid {
    public static void main(String[] args) throws Exception {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class5/BKJ_2467/input.txt")));
        Main.main(args);
    }
}
