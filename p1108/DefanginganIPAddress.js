/**
 * @param {string} address
 * @return {string}
 */
var defangIPaddr = function(address) {
    var str = "";
    var data = address.split(".");
    // console.log(data);
    data.map(el=>{
        str+=el+'[.]';
    })
    return str.substring(0,str.length-3);
//     for(var i=0;i<address.length;i++){
//         if(address.charAt(i)=='.'){
//             str +="["+address.charAt(i)+"]"; 
//         }else
//             str+=address.charAt(i);
//     }
    
//     return str;
};