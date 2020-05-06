/*171. Excel Sheet Column Number
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701*/

class Solution {
    public int titleToNumber(String s) {
        int res = s.charAt(0)-64;
        for(int i = 1;i<s.length();i++){
            res = (res*26)+s.charAt(i)-64;
        }
        return res;
    }
}