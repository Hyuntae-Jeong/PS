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
        if (firstPositive != 0) {
            if(binarySearch(firstPositive)){
                System.out.printf("%d %d", Math.min(answer.liquid1, answer.liquid2), Math.max(answer.liquid1, answer.liquid2));
                return;
            }
        }

        if (token.hasMoreTokens()) {
            secondPositive = Long.parseLong(token.nextToken());
            if(binarySearch(secondPositive)){
                System.out.printf("%d %d", Math.min(answer.liquid1, answer.liquid2), Math.max(answer.liquid1, answer.liquid2));
                return;
            }
        }

        while (token.hasMoreTokens()) {
            if(binarySearch(Integer.parseInt(token.nextToken()))){
                System.out.printf("%d %d", Math.min(answer.liquid1, answer.liquid2), Math.max(answer.liquid1, answer.liquid2));
                return;
            }
        }

        getFinalAnswer();
    }

    static void getFinalAnswer() {
        // 음수 2개 더한 값의 용액값과 이진값에서 구한 용액값 비교
        if (endIndexOfMinus >= 1) {
            if (Math.abs(minus[endIndexOfMinus - 1] + minus[endIndexOfMinus]) < answer.absValue) {
                answer.absValue = Math.abs(minus[endIndexOfMinus - 1] + minus[endIndexOfMinus]);
                answer.liquid1 = minus[endIndexOfMinus - 1];
                answer.liquid2 = minus[endIndexOfMinus];
            }
        }

        // 양수 2개 더한 값의 용액값과 이진값에서 구한 용액값 비교
        if (firstPositive != 0 && secondPositive != 0) {
            if (Math.abs(firstPositive + secondPositive) < answer.absValue) {
                answer.absValue = Math.abs(firstPositive + secondPositive);
                answer.liquid1 = firstPositive;
                answer.liquid2 = secondPositive;
            }
        }

        System.out.printf("%d %d", Math.min(answer.liquid1, answer.liquid2), Math.max(answer.liquid1, answer.liquid2));
    }

    static class SearchData {
        long negMin, posMin, positive, negMinValue, posMinValue;

        SearchData (long positive) {
            this.negMin = Long.MAX_VALUE * -1;
            this.posMin = Long.MAX_VALUE;
            this.positive = positive;
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
                answer.absValue = 0;
                answer.liquid1 = positive;
                answer.liquid2 = minus[idx];
                return 0;
            } else {
                // 예외
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
        }

        void printVariables() {
            System.out.println("[ " + positive + " ] " + "negMin = " + negMin + " negMinValue = " + negMinValue + " posMin = " + posMin + " posMinValue = " + posMinValue);
        }
    }

    static boolean binarySearch(long positive) {
        /**
         * 하나의 산성용액에 대해 가장 조합이 좋은 염기성용액을 이진탐색을 찾아낸다
         */

        // 음수 용액이 없을 경우 이진 탐색 skip
        if (endIndexOfMinus < 0) return false;

        SearchData searchData = new SearchData(positive);
        int left = 0, right = endIndexOfMinus, mid;

        searchLoop:
        while (left < right) {
            if (left + 1 == right) break;
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
            }
        }

        searchData.eval(left);
        searchData.eval(right);

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
