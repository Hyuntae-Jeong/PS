package BaekJoon.Class3.BKJ_11399;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static PriorityQueue<Integer> waitTimes;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        waitTimes = new PriorityQueue<>();

        getInputs();
        calculateMinTimes();
    }

    static void getInputs() throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            waitTimes.add(Integer.parseInt(token.nextToken()));
        }
    }

    static void calculateMinTimes() {
        Integer time;
        int totalTime = 0;

        while (N > 0){
            time = waitTimes.poll();
            if (time == null) break;

            totalTime += time * N--;
        }

        System.out.println(totalTime);
    }
}

public class ATM {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/BaekJoon.Class3.BKJ_11399/input.txt"));
        Main.main(args);
    }
}
