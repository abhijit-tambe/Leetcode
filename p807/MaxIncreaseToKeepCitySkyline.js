/*807. Max Increase to Keep City Skyline
Medium

776

225

Add to List

Share
In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there. We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well. 

At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.

What is the maximum total sum that the height of the buildings can be increased?

Example:
Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
Output: 35
Explanation: 
The grid is:
[ [3, 0, 8, 4], 
  [2, 4, 5, 7],
  [9, 2, 6, 3],
  [0, 3, 1, 0] ]

The skyline viewed from top or bottom is: [9, 4, 8, 7]
The skyline viewed from left or right is: [8, 7, 9, 3]

The grid after increasing the height of buildings without affecting skylines is:

gridNew = [ [8, 4, 8, 7],
            [7, 4, 7, 7],
            [9, 4, 8, 7],
            [3, 3, 3, 3] ]

Notes:

1 < grid.length = grid[0].length <= 50.
All heights grid[i][j] are in the range [0, 100].
All buildings in grid[i][j] occupy the entire grid cell: that is, they are a 1 x 1 x grid[i][j] rectangular prism.*/



/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxIncreaseKeepingSkyline = function(grid) {
    var top=[];
    var left=[];

    
    for(var i=0;i<grid.length;i++){
        left.push(Math.max(...grid[i]));
            var temp = [];   
        for(var j=0;j<grid[i].length;j++){
            temp.push(grid[j][i]);
            }
        top.push(Math.max(...temp));
    }

    console.log(top);

     var sum =0;
      for(var i=0;i<grid.length;i++){
        for(var j=0;j<grid[i].length;j++)
            {
                sum+= Math.min(top[j],left[i]) - grid[i][j];              
            }
      }

    return sum;  
};


/*
lengthy one 
/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxIncreaseKeepingSkyline = function(grid) {
    var top=[];
    var left=[];
    var transpose = [];
    left = findmax(grid);
    
     for(var i=0;i<grid.length;i++)
         transpose.push([]);
    
    for(var i=0;i<grid.length;i++)
        for(var j=0;j<grid[i].length;j++)
            transpose [j][i] = grid[i][j];

    top = findmax(transpose);

     var sum =0;
      for(var i=0;i<grid.length;i++){
          var maxl = left[i];
        for(var j=0;j<grid[i].length;j++)
            {
                var maxt= top[j];
                   if(maxt<maxl){
                      sum+=(maxt-grid[i][j]); 
                       
                   }
                else{
                   sum+= (maxl-grid[i][j]);
                }
            }
      }

    return sum;  
};

 var findmax = function(grid){
     var output = [];
     grid.forEach(x=>{
        var inner = 0;
        x.forEach(y=>{
            if(y>inner){
                inner=y;
            }
        });
        output.push(inner);
    });
    return output;
    }
*/