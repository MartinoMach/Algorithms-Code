package Problem4;


/* PROBLEM 4
 * 
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, 
 * return the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
*/
class Problem_4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int size = nums1.length + nums2.length;
	    int[] nums3 = new int[size];
	    int m = 0, n = 0;
	    for(int i = 0; i < (size/2)+1; i++) {
	        if(m < nums1.length && n < nums2.length) {
	            if(nums2[n] >= nums1[m]) {
	            nums3[i] = nums1[m++];
	          } else {
	            nums3[i] = nums2[n++];
	          }
	        } else if (m >= nums1.length) {
	            nums3[i] = nums2[n++];
	        } else if (n >= nums2.length) {
	            nums3[i] = nums1[m++];
	        }
	    }
	    if(size % 2 == 1) {
	        return nums3[size/2];
	    }
	    return (nums3[size/2] + nums3[(size/2)- 1])/2.0;
	}
}
