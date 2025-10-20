package BKJ_2206;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Point {
    int x, y, step, minPrevStep;

    Point (int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] arr, revArr;
    static Deque<Point> queue, wallQueue, breakableWallQueue;
    static boolean debug = true;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N + 1][M + 1];

        getInput();
        boolean withoutBreaking = findPathWithoutBreaking();

        if(debug) printThings(arr);

        if (withoutBreaking) {
            /**
             * @case: 벽 부수기 없이 최단거리 찾은 경우
             * @target: 최단거리 더 짧아지는 경우 (벽 1개만 부수기)
             */
            breakWallsOneByOne();
            System.out.print(arr[N][M]);
        } else {
            /**
             * @case: 벽에 막혀서 도착지점 도달하지 못한 경우
             * @target: 도착지점에 최단거리로 도착할 수 있는 벽 찾기
             * @condition: 뚫리는 벽의 조건은 4면 중 arr배열 양수인 값 1개 이상과 0인 값 1개 이상 모두 존재
             * @step
             * 1. 뚫을 수 있는 벽 필터링 하기
             * 2. 뚫을 수 있는 벽 없으면 -1 리턴하고, 있으면 breakableWallQueue에 저장
             * 3. 도착 지점에서 역으로 step 구하고 revArr 배열에 저장하기
             * 4. breakableWallQueue와 revArr를 활용해서 최단거리 되는 벽 찾기
             */

            breakableWallQueue  = filterBreakableWalls();               // step 1
            if (breakableWallQueue.isEmpty()) System.out.print("-1");   // step 2
            else {
                 findReversePath();                                     // step 3
                 if (debug) printThings(revArr);
                 breakTheWall();
            }
        }
        
    }

    private static void breakTheWall() {
        int finalMinStep = N * M;
        while (!breakableWallQueue.isEmpty()) {
            Point p = breakableWallQueue.poll();

            int minStepAfterWall = N * M;
            for (int i = 0; i < 4; i++) {
                int stepAfterWall = getRevStep(p.x + dx[i], p.y + dy[i]);
                if (stepAfterWall > 0) {
                    minStepAfterWall = Math.min(minStepAfterWall, stepAfterWall);
                }
            }
            finalMinStep = Math.min(finalMinStep, p.minPrevStep + 1 + minStepAfterWall);

            if (debug) System.out.printf("breakable Wall: (%d, %d), minPrevStep: %d, minStepAfterWall: %d\n", p.x, p.y, p.minPrevStep, minStepAfterWall);
        }

        System.out.print(finalMinStep);
    }

    private static Deque<Point> filterBreakableWalls() {
        breakableWallQueue = new ArrayDeque<>();

        while (!wallQueue.isEmpty()) {
            Point p = wallQueue.poll();
            boolean isPositive = false, isZero = false;
            int step, minPrevStep = N * M;

            for (int i = 0; i < 4; i++) {
                step = getStep(p.x + dx[i], p.y + dy[i]);
                if (step == -1) continue;
                else if (step == 0) isZero = true;
                else if (step > 0) {
                    isPositive = true;
                    minPrevStep = Math.min(minPrevStep, step);      // 최소 거리에서 벽을 뚫어야 최종적으로 최단거리가 된다
                }
            }

            if (isZero && isPositive) {
                p.minPrevStep = minPrevStep;
                breakableWallQueue.push(p);
            }
        }

        return breakableWallQueue;
    }

    static void breakWallsOneByOne() {
        int maxDiff = 0;

        while (!wallQueue.isEmpty()) {
            Point p = wallQueue.poll();

            int minStep = N * M, maxStep = 0, step;
            for (int i = 0; i < 4; i++) {
                step = getStep(p.x + dx[i], p.y + dy[i]);
                if (step == -1) continue;

                minStep = Math.min(minStep, step);
                maxStep = Math.max(maxStep, step);
                maxDiff = Math.max(maxDiff, maxStep - minStep);
            }

            if(debug) System.out.printf("wall (%d, %d) = min: %d, max: %d, diff: %d\n", p.x, p.y, minStep, maxStep, maxStep - minStep);
        }

        if (maxDiff - 2 > 0) arr[N][M] -= (maxDiff - 2);
    }

    static int getStep(int x, int y) {
        if (x <= 0 || x > N) return -1;
        if (y <= 0 || y > M) return -1;

        return arr[x][y];
    }

    static int getRevStep(int x, int y) {
        if (x <= 0 || x > N) return -1;
        if (y <= 0 || y > M) return -1;

        return revArr[x][y];
    }

    static void printThings(int[][] targetArr) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.printf("%d\t", targetArr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void getInput() throws IOException {
        wallQueue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            String inputLine = br.readLine();
            for (int j = 1; j <= M; j++) {
                if (inputLine.charAt(j - 1) == '1') {
                    arr[i][j] = -1;
                    wallQueue.add(new Point(i, j, 0));
                }
            }
        }
    }

    static boolean findPathWithoutBreaking() {
        queue = new ArrayDeque<>();
        queue.add(new Point(1, 1, 1));
        arr[1][1] = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            nextStep(p, arr);
        }
        
        // 마지막 위치가 (N, M)이 아니면 벽에 막힌 것
        return arr[N][M] != 0;
    }

    static void findReversePath() {
        revArr = new int[N + 1][M + 1];
        queue = new ArrayDeque<>();

        queue.add(new Point(N, M, 1));
        revArr[N][M] = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            nextStep(p, revArr);
        }
    }

    static void nextStep (Point p, int[][] targetArr) {
        for (int i = 0; i < 4; i++) {
            if (inRangeAndCanGo(p.x + dx[i], p.y + dy[i], targetArr)) {
                queue.add(new Point(p.x + dx[i], p.y + dy[i], p.step + 1));
                targetArr[p.x + dx[i]][p.y + dy[i]] = p.step + 1;
            }
        }
    }

    static boolean inRangeAndCanGo(int x, int y, int[][] targetArr) {
        if (x <= 0 || x > N) return false;
        if (y <= 0 || y > M) return false;
        if (arr[x][y] == -1) return false;
        if (targetArr[x][y] > 0) return false;

        return true;
    }
}

public class BreakTheWall {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BKJ_2206/input.txt"));
        Main.main(args);
    }
}
