class Solution {
    /* Key idea is to run multiple DFS until all nodes are visited, 
    when a DFS run finished and there are still unvisited nodes, we increment the provinces count */
    public int findCircleNum(int[][] isConnected) {
        int provinces = 1;

        /* Start DFS at node 0 */
        dfs(0, isConnected);
        /* While there are unvisited nodes, increment the provinces count and
        run a DFS for the next unvisited node */
        /*while(unvisited.size() > 0) {
            provinces++;
            dfs(unvisited.getFirst(), isConnected);
        }*/
        for(int i = 0; i < isConnected.length; i++) {
            if (isConnected[i][i] == 1) {
                provinces++;
                System.out.println("provinces = " + provinces);
                dfs(i, isConnected);
            }
        }

        return provinces;
    }

    private void dfs(int nodeIndex, int[][] isConnected) {
        System.out.println("node = " + nodeIndex);
        if (isConnected[nodeIndex] == null) return;
        /* Remove visited node */
        isConnected[nodeIndex][nodeIndex] = 0;
        
        for (int neighborIndex = 0; neighborIndex < isConnected.length; neighborIndex++) {
            /* Skip the current node itself and the other nodes that are not connected to it  */
            if (neighborIndex == nodeIndex || isConnected[nodeIndex][neighborIndex] == 0) {
                System.out.println("Node itself or skipping neighbor = " + neighborIndex);
                continue;
            }
            /* Visit the connected neighbors */
            if (isConnected[neighborIndex][neighborIndex] == 1) {
                System.out.println("neighbor = " + neighborIndex);
                dfs(neighborIndex, isConnected);
            }
        }
    }
}