package BaekJoon.Class5.BKJ_1005;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Building {
    int cost;
    long buildTime;
    ArrayList<Integer> requires;

    Building (int cost, int size) {
        this.cost = cost;
        this.buildTime = 0;
        this.requires = new ArrayList<>(size);
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

        System.out.println(sb);
    }

    static long goACMCraft() throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        Building[] buildings = new Building[N + 1];

        getTasksAndConnections(N, K, buildings);

        int target = Integer.parseInt(br.readLine());

        return getBuildingConstructionTime(target, buildings);
    }

    static void getTasksAndConnections(int N, int K, Building[] buildings) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());

        // getTasks
        for (int i = 1; i <= N; i++) {
            buildings[i] = new Building(Integer.parseInt(token.nextToken()), N);
        }

        // getConnections
        for (int j = 0; j < K; j++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            buildings[b].requires.add(a);
        }
    }

    static long getBuildingConstructionTime(int buildingNum, Building[] buildings) {
        if (buildings[buildingNum].buildTime > 0) return buildings[buildingNum].buildTime;

        long maxCost = 0;

        for (int require : buildings[buildingNum].requires) {
            maxCost = Math.max(maxCost, getBuildingConstructionTime(require, buildings));
        }

        buildings[buildingNum].buildTime = maxCost + buildings[buildingNum].cost;
        return buildings[buildingNum].buildTime;
    }
}

public class ACMCraft {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class5/BKJ_1005/input.txt")));
        Main.main(args);
    }
}
