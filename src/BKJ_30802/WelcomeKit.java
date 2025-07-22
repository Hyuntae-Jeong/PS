package BKJ_30802;

import java.io.*;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static StringTokenizer tokenize(String input){
        return new StringTokenizer(input);
    }

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(tokenize(br.readLine()).nextToken());

        StringTokenizer tShirtToken = tokenize(br.readLine());
        StringTokenizer packageInfoToken = tokenize(br.readLine());

        int T = Integer.parseInt(packageInfoToken.nextToken());
        int P = Integer.parseInt(packageInfoToken.nextToken());

        // Calculate T-shirt, Pen package counts
        int t_packages = getTShirtPackages(tShirtToken, T);
        String p_packages = getPenPackages(N, P);

        StringBuilder sb = new StringBuilder();
        sb.append(t_packages).append("\n").append(p_packages);

        System.out.println(sb);
    }

    public static int getTShirtPackages(StringTokenizer token, int T) {
        int total = 0, order;

        while (token.hasMoreElements()) {
            int sizeRequesterNum = Integer.parseInt(token.nextToken());
            order = sizeRequesterNum % T == 0 ? sizeRequesterNum / T : sizeRequesterNum / T + 1;
            total += order;
        }

        return total;
    }

    public static String getPenPackages(int N, int P){
        return ( N / P ) + " " + ( N % P );
    }
}

public class WelcomeKit {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BKJ_30802/input.txt"));
        Main.main(args);
    }
}
