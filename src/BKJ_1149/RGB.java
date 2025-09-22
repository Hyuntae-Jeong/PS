package BKJ_1149;

import java.io.*;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int R = 1, G = 2, B = 3;
    static int[][] colorInfos;
    static int[][] minCost;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        colorInfos = new int[N][4];
        minCost = new int[N][4];

        getInput();
        goThroughAllCases();
    }

    static void getInput() throws IOException {
        for (int cost, i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());

            cost = Integer.parseInt(token.nextToken());
            colorInfos[i][R] = cost;

            cost = Integer.parseInt(token.nextToken());
            colorInfos[i][G] = cost;

            cost = Integer.parseInt(token.nextToken());;
            colorInfos[i][B] = cost;

        }
    }

    static void goThroughAllCases() {
        minCost[0][R] = colorInfos[0][R];
        minCost[0][G] = colorInfos[0][G];
        minCost[0][B] = colorInfos[0][B];

        for (int i = 1; i < N; i++){
            minCost[i][R] = Math.min(minCost[i - 1][G], minCost[i - 1][B]) + colorInfos[i][R];
            minCost[i][G] = Math.min(minCost[i - 1][R], minCost[i - 1][B]) + colorInfos[i][G];
            minCost[i][B] = Math.min(minCost[i - 1][R], minCost[i - 1][G]) + colorInfos[i][B];

            /*System.out. printf("R[%d]: %d\t G[%d]: %d\t B[%d]: %d\n",
                    i, minCost[i][R], i, minCost[i][G], i, minCost[i][B]);*/
        }

        System.out.print(Math.min(Math.min(minCost[N - 1][R], minCost[N - 1][G]), minCost[N-1][B]));
    }
}

class House implements Comparable {
    int i, color, cost;

    House (int i, int color, int cost) {
        this.i = i;
        this.color = color;
        this.cost = cost;
    }

    @Override
    public int compareTo(Object o) {
        House h = (House) o;
        return this.cost - h.cost;
    }
}

public class RGB {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_1149/input.txt"));
        Main.main(args);
    }
}
