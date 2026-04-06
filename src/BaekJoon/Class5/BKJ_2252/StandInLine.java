package BaekJoon.Class5.BKJ_2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Student {
    Student front;
    Student back;

    Student() {
        this.front = null;
        this.back = null;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] relation;
    static boolean[] isStanding;
    static Student[] students;
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        relation = new int[N + 1][N + 1];
        isStanding = new boolean[N + 1];
        students = new Student[N + 1];

        getRelation();
        startLiningUp();
    }

    static void getRelation() throws IOException {
        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            relation[a][b] = 1;     // b는 a 뒤에 서야한다
            relation[b][a] = -1;    // a는 b 앞에 서야한다
        }
    }

    static void startLiningUp() {
        queue.add(1);
        isStanding[1] = true;
        students[1] = new Student();

        while (!queue.isEmpty()) {
            int standingKid = queue.poll();
            for (int candidateKid = 1; candidateKid <= N; candidateKid++) {
                if (relation[standingKid][candidateKid] == 0) continue;
                if (isStanding[candidateKid]) continue;

                if (relation[standingKid][candidateKid] == 1) {
                    if (students[standingKid].back == null) {
                        isStanding[candidateKid] = true;
                        students[candidateKid] = new Student();
                        students[standingKid].back = students[candidateKid];
                        students[candidateKid].front = students[standingKid];
                        queue.add(candidateKid);
                    } else {
                        // 비교하기
                    }
                } else if (relation[standingKid][candidateKid] == -1){

                }
            }
        }
    }
}

public class StandInLine {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class5/BKJ_2252/input.txt")));
        Main.main(args);
    }
}
