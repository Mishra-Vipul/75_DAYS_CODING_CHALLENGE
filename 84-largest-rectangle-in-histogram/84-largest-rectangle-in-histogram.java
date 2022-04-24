class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int[] nsl = nslIndex(heights);
        int[] nsr = nsrIndex(heights);
        
        
        for(int i=0;i<heights.length;i++){
            int ht = heights[i];
            int wd = nsr[i]-nsl[i]-1;
            maxArea = Math.max(maxArea,ht*wd);
        }
        
        return maxArea;
    }
    public int[] nslIndex(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        st.push(arr.length-1);
        
        for(int i = arr.length-2;i>=0;i--){
            while(st.size()>0&& arr[i]<arr[st.peek()]){
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        
        while(st.size()>0){
            int idx = st.pop();
            ans[idx] = -1;
        }
        return ans;
    }
    public int[] nsrIndex(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        st.push(0);
        
        for(int i = 1;i<arr.length;i++){
            while(st.size()>0&& arr[i]<arr[st.peek()]){
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        
        while(st.size()>0){
            int idx = st.pop();
            ans[idx] = arr.length;
        }
        return ans;
    }
    
}