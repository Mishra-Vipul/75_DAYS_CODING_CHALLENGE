class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('||ch=='{'||ch=='[') st.push(ch);
            else if(ch == ')'){
                boolean ans = check(st,'(');
                if(ans == false) return false;
            }
            else if(ch=='}'){
                boolean ans = check(st,'{');
                if(ans == false) return false;
            }
            else if(ch==']'){
                boolean ans = check(st,'[');                
                if(ans == false) return false;
            }
        }
        if(st.size()>0) return false;
        
        return true;
    }
    public boolean check(Stack<Character> st, char ch){
        if(st.size()==0) return false;
        if(st.peek()!=ch) return false;
        st.pop();
        return true;
    }
}