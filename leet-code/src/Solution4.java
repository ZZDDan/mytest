/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2019/6/26 11:14
 *
    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    你可以假设 nums1 和 nums2 不会同时为空。

    示例 1:
        nums1 = [1, 3]
        nums2 = [2]
        则中位数是 2.0

    示例 2:
        nums1 = [1, 2]
        nums2 = [3, 4]
        则中位数是 (2 + 3)/2 = 2.5
 */
public class Solution4 {

    public static void main(String[] args) {
        int[] nums1 = {3};
        int[] nums2 = {-2,-1};
        System.out.println(new Solution4().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = len1 - 1;
        int index2 = len2 - 1;
        int midI = (len1 + len2)/2 - 1;

        double midN;

        if(len1 == 0){
            while(midI > 1){
                index2--;
            }

            if(len2%2 == 1){
                midN = nums2[index2];
            } else {
                midN = (nums2[index2] + nums2[index2 - 1]) / 2.0;
            }

            return midN;
        }

        if(len2 == 0){
            while(midI > 1){
                index1--;
            }

            if(len1%2 == 1){
                midN = nums1[index1];
            } else {
                midN = (nums1[index1] + nums1[index1 - 1]) / 2.0;
            }

            return midN;
        }


        while(midI > 0){
            midI--;
            if(nums1[index1] > nums2[index2] && index1 > 0){
                index1--;
            } else if(nums1[index1] <= nums2[index2] && index2 > 0) {
                index2--;
            }
        }

        if((len1 + len2)%2 == 1){
            if(nums1[index1] > nums2[index2]){
                midN = nums1[index1];
            } else {
                midN = nums2[index2];
            }
        } else {
            midN = (nums1[index1] + nums2[index2]) / 2.0;
        }

        return midN;
    }
}
