package BaekJoon.Class4.BKJ_15663;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Number {
    int key;
    int count;

    Number(int key) {
        this.key = key;
        this.count = 1;
    }

    void increaseCount() {
        this.count++;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static TreeMap<Integer, Number> map = new TreeMap<>();
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder totalSb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        getInput();
        startProcess(0, M);
        System.out.print(totalSb);
    }

    static void getInput() throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(token.nextToken());
            if (map.containsKey(key)) {
                map.get(key).increaseCount();
            } else {
                map.put(key, new Number(key));
            }
        }
    }

    static void startProcess(int currNumber, int step) {
        if (step == 0) {
            totalSb.append(sb).append("\n");
            return;
        }

        for (Number number : map.values()) {
            if (number.count == 0) continue;

            number.count--;
            sb.append(number.key).append(" ");

            startProcess(number.key, step - 1);

            number.count++;
            sb.deleteCharAt(sb.lastIndexOf(" "));
            sb.delete(sb.lastIndexOf(" ") + 1, sb.length());
        }
    }
}

public class NandM_9 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class4.BKJ_15663/input.txt"));
        Main.main(args);
    }
}
