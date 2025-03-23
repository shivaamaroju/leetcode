import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;
        int ways[] = new int[n];
        HashMap<Integer, List<Pair>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.put(i, new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int x = roads[i][0];
            mp.get(x).add(new Pair(roads[i][1], roads[i][2]));
            int y = roads[i][1];
            mp.get(y).add(new Pair(roads[i][0], roads[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.d, y.d));
        long dist[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair x = pq.poll();
            int v = x.v;
            long d = x.d;

            if (d > dist[v]) continue;  // Ignore outdated distances

            for (var s : mp.get(v)) {
                int y = s.v;
                long dist1 = s.d;

                if (d + dist1 < dist[y]) {
                    dist[y] = d + dist1;
                    ways[y] = ways[v];  // Reset path count to only this new shortest path
                    pq.add(new Pair(y, dist[y]));
                } else if (d + dist1 == dist[y]) {
                    ways[y] = (ways[y] + ways[v]) % MOD;  // Add paths correctly
                }
            }
        }
        return ways[n - 1];
    }
}

class Pair {
    int v;
    long d;  // Change to long to prevent overflow

    public Pair(int v, long d) {
        this.v = v;
        this.d = d;
    }
}
