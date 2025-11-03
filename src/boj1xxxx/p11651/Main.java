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

        /* 비교 결과 리턴값의 의미
            음수 ( < 0 ) -> p1이 p2보다 앞에 옴
            0 -> 두 객체가 동일한 순서
            양수 ( < 0 ) -> p1이 p2보다 뒤에 옴

            y가 작은 순서 -> 같으면 x가 작은 순서로 정렬하라
        */
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
