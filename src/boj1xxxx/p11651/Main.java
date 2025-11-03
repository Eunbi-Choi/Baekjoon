package boj1xxxx.p11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //점의 개수 N

        List<Point> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String[] parts = br.readLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            list.add(new Point(x, y));
        }

        list.sort((p1, p2) -> {
            if(p1.y == p2.y) return p1.x - p2.x;
            return p1.y - p2.y;
        });

        StringBuilder sb = new StringBuilder();
        for(Point p: list) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }

        System.out.print(sb);
    }
}
