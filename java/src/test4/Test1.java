package test4;

import java.util.Arrays;

public class Test1 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] result = Arrays.copyOf(nums1, nums1.length + nums2.length);

        /**将一个数组片段复制到另一个数组的指定位置
         * System.arraycopy(src, srcPos, dest, destPos, length)
         * src: 源数组
         * srcPos: 从源数组复制数据的起始位置
         * dest: 目标数组
         * destPos: 复制到目标数组的起始位置
         * length: 复制的长度
         */
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
        Arrays.sort(result);
        double d = (double)(result[(nums1.length + nums2.length -1)/2] + result[(nums1.length + nums2.length )/2])/2;

        return d;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3};

        double d = findMedianSortedArrays(nums1, nums2);
        System.out.println(d);

    }
}
