import java.util.*;

public class Palindrom{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		Stack<Character> stk = new Stack<Character>();
		
		System.out.println(check(s) ? "Palindrome" : "Not Palindrome");
	}
	
	static boolean check(String s){
		int i = 0;
		int j = s.length() - 1;
		
		while((i <= j)){
			if((s.charAt(i) ^ s.charAt(j)) != 0)
				return false;
			i++;
			j--;
		}
		
		return true;
	}
}