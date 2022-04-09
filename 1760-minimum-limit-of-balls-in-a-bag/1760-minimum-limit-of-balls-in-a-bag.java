class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int beg = 1;
        int end = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>end) end=nums[i];
        }
        int ans = 0;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(isPossible(nums, mid, maxOperations)==true){
                ans=mid;
                end = mid-1;
            }else{
                beg=mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[] arr, int mid, int m){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i]/mid;
            if(arr[i]%mid==0) sum--;
        }
        return sum<=m;
    }
}