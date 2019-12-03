/*
 * 451. Sort Characters By Frequency
Medium

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.*/


package p451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        ArrayList<Character> list =new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c,0)+1);
            list.add(c);
        }
        
        PriorityQueue<Character> heap = new PriorityQueue<>((a,b)->{
            return freq.get(b)-freq.get(a);
        });
        heap.addAll(freq.keySet());
 
        StringBuilder sb = new StringBuilder();
        while(!heap.isEmpty()){
            char x = heap.remove();
 
            int c = freq.get(x);
            while(c!=0)
            {
                sb.append(x);c--;}
        }
        
       
        return sb.toString();
 
    }
}