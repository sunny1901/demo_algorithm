package test4;

import java.util.Arrays;

public class Test2 {

    /**
     * 第二种解法：和第一种一样，不过利用位运算，可以优化计算
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length < 2 && nums2.length < 2) {
            if (nums1.length == 0) {
                return (double) nums2[0];
            } else if (nums2.length == 0) {
                return (double) nums1[0];
            }
            return (double) (nums1[0] + nums2[0]) / 2;
        }
        int[] result = Arrays.copyOf(nums1, nums1.length + nums2.length);
        /**
         * 将一个数组片段复制到另一个数组的指定位置 System.arraycopy(src, srcPos, dest, destPos, length)
         * src: 源数组 srcPos: 从源数组复制数据的起始位置 dest: 目标数组 destPos: 复制到目标数组的起始位置 length: 复制的长度
         */
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
        Arrays.sort(result);
        int mid = result.length >> 1;
        if ((result.length & 1) == 1) {
            return (double) result[(result.length - 1) >> 1];
        } else {
            return (double) (result[mid - 1] + result[mid]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 9, 10, 11, 12, 13, 14 };
        int[] nums2 = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };
//      int[] nums1 = { 1 };
//      int[] nums2 = { 2 };

        System.out.println(findMedianSortedArrays2(nums1, nums2));

    }

}
