package BKJ_1003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class ZeroNOne {
    int zeros;
    int ones;

    ZeroNOne(int zeros, int ones) {
        this.zeros = zeros;
        this.ones = ones;
    }
}

class Main_withClass {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] inputs;
    static int maxInputValue = 1;       // max가 0이어도 zeroNOnes 값은 0과 1이 만들어지도록
    static ZeroNOne[] zeroNOnes;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        getInputs();
        goFibo();
        printResult();
    }

    static void getInputs() throws IOException {
        inputs = new int[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
            if (inputs[i] > maxInputValue) maxInputValue = inputs[i];
        }

        zeroNOnes = new ZeroNOne[maxInputValue + 1];
    }

    static void goFibo() {
        zeroNOnes[0] = new ZeroNOne(1, 0);
        zeroNOnes[1] = new ZeroNOne(0, 1);

        for (int i = 2; i <= maxInputValue; i++) {
            zeroNOnes[i] =  new ZeroNOne(zeroNOnes[i-1].zeros + zeroNOnes[i-2].zeros, zeroNOnes[i-1].ones + zeroNOnes[i-2].ones);
        }
    }

    static void printResult() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(zeroNOnes[inputs[i]].zeros).append(" ").append(zeroNOnes[inputs[i]].ones).append("\n");
        }

        System.out.println(sb);
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] inputs;
    static int maxInputValue = 1;       // max가 0이어도 zeroNOnes 값은 0과 1이 만들어지도록
    static int[][] zeroNOnes;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        getInputs();
        goFibo();
        printResult();
    }

    static void getInputs() throws IOException {
        inputs = new int[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
            if (inputs[i] > maxInputValue) maxInputValue = inputs[i];
        }

        zeroNOnes = new int[maxInputValue + 1][2];
    }

    static void goFibo() {
        zeroNOnes[0][0] = 1; zeroNOnes[0][1] = 0;
        zeroNOnes[1][0] = 0; zeroNOnes[1][1] = 1;

        for (int i = 2; i <= maxInputValue; i++) {
            zeroNOnes[i][0] = zeroNOnes[i-1][0] + zeroNOnes[i-2][0];
            zeroNOnes[i][1] = zeroNOnes[i-1][1] + zeroNOnes[i-2][1];
        }
    }

    static void printResult() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(zeroNOnes[inputs[i]][0]).append(" ").append(zeroNOnes[inputs[i]][1]).append("\n");
        }

        System.out.println(sb);
    }

}

public class FibonacciFunction {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_1003/input.txt"));
        Main.main(args);
    }
}
