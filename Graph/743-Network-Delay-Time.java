class Solution {
    class Pair {
        int distance;
        int node;

        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] vec : times) {
            int u = vec[0] - 1; 
            int v = vec[1] - 1; 
            int w = vec[2];
            adj.get(u).add(new int[] { v, w });
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));

        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[k - 1] = 0;

        pq.offer(new Pair(0, k - 1)); 

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int dist = curr.distance;
            int node = curr.node;

            for (int[] vec : adj.get(node)) {
                int adjNode = vec[0];
                int wt = vec[1];

                if (dist + wt < res[adjNode]) {
                    res[adjNode] = dist + wt;
                    pq.offer(new Pair(dist + wt, adjNode));
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, res[i]);
        }

        return ans;
    }
}
