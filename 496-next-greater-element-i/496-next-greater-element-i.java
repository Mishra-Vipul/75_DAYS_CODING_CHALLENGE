class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
         int max = Integer.MIN_VALUE;
        for(int i=0;i<nums2.length;i++) {
            max = Math.max(max, nums2[i]);
        }
        int[] map = new int[max + 1];
        Arrays.fill(map, -1);
        Stack<Integer> st = new Stack<>();
        st.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            while (st.size()>0 && nums2[i] > st.peek()) {
                Integer c = st.pop();
                map[c] = nums2[i];            
            } 
            st.push(nums2[i]);            
        }
        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = map[nums1[i]];
        }
        return nums1;
    }
}