package BKJ_10814;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Map<Integer, ArrayList<String>> map = new TreeMap<>();
    static StringTokenizer token;
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        initializeMembers();
        printMembers();
    }
    
    public static void initializeMembers() throws IOException {
        Integer age; String name;
        
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            
            age = (Integer) Integer.parseInt(token.nextToken());
            name = token.nextToken();
            
            map.putIfAbsent(age, new ArrayList<>());
            map.get(age).add(name);
        }
    }
    
    public static void printMembers() {
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
            int age = entry.getKey();
            
            for (String name : entry.getValue()) {
                sb.append(age).append(" ").append(name).append("\n");
            }
        }

        System.out.println(sb);
    }
}



public class SortingMembers {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_10814/input.txt"));
        Main.main(args);
    }
}
