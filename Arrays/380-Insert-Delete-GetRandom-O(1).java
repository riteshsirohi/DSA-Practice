import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

class RandomizedSet {
    private HashSet<Integer> set;
    private ArrayList<Integer> list;
    private Random random;

    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            list.add(val);  // Add the value to the list
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            list.remove((Integer) val);  // Remove the value from the list
            return true;
        }
        return false;
    }

    public int getRandom() {
        if (list.isEmpty()) {
            throw new IllegalStateException(\Set is empty\);
        }
        int randomIndex = random.nextInt(list.size());  // Generate a random index
        return list.get(randomIndex);  // Return the random element
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
