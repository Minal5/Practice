class reverseStack
{ 
    static void reverse(Stack<Integer> s)
    {
        if(s.size() == 1)
            return ;
        int i = s.pop();
        reverse(s);
        helper(i,s);
        return;
    }
    static void helper(int i,Stack<Integer> s){
        if(s.isEmpty()){
            s.push(i);
            return;
        }
        int j = s.pop();
        helper(i,s);
        s.push(j);
        return;
    }
    
}
