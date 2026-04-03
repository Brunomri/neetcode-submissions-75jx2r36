class Solution {
    /* Key idea is to run multiple DFS until all nodes are visited, 
    when a DFS run finished and there are still unvisited nodes, we increment the provinces count */
    public int findCircleNum(int[][] isConnected) {
        int provinces = 1;

        /* Start DFS at node 0 */
        dfs(0, isConnected);
        
        /* Use the diagonal of isConnected matrix to track the visited nodes instead of a dedicated list */
        for(int i = 0; i < isConnected.length; i++) {
            /* If the diagonal value is 1, this means the node is unvisited */
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
        /* Set diagonal node value to 0, indicating it's visited */
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