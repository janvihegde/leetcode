import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;
        
        while (i < n) {
            // Step 1: Find how many words fit in the current line
            int j = i + 1;
            int lineLength = words[i].length(); // Length of words without spaces
            
            // Keep adding words if their length + the minimum spaces needed fits within maxWidth
            while (j < n && lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }
            
            // Step 2: Format the current line
            StringBuilder builder = new StringBuilder();
            int numWords = j - i;
            int totalSpacesToDistribute = maxWidth - lineLength;
            
            // Condition A: Last line OR only one word in the line -> Left Justified
            if (numWords == 1 || j == n) {
                for (int k = i; k < j; k++) {
                    builder.append(words[k]);
                    if (k < j - 1) {
                        builder.append(" ");
                    }
                }
                // Fill the rest of the line with spaces to reach maxWidth
                while (builder.length() < maxWidth) {
                    builder.append(" ");
                }
            } 
            // Condition B: Fully Justified (Multiple words, not the last line)
            else {
                int spacesBetween = totalSpacesToDistribute / (numWords - 1);
                int extraSpaces = totalSpacesToDistribute % (numWords - 1);
                
                for (int k = i; k < j; k++) {
                    builder.append(words[k]);
                    
                    // Add spaces after every word EXCEPT the last word in the line
                    if (k < j - 1) {
                        for (int s = 0; s < spacesBetween; s++) {
                            builder.append(" ");
                        }
                        // Distribute the remainder 'extra' spaces to the leftmost slots
                        if (extraSpaces > 0) {
                            builder.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }
            
            // Add the formatted line to the result and move 'i' forward
            result.add(builder.toString());
            i = j;
        }
        
        return result;
    }
}