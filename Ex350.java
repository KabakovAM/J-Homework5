package Homework5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Ex350 {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 3, 2, 1 };
        int[] nums2 = new int[] { 3, 3, 2, 2, 4 };
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                if (map.get(nums2[i]) > 1) {
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                } else {
                    map.remove(nums2[i]);
                }
                resultList.add(nums2[i]);
            }
        }
        int[] result = resultList.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
