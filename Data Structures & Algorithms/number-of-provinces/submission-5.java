class Solution {
    /* Key idea is to run multiple DFS until all nodes are visited, 
    when a DFS run finished and there are still unvisited nodes, we increment the provinces count */
    public int findCircleNum(int[][] isConnected) {
        int provinces = 1;
        List<Integer> unvisited = new ArrayList(IntStream.range(0, isConnected.length).boxed().toList());
        System.out.println("unvisited = " + unvisited);

        /* Start DFS at node 0 */
        dfs(0, isConnected, unvisited);
        /* While there are unvisited nodes, increment the provinces count and
        run a DFS for the next unvisited node */
        while(unvisited.size() > 0) {
            provinces++;
            dfs(unvisited.getFirst(), isConnected, unvisited);
        }

        return provinces;
    }

    private void dfs(int nodeIndex, int[][] isConnected, List<Integer> unvisited) {
        System.out.println("node = " + nodeIndex);
        if (isConnected[nodeIndex] == null) return;
        /* Remove visited node */
        unvisited.remove(new Integer(nodeIndex));
        System.out.println("unvisited = " + unvisited);
        for (int neighborIndex = 0; neighborIndex < isConnected.length; neighborIndex++) {
            /* Skip the current node itself and the other nodes that are not connected to it  */
            if (neighborIndex == nodeIndex || isConnected[nodeIndex][neighborIndex] == 0) continue;
            /* Visit the connected neighbors */
            if (unvisited.contains(neighborIndex)) {
                System.out.println("neighbor = " + neighborIndex);
                dfs(neighborIndex, isConnected, unvisited);
            }
        }
    }
}