class Solution {
    public String simplifyPath(String path) {
        String[] string = path.split("/");
        Deque<String> stack = new LinkedList<>();
        
        for(String s: string){
            if(s.equals("..")){
                if(!stack.isEmpty()) stack.removeLast();
            }
            else if(s.equals(".")) continue;
            else if(!s.isEmpty()){
                stack.add(s);
                System.out.println(s);  
            } 
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append("/" + stack.pollFirst());
        }
        
        if(sb.length()==0) sb.append("/");
        
        return sb.toString();
    }
}
