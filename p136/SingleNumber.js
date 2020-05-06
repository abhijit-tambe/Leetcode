/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    hash={};
    nums.forEach(x=>{
        if(hash[x]){
            hash[x]--;
        }else{
            hash[x]=1;
        }
    });
    for(let a in hash){
        if(hash[a]===1){
            return a;
        }
    }
    
};