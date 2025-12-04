package BaekJoon.Class2.BKJ_1018;

import java.io.*;
import java.util.StringTokenizer;

class Main{
    static int[][] chessBoard;
    static int N, M;
    static final int SIZE = 8;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        chessBoard = new int[N][M];
        getChessBoard();
//        printChessBoard();
        
        
        //  (0,0) 칸이 검은색인 경우와 흰색인 경우를 나눠서 생각
        int caseBlack = topLeftCornerBlack();
        if (caseBlack == 0) {
            System.out.println(caseBlack);
            return;
        }

        int caseWhite = topLeftCornerWhite();
        System.out.println(Math.min(caseBlack, caseWhite));
    }

    public static void getChessBoard() throws IOException {
        String row;
        for (int i = 0; i < N; i++){
            row = br.readLine();
            for(int j = 0; j < M; j++){
                // Black = 0, White = 1
                chessBoard[i][j] = row.charAt(j) == 'B' ? 0 : 1;
            }
        }
    }

    public static void printChessBoard() {
        for (int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMiniChessBoard(int[][] miniChessBoard) {
        System.out.println("-----------------");
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(miniChessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int topLeftCornerBlack() {
        int[][] blackChessBoard = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // (x좌표 + y좌표) % 2 값이 0인 곳이 Black(0)이 아니면, 1인 곳이 White(1)가 아니면 재색칠
                blackChessBoard[i][j] = chessBoard[i][j] == (i + j) % 2 ? 0 : 1;
            }
        }
//        printMiniChessBoard(blackChessBoard);
        return countTotalChanges(blackChessBoard);
    }

    public static int topLeftCornerWhite() {
        int[][] whiteChessBoard = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // (x좌표 + y좌표) % 2 값이 0인 곳이 White(1)가 아니면, 1인 곳이 Black(0)이 아니면 재색칠
                whiteChessBoard[i][j] = chessBoard[i][j] != (i + j) % 2 ? 0 : 1;
            }
        }
//        printMiniChessBoard(whiteChessBoard);
        return countTotalChanges(whiteChessBoard);
    }

    public static int countTotalChanges(int[][] miniChessBoard) {
        int min = SIZE * SIZE;   // 8*8 (chess board size)

        int[] verticalSum;      // 세로 한 줄을 하나의 배열로 관리해서 넣고 빼고하기
        int totalSum, newLineSum, tail = SIZE - 1;

        // 왼쪽 면을 시작점으로 잡는다
        for (int i = 0; i <= N - SIZE; i++, tail = SIZE - 1){
            // 여기서 부터는 이제 세로 합들을 하나씩 넘겨가면서 최소값 구하기
            verticalSum = initializeVerticalSum(miniChessBoard, i);
            totalSum = verticalSum[SIZE];

            if (totalSum < min) {
                min = totalSum;
//                System.out.println("new minimum at point " + i + " , " + (tail - 7) + "(min: " + min + ")");
            }

            while (++tail < M) {

                newLineSum = 0;
                for(int ii = i; ii < i + SIZE; ii++){
                    newLineSum += miniChessBoard[ii][tail];
                }

                totalSum -= verticalSum[tail % 8];
                totalSum += newLineSum;

                verticalSum[tail % 8] = newLineSum;

                if (totalSum < min) {
                    min = totalSum;
//                    System.out.println("new minimum at point " + i + " , " + (tail - 7) + "(min: " + min + ")");
                    if (min == 0) return min;
                }
            }
        }

        return min;
    }

    public static int[] initializeVerticalSum(int[][] miniChessBoard, int x) {
        // 오른쪽 방향으로 탐색하기 전 최초에는 8개의 줄을 모두 스캔해야한다
        int sum[] = new int[SIZE + 1];

        for(int j = 0; j < SIZE; j++) {
            for(int i = x; i < x + SIZE; i++) {
                sum[j] += miniChessBoard[i][j];
            }
            // sum[8]에는 전체 바뀌어야할 칸의 합을 저장함
            sum[SIZE] += sum[j];
        }

        return sum;
    }

}

public class RepaintChessBoard {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class2.BKJ_1018/input.txt"));
        Main.main(args);
    }
}
