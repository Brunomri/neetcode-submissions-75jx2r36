class Solution {
    /* Look for duplicates in the rows, then in the columns, and finally in each 3x3 box */
    public boolean isValidSudoku(char[][] board) {
        
        /* Use sets to validate rows and columns in a single pass */
        for (int x = 0; x < 9; x++) {
            var rowSet = new HashSet<Character>();
            var colSet = new HashSet<Character>();
            for (int y = 0; y < 9; y++) {
                var rowValue = board[x][y];
                var colValue = board[y][x];
                
                /* If the character is not '.' and the insertion in the set fails, then
                the value is duplicated */
                if (rowValue != '.' && !rowSet.add(rowValue)) return false;
                if (colValue != '.' && !colSet.add(colValue)) return false;
            }
            System.out.println("rowSet = " + rowSet);
            System.out.println("colSet = " + colSet);
        }

        /* Since the Sudoku board has a fixed size of 9x9, using this 4 nested loops is actually
        more efficient than the previous version with 2 nested loops, because it avoids
        additional lists constructions, slicing (calls to sublist()), calls to addAll(), and filtering (calls to removeIf()) */
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                var boxSet = new HashSet<Character>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        /* Use the loops indexes to calculate the correct indexes to retrieve from the board
                        considering each 3x3 box. E.g. the first box starts at row 0 and column 0 and ends at
                        row 2 and column 2 */
                        char value = board[boxRow + i][boxCol + j];
                        if (value != '.' && !boxSet.add(value)) return false;
                    }
                }
            }
        }
        return true;
    }
}