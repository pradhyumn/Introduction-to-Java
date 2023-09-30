package PartI;

public class BalancedParentheses {

	public static boolean isBalanced(String inString) {
		MyStack<String> st = new MyStack<>();
		for(int i=0; i<inString.length(); i++) {
			String l = String.valueOf(inString.charAt(i));
			if(l.equals("(")) {
				st.push(l);
			} else {
				if(st.empty()) return false;
				st.pop();
			}
		}
		if(st.empty()) return true;
		return false;
	}
	
	public static void main(String[] args) {
		boolean result = isBalanced("(()()()())");
		System.out.println(result);
		result = isBalanced("(((())))");
		System.out.println(result);
		result = isBalanced("((((((())");
		System.out.println(result);
		result = isBalanced("((()))))))))");
		System.out.println(result);
	}
}
