class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentInt = 0;
        char operation = '+';
        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);
            if(Character.isDigit(current)){
                currentInt = currentInt*10 + (current-'0');
                System.out.println(currentInt);
            }
            if(!Character.isDigit(current) && !Character.isWhitespace(current) || i==s.length()-1){
                if(operation=='+'){
                    stack.push(currentInt);
                }
                else if(operation=='-'){
                    stack.push(-currentInt);
                }
                 else if (operation=='*'){
                     stack.push(stack.pop()*currentInt);
                }
                else if(operation=='/'){
                    stack.push(stack.pop()/currentInt);
                } 
                operation = current;
                currentInt = 0;
            }
        }
        int output=0;
        while(!stack.isEmpty()){
            int temp = stack.pop();
            System.out.println(temp);
            output+=temp;
        }
        return output;
    }
}
