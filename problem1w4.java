import java.util.Arrays;

public class Problem1w4 {

    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int product = 1;

        // Product of elements to the left
        for (int i = 0; i < n; i++) {
            answer[i] = product;
            product = product * nums[i];
        }

        product = 1;

        // Product of elements to the right
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * product;
            product = product * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(result));
    }
}