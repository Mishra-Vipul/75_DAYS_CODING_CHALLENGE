class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int sp=numRows/2 +3;
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> sub = new ArrayList<>();
            int x=1;
            for(int j=0;j<=i;j++){
                sub.add(x);
                x=((i-j)*x)/(j+1);
            }
            
            ans.add(sub);
        }
        
        return ans;
    }
}