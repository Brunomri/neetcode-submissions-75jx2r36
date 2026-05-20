class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) return false;

        for (int i = 0; i < matrix.length; i++) {
            if (target > matrix[i][matrix[0].length - 1]) continue;
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] row, int target) {
        int left = 0, right = row.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (row[mid] == target) return true;

            else if (row[mid] < target) left = mid + 1;

            else right = mid - 1;
        }

        return false;
    }
}
