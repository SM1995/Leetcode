class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] out = new int[n];
        
        Stack<String> stack = new Stack<>();
        
        for(String log: logs){
            int thread = Integer.parseInt(log.split(":")[0]);
            String isStart = log.split(":")[1];
            int time = Integer.parseInt(log.split(":")[2]);
            
            if(isStart.equals("start")){
                stack.push(log);
            }
            
            else{
                String last = stack.pop();
                out[Integer.parseInt(last.split(":")[0])] += (time - Integer.parseInt(last.split(":")[2])+1);
                if(!stack.isEmpty()){
                    String top = stack.peek();
                    out[Integer.parseInt(top.split(":")[0])] -= (time - Integer.parseInt(last.split(":")[2])+1);
                }
            }
        }
        
        return out;
    }
}
