class Solution {
    public int splitArray(int[] nums, int m) {
        int beg = 0;
        int end = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>beg) beg = nums[i];
            end+=nums[i];
        }
        int ans = 0;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(isPossible(nums,mid,m)==true){
                ans = mid;
                end = mid-1;
            }else{
                beg = mid+1;
            }
        }
        return  ans;
    }
    
    public boolean isPossible(int[] nums, int mid, int m){
        int sum=0;
        int n=1;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                sum=nums[i];
                n++;
            }
        }
        
        return n<=m;
    }
    
}