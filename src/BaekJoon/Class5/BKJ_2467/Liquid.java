package BaekJoon.Class5.BKJ_2467;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

class Answer {
    long absValue;
    long liquid1, liquid2;

    Answer () {
        this.absValue = Long.MAX_VALUE;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringTokenizer token;
    static Answer answer = new Answer();

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

    static class SearchData {
        long negMin, posMin, positive, negMinValue, posMinValue;
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
            } else if (mixture == 0) {
                foundZero = true;
                return 0;
            } else {
                // L와 R가 만난 지점
                return 999;
            }
        }

        void compareWithGlobal() {
            // 전체 Binary Min과 비교해서 절대값 더 작으면 덮어씌우기
            if (Math.abs(negMin) < Math.abs(posMin) && Math.abs(negMin) < answer.absValue) {
                answer.absValue = Math.abs(negMin);
                answer.liquid1 = negMinValue;
                answer.liquid2 = positive;
            } else if (Math.abs(negMin) >= Math.abs(posMin) && Math.abs(posMin) < answer.absValue) {
                answer.absValue = Math.abs(posMin);
                answer.liquid1 = posMinValue;
                answer.liquid2 = positive;
            }
            System.out.println("[answer] absValue = " + answer.absValue + " , liquid1 = " + answer.liquid1 + " , liquid2 = " + answer.liquid2);
        }

        void printVariables() {
            System.out.println("[ " + positive + " ] " + "negMin = " + negMin + " posMin = " + posMin);
        }
    }

    static boolean binarySearch(long positive) {
        // 하나의 산성용액에 대해 가장 조합이 좋은 염기성용액을 이진탐색을 찾아낸다
        SearchData searchData = new SearchData(positive);
        int left = 0, right = endIndexOfMinus, mid;

        searchLoop:
        while (left < right) {
            mid = (left + right) / 2;

            switch (searchData.eval(mid)) {
                case -1:
                    left = mid;
                    break;
                case 1:
                    right = mid;
                    break;
                case 0:
                    return true;
                case 999:
                    break searchLoop;
            }
        }

        // negMin과 rightMin 비교
        searchData.compareWithGlobal();

        return false;
    }
}

public class Liquid {
    public static void main(String[] args) throws Exception {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class5/BKJ_2467/input.txt")));
        Main.main(args);
    }
}
