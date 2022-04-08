class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if(weights.length==1&&days==1) return weights[0];
        int beg = Integer.MIN_VALUE;
        int end = 0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]>beg) beg = weights[i];
            end+=weights[i];
        }
        
        int ans=beg+(end-beg)/2;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(isPossible(weights,mid,days)==true){
                ans = mid;
                end = mid-1;
            }
            else{
                beg=mid+1;
            }
        }
        
        return ans;
    }
    
    public boolean isPossible(int[] arr, int mid, int days){
        int day=1;
        int sum=0;
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            
            if(sum>mid){
                sum=arr[i];
                day++;
            }
        }
        
        return day<=days;
        
    }
}