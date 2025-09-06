package BKJ_1927;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        int command;
        Integer result;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            command = Integer.parseInt(br.readLine());
            if (command == 0) {
                result = minHeap.poll();
                if (result == null) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(result).append("\n");
                }
            } else {
                minHeap.add(command);
            }
        }

        System.out.println(sb);
    }
}

public class MinHeap {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_1927/input.txt"));
        Main.main(args);
    }
}
