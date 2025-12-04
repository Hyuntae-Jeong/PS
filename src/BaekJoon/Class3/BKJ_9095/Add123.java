package BaekJoon.Class3.BKJ_9095;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int target, count;
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            target = Integer.parseInt(br.readLine());
            count = 0;
            add123(1);
            add123(2);
            add123(3);
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
    
    static void add123(int x) {
        target -= x;
        if (target > 0) {
            add123(1);
            add123(2);
            add123(3);
        } else if (target == 0) {
            count++;
        }
        target += x;
    }
}

public class Add123 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class3.BKJ_9095/input.txt"));
        Main.main(args);
    }
}
