class Solution {
    public boolean isAlienSorted(String[] words, String order) {
         for(int i=0;i<words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int j;
            for( j=0;j<Math.min(s1.length(),s2.length());j++){
                int c1=0;
                int c2=0;
                for(int k=0;k<order.length();k++){
                    if(s1.charAt(j)==order.charAt(k)) c1=k;
                    if(s2.charAt(j)==order.charAt(k)) c2 = k;
                }
                if(c2<c1) return false;
                if(c1<c2) break;
            }
            if(j==Math.min(s1.length(),s2.length())&&s1.length()>s2.length()) return false;
        }
        return true;
    }
}