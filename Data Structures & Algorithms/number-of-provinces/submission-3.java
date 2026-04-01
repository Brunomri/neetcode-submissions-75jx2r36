class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 1;
        //List<Integer> visited = new ArrayList<>();
        List<Integer> unvisited = new ArrayList(IntStream.range(0, isConnected.length).boxed().toList());
        System.out.println("unvisited = " + unvisited);

        dfs(0, isConnected, unvisited);
        while(unvisited.size() > 0) {
            provinces++;
            dfs(unvisited.getFirst(), isConnected, unvisited);
        }

        return provinces;
    }

    private void dfs(int nodeIndex, int[][] isConnected, List<Integer> unvisited) {
        System.out.println("node = " + nodeIndex);
        if (nodeIndex > isConnected.length - 1 || isConnected[nodeIndex] == null) return;
        unvisited.remove(new Integer(nodeIndex));
        System.out.println("unvisited = " + unvisited);
        for (int neighbourIndex = 0; neighbourIndex < isConnected.length; neighbourIndex++) {
            if (neighbourIndex == nodeIndex || isConnected[nodeIndex][neighbourIndex] == 0) continue;
            if (unvisited.contains(neighbourIndex)) {
                System.out.println("neighbour = " + neighbourIndex);
                dfs(neighbourIndex, isConnected, unvisited);
            }
        }
    }
}