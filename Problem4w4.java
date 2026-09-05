import java.util.HashMap;

public class Problem4w4 {

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Empty prefix
        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum = currentSum + num;

            // Check if currentSum - k exists
            if (map.containsKey(currentSum - k)) {
                count = count + map.get(currentSum - k);
            }

            // Store prefix sum
            map.put(currentSum,
                    map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println("Number of subarrays = " + result);
    }
}