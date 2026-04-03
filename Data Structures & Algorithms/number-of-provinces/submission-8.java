class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 1;
        List<Integer> unvisited = new ArrayList(IntStream.range(0, isConnected.length).boxed().toList());

        bfs(0, isConnected, unvisited);

        while (!unvisited.isEmpty()) {
            System.out.println("unvisited = " + unvisited);
            provinces++;
            bfs(unvisited.getFirst(), isConnected, unvisited);
        }

        return provinces;
    }

    private void bfs(int root, int[][] isConnected, List<Integer> unvisited) {
        Queue<Integer> queue = new LinkedList();
        unvisited.remove(new Integer(root));
        queue.add(root);
        System.out.println("queue = " + queue);

        while(!queue.isEmpty()) {
            Integer node = queue.remove();
            unvisited.remove(new Integer(node));
            System.out.println("unvisited = " + unvisited);
            System.out.println("queue = " + queue);
            
            for(int neighbor = 0; neighbor < isConnected.length; neighbor++) {
                if (node == neighbor || isConnected[node][neighbor] == 0) continue;
                if(unvisited.contains(new Integer(neighbor))) {
                    unvisited.remove(new Integer(neighbor));
                    queue.add(new Integer(neighbor));
                    System.out.println("unvisited = " + unvisited);
                    System.out.println("queue = " + queue);
                }
            }
        }
    }
}