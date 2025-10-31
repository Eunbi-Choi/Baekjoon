package boj1xxxx.p1939;

import java.io.*;
import java.util.*;

//이분 탐색 + BFS 방식
public class Main {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int N, M;
    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        int maxWeight = 0;
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
            maxWeight = Math.max(maxWeight, c);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int left = 1, right = maxWeight, answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (bfs(start, end, mid)) {
                answer = mid;
                left = mid + 1; // 더 무겁게 시도
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean bfs(int start, int end, int limit) {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == end) return true;
            for (Edge e : graph[cur]) {
                if (!visited[e.to] && e.weight >= limit) {
                    visited[e.to] = true;
                    q.add(e.to);
                }
            }
        }
        return false;
    }
}

//MST (Union-Find) 방식
/*
import java.io.*;
        import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int u, v, weight;
        Edge(int u, int v, int weight) {
            this.u = u; this.v = v; this.weight = weight;
        }
        public int compareTo(Edge o) {
            return o.weight - this.weight; // 내림차순
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // Union-Find 초기화
        parent = new int[N+1];
        for (int i=1; i<=N; i++) parent[i] = i;

        // 간선 내림차순 정렬
        Collections.sort(edges);

        for (Edge e : edges) {
            union(e.u, e.v);
            if (find(start) == find(end)) {
                System.out.println(e.weight);
                return;
            }
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}
*/

