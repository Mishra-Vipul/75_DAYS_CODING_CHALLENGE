class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k<=1) return nums;
        int[] ngr = ngrIndex(nums);
        
        int j=0;
        int p=0;
        int[] ans = new int[nums.length-k+1];
        int i;
        for( i=0;i<nums.length-k;i++){
            if(j<i){
                j=i;
            }
            while(ngr[j]<i+k){
                j=ngr[j];
            }
            ans[i]=nums[j];
        }
        if(j<i){
                j=i;
            }
        while(ngr[j]<i+k){
                j=ngr[j];
            }
        ans[i]=nums[j];
        
        return ans;
    }
    
    public int[] ngrIndex(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size()>0&&arr[i]>arr[st.peek()]){
                int idx = st.pop();
                ans[idx]=i;
            }
            st.push(i);
        }
        
        while(st.size()>0){
            int idx = st.pop();
            ans[idx]=arr.length;
        }
        
        return ans;
    }
}