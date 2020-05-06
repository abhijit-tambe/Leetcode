/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if(s.length!==t.length) return false;
    var hash = {};
    for(let c of s){
        if(hash[c]){
            hash[c]++;
        }else{
            hash[c]=1;
        }
    }
    for(let c of t){
        if(!hash[c]){
            return false;
        }else if(hash[c]<1){
            return false;
        }else {
            hash[c]-=1;
        }
    }
        return true;
}