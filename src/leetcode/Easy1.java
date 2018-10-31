package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Easy1 {
	
	/*
	 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
		你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
	 */
	
	/*
	 * my answer
	 */
	 public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			boolean flag = false;
			for (int j = 0; j < nums.length; j++) {
				if(nums[i]+nums[j]==target&&i!=j){
					res[0] = i;
					res[1] = j;
					flag = true;
					break;
				}
			}
				if(flag){
					break;
				}
		}
		return res;
	   }
	 
	 /*
	  * 暴力法
	  */
	 public int[] twoSum1(int[] nums, int target) {
		    for (int i = 0; i < nums.length; i++) {
		        for (int j = i + 1; j < nums.length; j++) {
		            if (nums[j] == target - nums[i]) {
		                return new int[] { i, j };
		            }
		        }
		    }
		    throw new IllegalArgumentException("No two sum solution");
		}
	 
	 
	 /*
	  * 两遍hash表
	  */
	 public int[] twoSum2(int[] nums, int target) {
		    Map<Integer, Integer> map = new HashMap<>();
		    for (int i = 0; i < nums.length; i++) {
		        map.put(nums[i], i);
		    }
		    for (int i = 0; i < nums.length; i++) {
		        int complement = target - nums[i];
		        if (map.containsKey(complement) && map.get(complement) != i) {
		            return new int[] { i, map.get(complement) };
		        }
		    }
		    throw new IllegalArgumentException("No two sum solution");
		}
	 
	 /*
	  * 一遍hash表
	  */
	 public int[] twoSum3(int[] nums, int target) {
		    Map<Integer, Integer> map = new HashMap<>();
		    for (int i = 0; i < nums.length; i++) {
		        int complement = target - nums[i];
		        if (map.containsKey(complement)) {
		            return new int[] { map.get(complement), i };
		        }
		        map.put(nums[i], i);
		    }
		    throw new IllegalArgumentException("No two sum solution");
		}
	 
	public static void main(String[] args) {
		Easy1 a = new Easy1();
		int[] ss = {2,7,11,15};
		int[] b = a.twoSum(ss,4);
		System.out.println(Arrays.toString(b));
	}
	
}
