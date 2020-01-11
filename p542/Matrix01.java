/*
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 

Note:

The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
 * 
 * */
package p542;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
	public int[][] updateMatrix(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] != 0) {
					matrix[i][j] = bfs(i, j, matrix, 0);
				}
			}
		}
		return matrix;

	}

	int bfs(int i, int j, int[][] matrix, int d) {

		Queue<String> q = new LinkedList<>();
		q.add("" + i + " " + j);
		while (!q.isEmpty()) {
			int s = q.size();
			for (int k = 0; k < s; k++) {
				String str = q.poll();
				String[] s1 = str.split(" ");
				int a = Integer.parseInt(s1[0]);
				int b = Integer.parseInt(s1[1]);
				if (a >= 0 && a < matrix.length && b >= 0 && b < matrix[0].length) {
					if (matrix[a][b] == 0) {
						return d;
					} else {
						q.add("" + a + " " + (b + 1));
						q.add("" + a + " " + (b - 1));
						q.add("" + (a + 1) + " " + b);
						q.add("" + (a - 1) + " " + b);
					}
				} else
					continue;
			}
			d++;
		}
		return -1;

	}

}
