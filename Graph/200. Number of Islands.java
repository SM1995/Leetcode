class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int r, int c){
        
        if(r<0 || c<0 || r==grid.length || c==grid[0].length || grid[r][c]=='0')
            return;
        
        grid[r][c]='0';
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }
}

/*
//Approach 2:
class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid==null || grid.length==0) return 0;
        
        int count = 0;
        int r = grid.length;
        int c = grid[0].length;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0;j<grid[0].length;j++){
                Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                if(grid[i][j]=='1'){
                    count++;
                    grid[i][j]='0';
                    queue.add(new Pair<>(i,j));
                    
                    while(!queue.isEmpty()){
                        Pair<Integer, Integer> p = queue.remove();
                        
                        int row = p.getKey();
                        int col = p.getValue();
                        
                        if(row-1>=0 && grid[row-1][col]=='1'){
                            queue.add(new Pair<>(row-1,col));
                            grid[row-1][col]='0';
                        }
                        if(col-1>=0 && grid[row][col-1]=='1'){
                            queue.add(new Pair<>(row,col-1));
                            grid[row][col-1]='0';
                        }
                        if(row+1<r && grid[row+1][col]=='1'){
                            queue.add(new Pair<>(row+1,col));
                            grid[row+1][col]='0';
                        }
                        if(col+1<c && grid[row][col+1]=='1'){
                            queue.add(new Pair<>(row,col+1));
                            grid[row][col+1]='0';
                        }
                    }
                }
            }
        }
        
        return count;
        /*int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int r, int c){
        
        if(r<0 || c<0 || r==grid.length || c==grid[0].length || grid[r][c]=='0')
            return;
        
        grid[r][c]='0';
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);*/
    }
}
*/
