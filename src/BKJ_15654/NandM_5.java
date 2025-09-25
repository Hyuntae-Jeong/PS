package BKJ_15654;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder finalSb = new StringBuilder();
    static Integer[] sortedList;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        getInput();
        startProcess();
    }

    static void callFunc(int index, int newCount) {
        isUsed[index] = true;
        func(index, newCount);
        sb.delete(sb.length() - (sortedList[index].toString().length() + 1), sb.length());
        isUsed[index] = false;
    }

    private static void startProcess() {
        isUsed = new boolean[N];

        for (int i = 0; i < N; i++) callFunc(i, M);
        System.out.print(finalSb);
    }

    static void func(int index, int count) {
        sb.append(sortedList[index]);

        if (count == 1) {
            sb.append("\n");
            finalSb.append(sb.toString());
            return;
        }

        sb.append(" ");

        for (int i = 0; i < N; i++) {
            if (isUsed[i]) continue;
            callFunc(i, count - 1);
        }
    }

    static void getInput() throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(token.nextToken()));

        list.sort(null);
        sortedList = list.toArray(new Integer[0]);
    }
}


public class NandM_5 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_15654/input.txt"));
        Main.main(args);
    }
}
