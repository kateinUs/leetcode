package classic;

import java.util.*;

/**
 * @author huimin
 * @create 2022-11-22 17:36
 */
public class BinarySerach {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5, 5};
//        System.out.println(binarySearch(arr, 2));
//        System.out.println(findFirst(arr, 2));
//        System.out.println(findLast(arr, 2));
        int[] arr2 = {1, 3,3, 4,4,4,4, 5};
//        List<Integer> list = Arrays.asList(1, 2, 3);
//        list.forEach(System.out::println);
//        System.out.println(findFirst(arr2, 4));
//        System.out.println(findLast(arr2, 4));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.forEach((k, v) ->System.out.println(k + "->" + v));
        map.values().forEach(System.out::println);
        System.out.println("after set");
        new HashSet(map.values()).forEach(System.out::println);

    }

    // 在排序数组中找一个数，返回该数出现的任意位置，不存在返回-1
    public static int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left +(right - left)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right= mid-1;
            }else{
                return mid;
            }
        }
        // 为什么返回left？？？
        return left;
    }

    public static int findFirst(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }

    public static int findLast(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
}
