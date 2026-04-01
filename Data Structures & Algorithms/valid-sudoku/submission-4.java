class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        var rowsMap = new HashMap<Integer, List<Character>>();
        var colsMap = new HashMap<Integer, List<Character>>();

        /* Build a map for the rows where the key is the row index in the board
        and the value is the list of elements in that row */
        for (int x = 0; x < 9; x++) {
            var rowValues = new ArrayList<Character>();
            for (int y = 0; y < 9; y++) {
                //var position = new Position(x, y);
                var value = board[x][y];
                rowValues.add(value);
            }
            rowsMap.put(x, rowValues);
            System.out.println("row = " + x + " value = " + rowsMap.get(x));
        }

        /* Build a map for the columns where the key is the column index in the board
        and the value is the list of elements in that columns */
        for (int y = 0; y < 9; y++) {
            var colValues = new ArrayList<Character>();
            for (int x = 0; x < 9; x++) {
                //var position = new Position(x, y);
                var value = board[x][y];
                colValues.add(value);
            }
            colsMap.put(y, colValues);
            System.out.println("col = " + y + " value = " + colsMap.get(y));
        }

        /* Iterate over the rows and columns maps trying to build sets from them
        to find the duplicates */
        for (int i = 0; i < 9; i++) {
            var row = rowsMap.get(i).stream().filter(x -> x != '.').toList();
            //System.out.println("row = " + row);
            var rowSet = new HashSet<Character>(row);
            //System.out.println("rowSet = " + rowSet);
            if (row.size() != rowSet.size()) {
                return false;
            }

            var col = colsMap.get(i).stream().filter(x -> x != '.').toList();
            //System.out.println("col = " + col);
            var colSet = new HashSet<Character>(col);
            //System.out.println("colSet = " + colSet);
            if (col.size() != colSet.size()) {
                return false;
            }
        }

        /* Use a list of lists to represent each 3x3 box and its elements */
        var boxes = new ArrayList<List<Character>>();
        /* Outer loop iterates over the rows 0, 3 and 6, that are the starting rows
        of each 3x3 box */
        for (int x = 0; x < 7; x = x + 3) {
            /* The second and third rows of each box are derived from the first by adding 1 and 2 respectively */
            var secondRow = x + 1;
            var thirdRow = x + 2;
            /* Inner loop iterates over the columns 0, 3 and 6, that are the starting columns
            of each 3x3 box */
            for (int y = 0; y < 7; y = y + 3) {
                /* The second and third colums of each box are derived from the first by adding 1 and 2 respectively */
                var secondCol = y + 1;
                var thirdCol = y + 2;

                /* Use the indexes calculated above to find in the map of rows the sublists with 3 elements
                that correspond to each of the 3 rows in a box */
                var boxElements = new ArrayList<Character>();
                var row1 = rowsMap.get(x).subList(y, thirdCol + 1);
                var row2 = rowsMap.get(secondRow).subList(y, thirdCol + 1);
                var row3 = rowsMap.get(thirdRow).subList(y, thirdCol + 1);
                /* Store in boxElements all the elements from the current box */
                boxElements.addAll(row1);
                boxElements.addAll(row2);
                boxElements.addAll(row3);
                //System.out.println("boxElements = " + boxElements);
                /* Store the elements of all the boxes in boxes list of lists */
                boxes.add(boxElements);
            }
        }

        /* Iterate over the elements of every box, remove the '.' character, and craete a set from the list
        of elements from every box */
        for (List<Character> elements: boxes) {
            elements.removeIf(x -> x == '.');
            var elementsSet = new HashSet<Character>(elements);
            /* If the size of the set is different to the size of the list, this means
            the box has duplicated elements */
            if (elements.size() != elementsSet.size()) {
                return false;
            }
        }
        //System.out.println("boxes = " + boxes);

        return true;
    }
}