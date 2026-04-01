class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        var rowsMap = new HashMap<Integer, List<Character>>();
        var colsMap = new HashMap<Integer, List<Character>>();
        var boxMap = new HashMap<Integer, List<Character>>();

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

        var boxes = new ArrayList<List<Character>>();
        for (int x = 0; x < 7; x = x + 3) {
            var secondRow = x + 1;
            var thirdRow = x + 2;
            for (int y = 0; y < 7; y = y + 3) {
                var boxElements = new ArrayList<Character>();
                var secondCol = y + 1;
                var thirdCol = y + 2;
                var row1 = rowsMap.get(x).subList(y, thirdCol + 1);
                var row2 = rowsMap.get(secondRow).subList(y, thirdCol + 1);
                var row3 = rowsMap.get(thirdRow).subList(y, thirdCol + 1);
                boxElements.addAll(row1);
                boxElements.addAll(row2);
                boxElements.addAll(row3);
                System.out.println("boxElements = " + boxElements);
                boxes.add(boxElements);
            }
        }

        for (List<Character> elements: boxes) {
            elements.removeIf(x -> x == '.');
            var elementsSet = new HashSet<Character>(elements);
            if (elements.size() != elementsSet.size()) {
                return false;
            }
        }
        //System.out.println("boxes = " + boxes);

        return true;
    }
}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}