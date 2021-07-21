import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;

        int two[] = new int [2];//声明数组
        
        //暴力二遍循环法，不好
        // for(int i = 0 ;i<len -1;i++){
        //     for(int j=i+1;j<len;j++){

        //         if(nums[i]+ nums[j] == target){
        //             two[0] = i;
        //             two[1] = j;
        //         }
        //     }
        // }



        /**
         *   使用哈希表，即查找表法，在第一遍遍历的时候，将
        结果存入哈希表中，下一次判断哈希表是否存在这个值的
        补数与其对应。
         */

        Map<Integer,Integer> hashMap = new HashMap<>(len -1);
        hashMap.put(nums[0],0);
        for(int i=1;i<len;i++){
            if(hashMap.containsKey(target - nums[i])){
                two[0] = i;
                two[1] = hashMap.get(target - nums[i]);
            }

            hashMap.put(nums[i],i);
        }
        return two;
    }
}
// @lc code=end

