// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(String s, int k) {
        // write your code in Java SE 8
        StringBuilder sb = new StringBuilder();
        s = s.replace("-", "");
        int len = s.length();
        int rem = len % k;
        if(rem == 0){
        	for(int i = 0; i < len; i+ = k){
        		sb.append(s.substring(i, k));
				if(i + k != s.length()){
					sb.append("-");
				}
        	}
        } else{
        	sb.append(s.substring(0, rem -1)).append("-");
        	for(int i = rem - 1; i < len; i += k){
        		if( i + k < len){
        			sb.append(s.substring(i, 	k));
        		} else{
        			sb.append(s.substring(i, len - 1);
        		}
        		
				if(i + k != s.length()){
					sb.append("-");
				}
        	}
        }
        return sb.toString().toUpperCase();
    }
}