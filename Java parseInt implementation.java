import java.util.*;

class parseint{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		parseintMeth(input);
	}
	
	static void parseintMeth(String s){
		int result = 0;
		for(int i = 0; i < s.length(); i++){
			result *= 10;
			int temp = (int) s.charAt(i) - (int) '0';
			if(temp > 9 || temp < 0){
				throw new NumberFormatException();
			}else{
				result += temp;					
			}			
		}
		System.out.println(result);
	}
}