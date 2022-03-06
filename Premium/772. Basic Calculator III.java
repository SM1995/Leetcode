class Solution {
    public int calculate(String s) {
        
        int n = s.length(), digit = 0, out = 0;
        Stack<Integer> stack = new Stack<>();
        char operation = '+';
        
        for(int i=0;i<=n;i++){
            char curr = i<n ? s.charAt(i) : '+';
            
            if(Character.isDigit(curr)){
                    digit = digit * 10 + (s.charAt(i)-'0');
            }
            
            else if(curr=='('){
                int open = 1;
                int start = i;
                while(i+1<s.length() && open!=0){
                    ++i;
                    if(s.charAt(i)=='(') open++;
                    else if(s.charAt(i)==')') open--;
                }
                digit = calculate(s.substring(start+1,i));
            }
                           
            else if(curr == ')'){
                break;      
            }
            
            else{       
                if(operation=='+'){
                    System.out.println('+');
                    stack.push(digit);
                }
                
                else if(operation=='-'){
                    System.out.println('-');
                    stack.push(-digit);
                }
                
                else if(operation == '*'){
                    System.out.println('*');
                    int temp = stack.pop()*digit;
                    System.out.println(digit);
                    stack.push(temp);
                }
                
                else if(operation == '/'){
                    stack.push(stack.pop()/digit);
                }
                
                operation = curr;
                digit = 0;
            }
            System.out.println(stack);              
        }
        
        stack.push(digit);        
        
        while(!stack.isEmpty()){
            out+= stack.pop();
        }
        
        return out;
    }
}
