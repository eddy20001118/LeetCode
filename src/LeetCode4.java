public class LeetCode4 {
    public static void main(String[] args) {
        LeetCode4 leetCode4 = new LeetCode4();
        int[] A = {1,2,7,10};
        int[] B = {0,10,23,24};
        System.out.println(leetCode4.findMedianSortedArrays(A, B));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int cutTotal = nums1.length + nums2.length;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;

        while (cut1 <= nums1.length) {
            if (nums1.length > nums2.length)
                return findMedianSortedArrays(nums2, nums1);
            cut1 = (cutR - cutL) / 2 + cutL; //cut1 , cut2 是nums1 ， nums2作为有多少个元素（就是索引）
            cut2 = cutTotal / 2 - cut1;
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) {
                cutR = cut1 - 1;  //左移一位
            } else if (L2 > R1) {
                cutL = cut1 + 1; //右移一位
            } else {
                if (cutTotal % 2 != 0) {
                    return (R1 < R2) ? R1 : R2;
                } else {
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 < R2 ? R1 : R2;
                    return (L1 + R1) / 2;
                }
            }
        }
        return -1;
    }
}
