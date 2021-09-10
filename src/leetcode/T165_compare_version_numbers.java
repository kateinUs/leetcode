package leetcode;

import java.net.Inet4Address;

/**
 * 1. split version by '.' and save them into string array
 * 2. compare each version number in array, make up 0 if there is none
 * @author huimin
 * @create 2021-09-09 4:52
 */
public class T165_compare_version_numbers {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int len1 = nums1.length;
        int len2 = nums2.length;

        for(int i=0; i<Math.max(len1, len2); i++){
            int ver1 = (len1 > i)? Integer.parseInt(nums1[i]) : 0;
            int ver2 = (len2 > i)? Integer.parseInt(nums2[i]) : 0;

            if(ver1 != ver2)
                return (ver1 > ver2)? 1: -1;
        }

        return 0;
    }
}
