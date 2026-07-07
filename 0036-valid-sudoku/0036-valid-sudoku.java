class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Track seen numbers (1-9) for rows, columns, and 3x3 boxes
        // index 0 goes unused so we can map digits 1-9 directly to indices 1-9
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char current = board[r][c];

                // Skip empty cells
                if (current == '.') {
                    continue;
                }

                // Convert char digit to integer numeric value
                int num = current - '0';
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If number already seen in row, column, or sub-box, it's invalid
                if (rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
                    return false;
                }

                // Mark number as seen
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        return true;
    }
}