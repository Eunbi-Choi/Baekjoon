package boj1xxxx.p1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //74+220-21+13-81
        //- 뒤 숫자들 모두 묶기
        //{"74+220+3", "21+13", "81"}

        String[] str =  br.readLine().split("\\-");

        int [] r1 = new int[str.length];
        int result = 0;
        for(int i=0; i<str.length; i++) {
            String[] parts = str[i].split("\\+");
            for(int j=0; j<parts.length; j++) {
                r1[i] +=  Integer.parseInt(parts[j]);
            }
        }

        result = r1[0];
        for(int i=1; i<str.length; i++) {
            result -= r1[i];
        }

        System.out.print(result);
    }
}

