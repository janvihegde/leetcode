class Solution {
    public String convert(String s, int numRows) {
        // 1. Handle edge cases
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // 2. Create an array of StringBuilders for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // 3. Traverse the string and place characters in the correct row
        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            
            // Change direction if we hit the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move up or down
            currentRow += goingDown ? 1 : -1;
        }

        // 4. Combine all the rows into one final string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}