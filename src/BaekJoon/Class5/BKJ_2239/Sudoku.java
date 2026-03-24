package BaekJoon.Class5.BKJ_2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] square, row, column;
    static int[][] sudoku;

    public static void main(String[] args) throws IOException {
        getInput();
        search(-1, 8);
    }

    private static void printSudoku() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void getInput() throws IOException {
        sudoku = new int[9][9];
        square = new int[9];
        row = new int[9];
        column = new int[9];

        for(int i = 0; i < 9; i++) {
            String inputLine = br.readLine();
            for (int j = 0; j < inputLine.length(); j++) {
                int n = (int) inputLine.charAt(j) - '0';
                sudoku[i][j] = n;
                if (n == 0) continue;

                markArea(i, j, n);
            }
        }
    }

    static void markArea(int i, int j, int n) {
        square[getSquareZone(i, j)] = square[getSquareZone(i, j)] + (1 << n);
        row[i] = row[i] + (1 << n);
        column[j] = column[j] + (1 << n);
    }

    static void unmarkArea(int i, int j, int n) {
        square[getSquareZone(i, j)] = square[getSquareZone(i, j)] - (1 << n);
        row[i] = row[i] - (1 << n);
        column[j] = column[j] - (1 << n);
    }

    static int getSquareZone(int i, int j) {
        return (j / 3) + (i / 3 * 3);
    }

    static void search(int startX, int startY) {
        int x = startX, y = startY;

        do {
            x = x + (y + 1) / 9;
            y = (y + 1) % 9;
        } while(x < 9 && sudoku[x][y] != 0);
        if (x > 8) {
            printSudoku();
            System.exit(0);
        }

        int result = square[getSquareZone(x, y)] | row[x] | column[y];
        for (int i = 1; i <= 9; i++) {
            if ((result & (1 << i)) == 0) {
                // sudoku에 가능한 수로 표기하고 다음 탐색하기
                sudoku[x][y] = i;
                markArea(x, y, i);

                search(x, y);

                // sudoku에 표기한거 원복하기
                sudoku[x][y] = 0;
                unmarkArea(x, y, i);
            }
        }
    }
}

public class Sudoku {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class5/BKJ_2239/input.txt")));
        Main.main(args);
    }
}
