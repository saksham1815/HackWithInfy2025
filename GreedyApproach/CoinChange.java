
// 646. Maximum Length of Pair Chain
// https://leetcode.com/problems/maximum-length-of-pair-chain/
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class MaxLenPAIR {
    public int findLongestChain(int[][] pairs) {
        // Sort pairs by the second element of each pair
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        
        int count = 0;
        int end = Integer.MIN_VALUE; // Initialize end to the smallest possible value
        
        for (int[] pair : pairs) {
            if (pair[0] > end) { // If the start of the current pair is greater than the end of the last selected pair
                count++; // Increment the count of pairs in the chain
                end = pair[1]; // Update end to the second element of the current pair
            }
        }
        
        return count; // Return the maximum length of the pair chain
    }
}4