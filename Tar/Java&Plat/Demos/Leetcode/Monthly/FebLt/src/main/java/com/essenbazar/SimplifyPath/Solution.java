/*
Project for solving some common algorithm problems
 */
package com.essenbazar.SimplifyPath;

/**
 *
 * @author himan
 */

/*

Given a string path, which is an absolute path (starting with a slash '/') to a file or directory
in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory,

a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//')
are treated as a single slash '/'.

For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.

Example 1:

Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.

Example 2:

Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the
highest level you can go.

Example 3:

Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.4

Example 4:

Input: path = "/a/./b/../../c/"
Output: "/c"

 */
import java.util.*;

class Solution {

    public String simplifyPath(String path) {
        Stack<String> st = new Stack<String>();
        String res = "";
        res += "/";
        int len = path.length();

        for (int i = 0; i < len; i++) {
            // we will clear the temporary String every time to accomodate new directory name or command
            String dir = "";
            while (i < len && path.charAt(i) != '/') {
                dir += path.charAt(i);
                i++;
            }

            if (dir.equals("..") == true) {
                if (!st.empty()) {
                    st.pop();
                }
            } else if (dir.equals(".") == true) {
            } else if (dir.length() != 0) {
                st.push(dir);
            }
        }

        // we need a temporary stack that will contain the reverse of the original stack
        Stack<String> st_ = new Stack<>();
        while (!st.empty()) {
            st_.push(st.pop());
        }

        while (!st_.empty()) {
            if (st_.size() != 1) {
                res += st_.pop() + "/";
            } else {
                res += st_.pop();
            }
        }

        return res;
    }
    
    /*
    
    Main Task:
    
        Pushing and Popping directory names based on the rules that are given
    
        Rule 1:
    
            / ..
    
                whenever we encounter a double dot we 'pop' or come out of that directory
                
                whenever we get a name we 'push' or we go into that directory
    
        -------
        
        Initially we'll be at the home directory
        We can split the String with '/'
        Suppose the resultant String is:
            a . b .. .. c
    
            Initially I see a directory name (a)
                Therefore I will push it in my stack or queue
            
            Whenever I see a single dot, that means I will stay in that directory
            
            Next I encounter another directory name (b)
                Therefore I will push it in my stack or queue
            
            Next I encounter double dot, therefore I will remove
                top of the stack
                    or
                end of the queue
            
            Next I encounter another double dot, therefore I will remove
                top of the stack
                    or
                end of the queue
    
            Next I encounter a directory name, so I will push it into
                stack or queue
    
        Finally I want to return the path
            In the doubly ended queue
                we can just start from the front and keep adding the slash with the directory name
    
            In the stack
                I have to go the reverse order
                    as when I pop from the stack, the highest one will get pop
                        but we require the lowest one
    
        -------
    
    Time: O(n)
    Space: O(n)
    
    */
    
    public String simplifyPath_usingStack(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder res =  new StringBuilder();
        
        // initially I need to split my path into just the directory names
        String [] p = path.split("/");
        
        for (String p1 : p) {
            // here we'll have two conditions (push and pop)
            // whenever stack is not empty and I'll have two dots, I will pop
            if (!s.isEmpty() && p1.equals("..")) {
                s.pop();
            } else if (!p1.equals("") && !p1.equals(".") && !p1.equals("..")) {
                s.push(p1);
            }
        }
        
        // at this point the stack has only the elements that appear in the simplified canonical
            // form
        if (s.isEmpty()) return "/";
        
        while (!s.isEmpty()) {
            // appending in the front in the string builder as stack pop the last element
            res.insert(0, s.pop()).insert(0, "/");
        }
        
        return res.toString();  
    }
    
    public String simplifyPath_usingDeque(String path) {
        Deque<String> s = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        String[] p = path.split("/");
        for (String p1 : p) {
            if (!s.isEmpty() && p1.equals("..")) {
                s.poll();
            } else if (!p1.equals("") && !p1.equals(".") && !p1.equals("..")) {
                s.push(p1);
            }
        }
        
        if (s.isEmpty()) return "/";
        while (!s.isEmpty()) {
            // here initially we will append the slash, then first element from the queue, then slash and so on
            res.append("/").append(s.pollLast());
        }
        
        return res.toString();
    }
}
