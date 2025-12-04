package BaekJoon.Class3.BKJ_1012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * HashSet의 원리
     * add(obj)를 호출하면 hashCode로 먼저 버킷을 탐색함
     * 만약 버킷에 객체가 있다면 equals로 모두 비교해보고 전부 false일 경우 버킷에 삽입된다
     * 
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Point)) return false;

        Point point = (Point) obj;
        return (this.x == point.x) && (this.y == point.y);

        /*HashCode가 같다고해서 같은 객체라는 보장이 없기 때문에 hashCode를 비교하는 방법은 100% 정답이 아니다
        return this.hashCode() == obj.hashCode();*/
    }

    /**
     * HashCode를 기본을 사용하면 같은 (5, 5)에 대해서도 hash 값이 다르다
     * Hash 값이 다르면 equals 메서드를 호출하지 않기 때문에 중복 좌표가 삽입이 된다
     * 물론 문제에서 두 배추의 위치가 같은 경우는 없다는 조건이 있었지만, 연습 삼아서 HashSet 오버라이딩 코드를 짜보자
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int CASE, N, M, K;
    static HashSet<Point> cabbages;
    //    static int[][] field;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        CASE = Integer.parseInt(br.readLine());
        for (int i = 0; i < CASE; i++) {
            startProcess();
        }
        System.out.println(sb);
    }

    static void startProcess() throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        cabbages = new HashSet<>();     // 아직 확인 안 한 양배추 목록 (다음 구간으로 O(1)만에 넘어가기 위해 HashSet 자료구조 사용)
//        field = new int[N][M];          // 근처 배추 있는지 확인용

//        int x, y;
        for (int i = 0; i < K; i++) {
            token = new StringTokenizer(br.readLine());
            cabbages.add(new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
//            field[x][y] = 1;
        }

        Iterator<Point> it = cabbages.iterator();
        int count = 0;
        while (it.hasNext()){
            count++;

            Point point = it.next();
            countWorms(point.x, point.y);

            it = cabbages.iterator();
        }
        sb.append(count).append("\n");
    }


    /**
     * BFS 방식으로 주변 영역 탐색
     * @param point
     */
    /*private static void countWormsWithArray(Point point) {
//        printCabbages("Removing (" + point.x + ", " + point.y + ")", cabbages);
        int x = point.x;
        int y = point.y;

        field[x][y] = 0;
        cabbages.remove(point);

        if (x - 1 >= 0 && field[x - 1][y] == 1) countWormsWithArray(new Point(x - 1, y));
        if (x + 1 < N && field[x + 1][y] == 1) countWormsWithArray(new Point(x + 1, y));
        if (y - 1 >= 0 && field[x][y - 1] == 1) countWormsWithArray(new Point(x, y - 1));
        if (y + 1 < M && field[x][y + 1] == 1) countWormsWithArray(new Point(x, y + 1));

    }*/

    /**
     * field 배열 사용 안하는 방식으로 변경
     * 왜냐하면 hashCode()와 equals()를 override하여 HashSet에서 좌표 객체를 찾을 수 있기 때문
     * @param x
     */
    private static void countWorms(int x, int y) {

        if (x < 0 || x >= N || y < 0 || y >= M) return;     // range check
        if (!cabbages.remove(new Point(x, y))) return;      // aliveness checks

        countWorms(x - 1, y);
        countWorms(x + 1, y);
        countWorms(x, y - 1);
        countWorms(x, y + 1);
    }

    private static void printCabbages(String x, HashSet<Point> cabbages) {
        System.out.println(x);
        for (Point cabbage : cabbages) {
            System.out.println(cabbage.x + " , " + cabbage.y + " > Hash is " + cabbage.hashCode());
        }
    }
}


public class OrganicCabbage {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class3.BKJ_1012/input.txt"));
        Main.main(args);
    }
}
