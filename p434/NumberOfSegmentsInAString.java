/*
 * 434. Number of Segments in a String
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5*/
package p434;

public class NumberOfSegmentsInAString {
	public int countSegments(String s) {
		String arr[] = s.split(" ");
		int count = 0;
		for (String s1 : arr) {
			if (s1.length() > 0)
				count++;
		}
		return count;
	}
}
