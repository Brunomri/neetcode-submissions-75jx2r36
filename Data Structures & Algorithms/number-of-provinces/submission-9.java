class Solution {
    /* Key idea is to run multiple DFS until all nodes are visited, 
    when a BFS run finished and there are still unvisited nodes, we increment the provinces count */
    public int findCircleNum(int[][] isConnected) {
        int provinces = 1;
        List<Integer> unvisited = new ArrayList(IntStream.range(0, isConnected.length).boxed().toList());

        /* Start BFS at node 0 */
        bfs(0, isConnected, unvisited);

        /* While there are unvisited nodes, increment the provinces count and
        run a BFS for the next unvisited node */
        while (!unvisited.isEmpty()) {
            System.out.println("unvisited = " + unvisited);
            provinces++;
            bfs(unvisited.getFirst(), isConnected, unvisited);
        }

        return provinces;
    }

    private void bfs(int root, int[][] isConnected, List<Integer> unvisited) {
        Queue<Integer> queue = new LinkedList();
        /* Remove visited node */
        unvisited.remove(new Integer(root));
        queue.add(root);
        System.out.println("queue = " + queue);

        while(!queue.isEmpty()) {
            Integer node = queue.remove();
            /* Remove visited node */
            //unvisited.remove(new Integer(node));
            System.out.println("unvisited = " + unvisited);
            System.out.println("queue = " + queue);
            
            for(int neighbor = 0; neighbor < isConnected.length; neighbor++) {
                if (node == neighbor || isConnected[node][neighbor] == 0) continue;
                if(unvisited.contains(new Integer(neighbor))) {
                    /* Remove visited node */
                    unvisited.remove(new Integer(neighbor));
                    queue.add(new Integer(neighbor));
                    System.out.println("unvisited = " + unvisited);
                    System.out.println("queue = " + queue);
                }
            }
        }
    }
}