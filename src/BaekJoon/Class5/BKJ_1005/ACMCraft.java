package BaekJoon.Class5.BKJ_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class Building {
    long cost;
    long requireCost;
    int requireCount;
    Set<Integer> buildAfter;

    Building (long cost) {
        this.cost = cost;
        this.requireCost = -1;
        this.requireCount = 0;
        this.buildAfter = new HashSet<>();
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int TC;

    public static void main(String[] args) throws IOException {
        TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < TC; i++) {
            sb.append(goACMCraft()).append("\n");
        }

        System.out.print(sb);
    }

    static long goACMCraft() throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        Building[] buildings = new Building[N + 1];

        getTasksAndConnections(N, K, buildings);

        int target = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (buildings[i].requireCount == 0 && buildings[i].requireCost < 0) {
                buildings[i].requireCost = 0;
                long result = getBuildingConstructionTimeBFS(i, target, buildings);
                if (result != -1) {
                    return result;
                }
            }
        }

        return -1;
    }

    static void getTasksAndConnections(int N, int K, Building[] buildings) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());

        // getTasks
        for (int i = 1; i <= N; i++) {
            buildings[i] = new Building(Long.parseLong(token.nextToken()));
        }

        // getConnections
        for (int j = 0; j < K; j++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            if (!buildings[a].buildAfter.contains(b)) {
                buildings[a].buildAfter.add(b);
                buildings[b].requireCount++;
            }
        }
    }

    static long getBuildingConstructionTimeBFS(int startBuilding, int targetBuilding, Building[] buildings) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startBuilding);

        while (!queue.isEmpty()) {
            int parent = (int) queue.poll();
            
            if (parent == targetBuilding) {
                return buildings[targetBuilding].cost + buildings[targetBuilding].requireCost;
            }

            for (Integer child : buildings[parent].buildAfter) {
                buildings[child].requireCost = Math.max(buildings[child].requireCost, buildings[parent].cost + buildings[parent].requireCost);

                // 필요한 건물들을 모두 탐색한 경우에만 다음으로 빌딩 탐색을 시작한다
                if (--buildings[child].requireCount == 0) {
                    queue.add(child);
                }
            }
        }

        // 타겟 빌딩이 속한 클러스터가 아닌 경우
        return -1;
    }
}

public class ACMCraft {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class5/BKJ_1005/input.txt")));
        Main.main(args);
    }
}
