import java.util.ArrayList;

class Solution {
    ArrayList<Integer> parent;
    ArrayList<Integer> rank;

    public Solution() {
        parent = new ArrayList<>();
        rank = new ArrayList<>();
    }

    private int find(int x){
        if(x == parent.get(x)){
            return x;
        }
        parent.set(x, find(parent.get(x)));  // Path compression
        return parent.get(x);
    }

    private void union(int x, int y){
        int xParent = find(x);
        int yParent = find(y);

        if(xParent == yParent) return;

        // Union by rank
        if(rank.get(xParent) > rank.get(yParent)){
            parent.set(yParent, xParent);
        } else if(rank.get(xParent) < rank.get(yParent)){
            parent.set(xParent, yParent);
        } else {
            parent.set(xParent, yParent);
            rank.set(yParent, rank.get(yParent) + 1);
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1){
            return -1;
        }

        for(int i = 0; i < n; i++){
            parent.add(i);
            rank.add(0);
        }

        int components = n;

        for(int[] connection : connections){
            if(find(connection[0]) != find(connection[1])){
                union(connection[0], connection[1]);
                components--;
            }
        }

        return components - 1;
    }
}
