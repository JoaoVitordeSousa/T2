import edu.princeton.cs.algs4.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        In in = new In("dados\\entradas_do_problema.txt");
        int n = in.readInt();
        int m = in.readInt();

        List<List<ShortestRoutes.Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = in.readInt();
            int b = in.readInt();
            long w = in.readLong();
            graph.get(a).add(new ShortestRoutes.Edge(b, w));
        }

        long[] dist = ShortestRoutes.dijkstra(n, graph, 1);

        for (int i = 1; i <= n; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}
