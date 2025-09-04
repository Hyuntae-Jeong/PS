package BKJ_1074;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int SIZE, R, C;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        SIZE = Integer.parseInt(token.nextToken());
        SIZE = (int) Math.pow(2, SIZE);

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        divideZ4(0,0, SIZE);
        System.out.println(count);
    }

    static void divideZ4(int xStart, int yStart, int size) {
        int halfSize = size/2;
        int quadrant = halfSize * halfSize;

        if (size <= 0) return;

        if (xStart == R && yStart == C) {
            return;
        }

        if (R < xStart + halfSize) {
            if (C < yStart + halfSize) {
                divideZ4(xStart, yStart, halfSize);
            } else {
                count += quadrant;
                divideZ4(xStart, yStart + halfSize, halfSize);
            }
        } else {
            if (C < yStart + halfSize) {
                count += (quadrant * 2);
                divideZ4(xStart + halfSize, yStart, halfSize);
            } else {
                count += (quadrant * 3);
                divideZ4(xStart + halfSize , yStart + halfSize, halfSize);
            }
        }
    }
}

public class Z {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_1074/input.txt"));
        Main.main(args);
    }
}
