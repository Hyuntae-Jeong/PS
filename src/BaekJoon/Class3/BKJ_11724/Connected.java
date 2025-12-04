package BaekJoon.Class3.BKJ_11724;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] node, leaderNode;
    static int leaderCount = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        node = new int[N + 1];
        leaderNode = new int[N + 1];

        startProcess();
        getAnswer();
    }

    static void startProcess() throws IOException {
        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            if (node[a] == node[b]) {
                if (node[a] == 0) {
                    leaderNode[++leaderCount] = a;
                    node[a] = leaderCount;
                    node[b] = leaderCount;
                }
            } else if (node[a] == 0) {
                node[a] = node[b];
            } else if (node[b] == 0) {
                node[b] = node[a];
            } else {
                // a != b && a != 0 && b != 0
                // compare leader & connect
                if (leaderNode[node[a]] != leaderNode[node[b]]) {
                    int target = leaderNode[node[b]];
                    int newLeader = leaderNode[node[a]];

                    for (int j = 1; j <= leaderCount; j++) {
                        if (leaderNode[j] == target) leaderNode[j] = newLeader;
                    }
                }
            }
        }
    }

    static void getAnswer() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        boolean[] answer = new boolean[N + 1];
        int count = 0;

        for (int i = 1; i <= leaderCount; i++) {
            if (!answer[leaderNode[i]]) {
                answer[leaderNode[i]] = true;
                count++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (node[i] == 0) count++;
        }

        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

public class Connected {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class3.BKJ_11724/input.txt"));
        Main.main(args);
    }
}
