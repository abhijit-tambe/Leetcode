/*20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 * 
 * */

package p20;

import java.util.Stack;

public class ValidParenthesis {
		    public boolean isValid(String s) {

		    	Stack<Character> sta = new Stack<>();
		    	for(int i=0;i<s.length();i++){
		    	    Character l = s.charAt(i);
		    	if(l=='('||l=='{'||l=='['){
		    	    if(i==s.length()-1){
		    	        return false;
		    	    }
		    	   sta.add(l); 
		    	}
		    	else if(sta.empty()){
		    	        return false;
		    	    }
		    	else{
		    	    Character r = sta.pop();
		    	    if((l==')'&&r!='(')||(l==']'&&r!='[')||(l=='}'&&r!='{')){
		    	     return false;   
		    	    }
		    	}
		    	}
		    	return sta.empty();


	    }
	
}



// this also works fine
//if(s.length()%2!=0){
//    return false;
//}
//        
//Stack<Character> sta = new Stack();
//
//for(int i=0;i<s.length();i++){
//    if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
//      if(i==s.length()-1){
//          return false;
//      }  
//    sta.add(s.charAt(i));
//    }
//    else{
//        if(sta.empty()){
//            return false;
//        }
//        Character cur = sta.pop();
//        if(s.charAt(i)==')'&&cur!='('){
//            return false;     
//        }
//        else if(s.charAt(i)=='}'&&cur!='{'){
//            return false;
//        }
//        else if(s.charAt(i)==']'&&cur!='['){
//            return false;
//        }
//    }
//}
//return true;

