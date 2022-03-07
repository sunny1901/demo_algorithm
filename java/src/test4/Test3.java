package test4;


/**
 * 1. 总长(m + n) / 2 = 绝对中间位。
 *              但不能这么干。
 * 2. 这么干：
 *      2.1 在数组1，随便切一刀。（可以选中间）
 *      2.2 数字2下刀位置，  公式： 总长/2 = num1_Left + num2_Left
 *                                 总长/2 - num1_Left = num2_Left(下刀位置)
 *                          右边也知道了
 * 3. 正确位置：( 左边的元素都小于右边的元素  )
 *      3.1 公式 num1_Left < = num2_Rigth
 *               num2_Left <= num1_Right
 * 4. 非正确下刀位置：
 *      4.1 ，num1_Left > num2_right
 *      4.2 , num2_Left > num1_Left
 * */
public class Test3 {

    /**
     * 第三种解法：二分查找法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (find(nums1, 0, nums2, 0, left) + find(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     * 在nums1和nums2中找出第k小的元素
     *
     * @param nums1 nums1数组
     * @param i     nums1数组的起始位置
     * @param nums2 nums2数组
     * @param j     nums2数组的起始位置
     * @param k     需要找到的元素的序号
     * @return 第k小的元素值
     */
    public static int find(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length)
            return nums2[j + k - 1]; // nums1数组全部被舍弃
        if (j >= nums2.length)
            return nums1[i + k - 1]; // nums2数组全部被舍弃
        // 当k = 1 的时候，两个数组的布局基本相同，最后只需要找到
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        /*
         * 分别找到两个数组中的第k/2位置的元素，如果不存在就给他赋最大值， 比较两个值，值小的数组则淘汰其前k/2个元素 最后把k也减去k/2，继续递归
         */
        int mid1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 < mid2) {
            return find(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return find(nums1, i, nums2, j + k / 2, k - k / 2);
        }

    }


        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if(nums1.length > nums2.length){
                return findMedianSortedArrays(nums2, nums1);
            }
            int len = nums1.length + nums2.length;
            int cut1 = 0;
            int cut2 = 0;
            int cutL = 0;
            int cutR = nums1.length;
            while(cut1 <= nums1.length){
                cut1 = (cutR - cutL)/2 + cutL;
                cut2 = len/2 - cut1;
                double L1 = (cut1 == 0 )? Integer.MIN_VALUE:nums1[cut1 - 1];
                double L2 = (cut2 == 0 )? Integer.MIN_VALUE:nums2[cut2 - 1];
                double R1 = (cut1 == nums1.length )? Integer.MAX_VALUE:nums1[cut1];
                double R2 = (cut2 == nums2.length )? Integer.MAX_VALUE:nums2[cut2];
                if(L1>R2){
                    cutR = cut1 - 1;
                }else if(L2 > R1){
                    cutL = cut1 + 1;
                }else{
                    if(len %2 == 0){
                        L1 = (L1 > L2) ? L1 : L2;
                        R1 = (R1 > R2 )? R2 : R1;
                        return (L1+R1)/2;
                    }else{
                        R1 = (R1 < R2) ? R1 : R2;
                        return R1;
                    }
                }
            }
            return -1;
        }


    public static void main(String[] args) {
//        int[] nums1 = { 9, 10, 11, 12, 13, 14 };
//        int[] nums2 = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };
//      int[] nums1 = { 1 };
//      int[] nums2 = { 2 };
        int[] nums1 = {1};
        int[] nums2 = {3,4};

        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

}
