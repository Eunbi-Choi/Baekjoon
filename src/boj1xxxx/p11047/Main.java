package boj1xxxx.p11047;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for(int i=0; i<N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i=N-1; i>=0; i--){
            if(coins[i] <= K) {
                count += K/coins[i];
                K %= coins[i];
            }
        }

        System.out.print(count);
    }
}
