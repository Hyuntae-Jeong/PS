package BaekJoon.Class2.BKJ_11651;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point{
    int x;
    int y;

    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        Comparator<Point> pointComparator = Comparator.comparingInt(Point::getY).thenComparingInt(Point::getX);
        PriorityQueue<Point> queue = new PriorityQueue<>(N, pointComparator);

        for (int i = 0; i < N; i++) {
            // get input
            StringTokenizer token = new StringTokenizer(br.readLine());

            queue.add(new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            sb.append(point.x).append(" ").append(point.y).append("\n");
        }

        System.out.print(sb);
    }
}

public class PointSorting {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon/Class2/BKJ_11651/input.txt"));
        Main.main(args);
    }
}
