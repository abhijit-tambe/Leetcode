/*200. Number of Islands
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 * */

package p200;

public class NumberOfIsland {
	
	    public int numIslands(char[][] grid) {
	        if(grid.length<1){
	            return 0;
	        }
	        int count=0;
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[0].length;j++){
	                if(grid[i][j]=='1'){
	                    dfs(i,j,grid);
	                    count++;
	                }
	            }
	        }    
	        return count;
	    }
	    
	    void dfs(int cur_i,int cur_j,char [][] grid){
	        
	        if(cur_i<0||cur_i>grid.length-1||cur_j<0||cur_j>grid[0].length-1){
	            return;
	        }
	        else if(grid[cur_i][cur_j]=='0'){
	            return;
	        }
	        grid[cur_i][cur_j]='0';
	        dfs(cur_i-1,cur_j,grid);
	        dfs(cur_i,cur_j+1,grid);
	        dfs(cur_i+1,cur_j,grid);
	        dfs(cur_i,cur_j-1,grid);
	        
	    }
	    
	    
	    
}
