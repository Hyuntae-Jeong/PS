package BKJ_13549;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int subin, target;
    static boolean print = false;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(token.nextToken());
        target = Integer.parseInt(token.nextToken());

        if (subin >= target) System.out.println(subin - target);
        else startProcess();
    }

    static Deque<Integer> doubleQueue = new ArrayDeque<>();
    static Deque<Integer> walkQueue = new ArrayDeque<>();
    static int[] steps = new int[100_001];

    static void startProcess() {
        int currentStep = 1, x;     // currentStep 1부터 시작, 마지막 결과에서 1 빼주기
        steps[subin] = currentStep;
        doubleQueue.add(subin);
        walkQueue.add(subin);

        while (true) {
            // 2배씩 이동, 단 target 넘어서는 순간 stop
            while (!doubleQueue.isEmpty()) {
                x = doubleQueue.pop();
                if (print) System.out.printf("doubling: %d , step: %d\n", x, currentStep);

                while (x < target && x > 0) {
                    x *= 2;
                    if (x > 100_000) break;

                    if (x == target) {
                        System.out.println(currentStep - 1);
                        return;
                    }

                    if (steps[x] == 0) {
                        if (print) System.out.printf("double %d , step: %d\n", x, currentStep);
                        steps[x] = currentStep;
                        walkQueue.add(x);
                    }
                }
            }

            currentStep++;
            for (int i = 0, size = walkQueue.size(); i < size; i++) {    // 처음에 walkQueue 들어온 만큼만 for문 돌고 새로 들어온 요소에 대해서는 다음번에 실행
//            while (!walkQueue.isEmpty()) {    note: 걸어간 위치를 walkQueue에 넣는데 이 경우 while문 계속 실행 가능..
                // 후진
                x = walkQueue.pop();
                if (x - 1 >= 0 && steps[x - 1] == 0) {
                    if (print) System.out.printf("step -1: %d , step: %d\n", x - 1, currentStep);
                    steps[x - 1] = currentStep;
                    if (x - 1 == target) {
                        System.out.println(currentStep - 1);
                        return;
                    }
                    walkQueue.add(x - 1);   // todo: 새로 걸어간 곳에서 또 걸어가게..
                    if (x - 1 < target) doubleQueue.add(x - 1);
                }

                if (x + 1 <= 100_000 && steps[x + 1] == 0 && x + 1 <= target) {
                    if (print) System.out.printf("step +1: %d , step: %d\n", x + 1, currentStep);
                    steps[x + 1] = currentStep;
                    if (x + 1 == target) {
                        System.out.println(currentStep - 1);
                        return;
                    }

                    if (x + 1 < target) {
                        doubleQueue.add(x + 1);
                        walkQueue.add(x + 1);
                    }
                }
            }

        }
    }
}

public class HideAndSeek3 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_13549/input.txt"));
        Main.main(args);
    }
}

