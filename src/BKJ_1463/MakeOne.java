package BKJ_1463;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int step = 0, minStep = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        DFS(N);
        System.out.println(minStep - 1);
    }

    static void DFS(int x) {
        step++;

        // 1인지 확인
        if (x == 1) {
            if (step < minStep) minStep = step;
            return;
        }

        // 조기 종료
        if (step == minStep - 1){
            if (x == 3 || x == 2) return;   // 어차피 다음 step때 1이 나오기 때문에 의미 x
        } else if (step == minStep) return;


        // 다음 DFS
        if (x % 3 == 0) {
            DFS(x / 3);
            step--;
        }
        if (x % 2 == 0) {
            DFS(x / 2);
            step--;
        }
        DFS(x - 1);
        step--;
    }
}


public class MakeOne {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_1463/input.txt"));
        Main.main(args);
    }
}
