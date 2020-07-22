441. Arranging Coins
ou have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.

/**
 * @param {number} n
 * @return {number}
 */
var arrangeCoins = function(n) {
  
    var l =0, r=n, mid,curr;
    while(l<=r){
         mid = Math.floor(l+(r-l)/2);
         curr = mid*(mid+1)/2;
        if(curr ===n){
            return mid;
        }
        else if(n<curr){
            r = mid-1;
        }else{
            l=mid+1;
        }
    }
return r;
    
};