class Solution {
    /* Look for duplicates in the rows, then in the columns, and finally in each 3x3 box */
    public boolean isValidSudoku(char[][] board) {
        
        /* Build a map for the rows where the key is the row index in the board
        and the value is the list of elements in that row */
        for (int x = 0; x < 9; x++) {
            var rowSet = new HashSet<Character>();
            var colSet = new HashSet<Character>();
            for (int y = 0; y < 9; y++) {
                //var position = new Position(x, y);
                var rowValue = board[x][y];
                var colValue = board[y][x];
                
                if (rowValue != '.' && !rowSet.add(rowValue)) return false;
                if (colValue != '.' && !colSet.add(colValue)) return false;
            }
            System.out.println("rowSet = " + rowSet);
            System.out.println("colSet = " + colSet);
        }

        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                var boxSet = new HashSet<Character>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char value = board[boxRow + i][boxCol + j];
                        if (value != '.' && !boxSet.add(value)) return false;
                    }
                }
            }
        }
        return true;
    }
}