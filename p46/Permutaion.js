/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    var result = [];
    
   var main = function(nums,j){
        if(j==nums.length){
            result.push(nums.slice());
            return;
        }
        for(var i=j;i<nums.length;i++){
            swap(nums,i,j);
            main(nums,j+1);
            swap(nums,i,j);
        }
        
    };
    var swap = function(nums,i,j){
        
        let temp = nums[i];
        nums[i]= nums[j];
        nums[j]=temp;
        
    };

    main(nums,0);
    return result;
    
};
