package BaekJoon.Class5.BKJ_2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class Student {
    boolean isVisited;
    Set<Integer> nextStudents;
    int incomingCount;

    Student() {
        nextStudents = new HashSet<>();
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Student[] students;
    static int N, M;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        students = new Student[N + 1];
        getInput();
//        printInput();
        BFSMethod();
    }

    static void printInput() {
        for (int i = 1; i <= N; i++) {
            System.out.println("=== student " + i + " ===");
            System.out.println("incoming count: " + students[i].incomingCount);
            Iterator<Integer> it = students[i].nextStudents.iterator();

            while (it.hasNext()) {
                System.out.println("next: " + it.next());
            }
        }
    }

    static void getInput() throws IOException {
        initializeStudents();

        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            students[a].nextStudents.add(b);
            students[b].incomingCount++;
        }
    }

    static void initializeStudents() {
        for (int i = 1; i <= N; i++) {
            students[i] = new Student();
        }
    }

    static void BFSMethod() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (students[i].incomingCount == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int student = queue.poll();
            sb.append(student).append(" ");
            for (Integer next : students[student].nextStudents) {
                if (--students[next].incomingCount == 0) {
                    queue.add(next);
                }
            }
        }

        System.out.print(sb);
    }

    static void DFSMethod() {}
}

public class StandInLine {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class5/BKJ_2252/input.txt")));
        Main.main(args);
    }
}
