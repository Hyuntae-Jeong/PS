package BKJ_2630;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] paper;
    static int white = 0, blue = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        readPaper();
//        printPaper();

        searchColoredPaper(0, 0, N);

        System.out.println(white + "\n" + blue);

    }

    static void printPaper() {
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.printf("%d ", paper[i][j]);
            }
            System.out.println();
        }
    }

    static void searchColoredPaper(int x, int y, int size) {
        int initialColor = paper[x][y];
        boolean flag = false;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++){
                if (paper[i][j] != initialColor) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        if (flag) {
            searchColoredPaper(x, y, size/2);
            searchColoredPaper(x + size/2, y, size/2);
            searchColoredPaper(x, y + size/2, size/2);
            searchColoredPaper(x + size/2, y + size/2, size/2);
        } else {
            if (initialColor == 0) white++;
            else blue++;
        }

    }

    private static void readPaper() throws IOException {
        StringTokenizer token;

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(token.nextToken());
            }
        }
    }
}

public class ColorPaper {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_2630/input.txt"));
        Main.main(args);
    }
}
