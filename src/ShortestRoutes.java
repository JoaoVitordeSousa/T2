import edu.princeton.cs.algs4.*;
import java.util.*;

public class ShortestRoutes {
    static class Edge {
        int to;
        long weight;
        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static long[] dijkstra(int n, List<List<Edge>> graph, int source) {
        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[source] = 0;

        IndexMinPQ<Long> pq = new IndexMinPQ<>(n+1);
        pq.insert(source, 0L);

        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (Edge e : graph.get(v)) {
                if (dist[v] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[v] + e.weight;
                    if (pq.contains(e.to)) {
                        pq.decreaseKey(e.to, dist[e.to]);
                    } else {
                        pq.insert(e.to, dist[e.to]);
                    }
                }
            }
        }
        return dist;
    }
}


