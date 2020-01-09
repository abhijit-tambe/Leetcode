/*739. Daily Temperatures
 *Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100]. 
 * 
 * */
package p739;

import java.util.Stack;

public class DailyTemperature {
	public int[] dailyTemperatures(int[] T) {
		// slow solution O(nw) w is numbers of further values till condition is met
        // int [] ans = new int[T.length];
        // boolean found =false;
        // for(int i=0;i<T.length;i++){
        //     int c =1;
        //         found =false;
        //     for(int j=i+1;j<T.length;j++){
        //         if(T[j]>T[i]){
        //             ans[i] =c;
        //             found =true;
        //             break;
        //         }
        //         c++;
        //     }
        //     if(!found){
        //         ans[i]=0;
        //     }
        // }
        // return ans;
		
		// faster using stack O(n) 
         int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
