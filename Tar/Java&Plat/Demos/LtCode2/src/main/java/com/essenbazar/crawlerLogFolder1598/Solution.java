
package com.essenbazar.crawlerLogFolder1598;

/*
 * The Leetcode file system keeps a log each time some user performs a change folder operation.

	The operations are described below:

    "../" : Move to the parent folder of the current folder. 
    	(If you are already in the main folder, remain in the same folder).
    "./" : Remain in the same folder.
    "x/" : Move to the child folder named x (This folder is guaranteed to always exist).

	You are given a list of strings logs where logs[i] is the operation performed by the user 
		at the ith step.

	The file system starts in the main folder, then the operations in logs are performed.
	
	Input: logs = ["d1/","d2/","../","d21/","./"]
	Output: 2
	Explanation: Use this change folder operation "../" 2 times and go back to the main folder.
 */

import java.util.Stack;

class Solution {

	public int minOperations(String[] logs) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < logs.length; ++i) {
			logs[i] = logs[i].replaceAll("/", "");
			switch (logs[i]) {
			case ".":
				break;
			case "..":
				try {
					if (!stack.empty()) {
						stack.pop();
					}
				} catch (Exception e) {
				}
				break;
			default:
				stack.push(logs[i]);
				break;
			}
		}

		return stack.size();
	}

	public static void main(String[] args) {
		Solution myObj = new Solution();
		String[] arr = new String[] { "d1/", "d2/", "../", "d21/", "./" };
		System.out.println(myObj.minOperations(arr));
	}
}
