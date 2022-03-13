import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = left+k-1;
        int max = nums[0];
        int array = len - k + 1;
        int[] res = new int[array];
        for(int i=0;i<array;i++){
            res[i] = ThreeMax(nums,left,right);
            left++;
            right++;
        }
        return res;
    }
    public int ThreeMax(int[] nums,int left,int right){
        int max = nums[left];
        for(int i=left;i<right+1;i++){
            if(nums[i]>max)max = nums[i];
        }
        return max;
    }


public static void main(String[] args) {
    Solution test = new Solution();

}
}
