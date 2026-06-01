import java.io.*;
import java.util.*;

public class ShortestRoutesVersaoCSES {
    static class Edge {
        int to;
        long weight;
        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State implements Comparable<State> {
        int node;
        long dist;
        State(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
        public int compareTo(State other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int m = fs.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            long w = fs.nextLong();
            graph.get(a).add(new Edge(b, w));
        }

        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(1, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.dist != dist[cur.node]) continue; // lazy deletion

            for (Edge e : graph.get(cur.node)) {
                if (dist[cur.node] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[cur.node] + e.weight;
                    pq.add(new State(e.to, dist[e.to]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Long.MAX_VALUE) sb.append("9223372036854775807 "); // imprime MAX_VALUE
            else sb.append(dist[i]).append(" ");
        }
        PrintWriter out = new PrintWriter(System.out);
        out.println(sb.toString().trim());
        out.flush();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    }
}

