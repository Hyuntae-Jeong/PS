package BaekJoon.Class3.BKJ_11726;

import java.io.*;

class Main {
    static int[] arr;
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        arr[1] = 1;
        if (N >= 2) arr[2] = 2;

        startProcess();

    }

    static void startProcess() {
        for (int i = 3; i <= N; i++) {
            // 5 일때 경우의 수
            // 1(맨 앞) + 4(일때 경우의 수) & 2(맨 앞) + 3(일때 경우의 수)
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }

        System.out.println(arr[N]);
    }
}

public class Nx2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BaekJoon.Class3.BKJ_11726/input.txt"));
        Main.main(args);
    }
}
