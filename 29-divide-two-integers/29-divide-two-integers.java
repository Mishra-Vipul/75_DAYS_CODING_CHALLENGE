class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign = true;
        if(dividend==0) return 0;
        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) sign = false;
        
        long divid = dividend;
        long divis = divisor;
        divid = divid<0?-1*divid:divid;
        divis = divis<0?-1*divis:divis;
        
        if(divid == divis) return sign?1:-1;
        
        long value = divis;
        long quo = 0;
        int count = 0;
        
        while((value<<1)<=divid){
            value = value<<1;
            count++;
        }
        
        
        if(divid>divis) quo+=Math.pow(2,count);
                  
        while(divis<=divid-value){
            value+=divis;
            quo++;
        }
        long ans;
        if(sign == true) ans = quo;
        else ans = -quo;
        if(ans>Integer.MAX_VALUE) ans = Integer.MAX_VALUE;
        if(ans<Integer.MIN_VALUE) ans = Integer.MIN_VALUE;
                
        return (int)ans;
    }
}