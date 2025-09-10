package boj1xxxx.p1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //회의의 수
        Meeting[] meetings =  new Meeting[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings[i] = new Meeting(start, end);
        }

        Meeting[] sorted = Arrays.stream(meetings)
                .sorted(Comparator.comparingInt((Meeting m) -> m.end)
                        .thenComparingInt(m -> m.start))
                .toArray(Meeting[]::new);

        int count = 0;
        int lastEnd = 0;
        for(Meeting m : sorted){
            if(m.start >= lastEnd) {
                count++;
                lastEnd = m.end;
            }
        }

        System.out.print(count);
    }
    static class Meeting{
        int start;
        int end;

        Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}

