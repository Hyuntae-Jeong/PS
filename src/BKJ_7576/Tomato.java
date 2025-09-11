package BKJ_7576;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


class Mato {
    int x;
    int y;
    int age;
    
    Mato (int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] field;
    static int leftAliveTomatoes = 0;
    static Deque<Mato> queue = new ArrayDeque<>();
    static int maxAge = 0;
    static int[] moveX = {-1, 0, 1, 0};
    static int[] moveY = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        field = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(token.nextToken());
                if (field[i][j] == 0) leftAliveTomatoes++;
                else if (field[i][j] == 1) queue.add(new Mato(i, j, 0));
            }
        }
        
        startProcess();
    }
    
    static boolean validateXY(int x, int y){
        if (x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }
    
    static void startProcess() {
        int nextX, nextY;
        while(!queue.isEmpty()) {
            Mato mato = queue.poll();
            maxAge = mato.age;
            
            for (int i = 0 ; i < 4; i++) {
                nextX = mato.x + moveX[i];
                nextY = mato.y + moveY[i];
                
                if(!validateXY(nextX, nextY)) continue;
                
                if (field[nextX][nextY] == 0) {
                    field[nextX][nextY] = 1;
                    leftAliveTomatoes--;
                    queue.add(new Mato(nextX, nextY, mato.age + 1));
                }
            }
        }
        
        if (leftAliveTomatoes == 0) {
            System.out.println(maxAge);
        } else {
            System.out.println("-1");
        }
    }
}

public class Tomato {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_7576/input.txt"));
        Main.main(args);
    }
}
