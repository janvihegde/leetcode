import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    // List to store the actual values for O(1) getRandom
    private List<Integer> nums;
    // Map to store value -> index for O(1) lookups
    private Map<Integer, Integer> valToIndex;
    private Random rand;

    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        // If the value is already present, return false
        if (valToIndex.containsKey(val)) {
            return false;
        }
        
        // Add to the map: value -> current size of the list (which will be its index)
        valToIndex.put(val, nums.size());
        // Add to the end of the list
        nums.add(val);
        
        return true;
    }
    
    public boolean remove(int val) {
        // If the value doesn't exist, we can't remove it
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        
        // 1. Get the index of the element we want to remove
        int indexToRemove = valToIndex.get(val);
        
        // 2. Get the value of the very last element in the list
        int lastElement = nums.get(nums.size() - 1);
        
        // 3. Swap the last element into the position of the element we want to remove
        nums.set(indexToRemove, lastElement);
        
        // 4. Update the map so the last element points to its new index
        valToIndex.put(lastElement, indexToRemove);
        
        // 5. Remove the last element from the list (O(1) operation)
        nums.remove(nums.size() - 1);
        
        // 6. Remove the target value from the map
        valToIndex.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        // Pick a random index from 0 to nums.size() - 1
        int randomIndex = rand.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}