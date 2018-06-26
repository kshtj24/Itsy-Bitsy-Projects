import java.util.*;

class MergeArrays{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String[] arr1 = scanner.nextLine().split(" ");
		String[] arr2 = scanner.nextLine().split(" ");
		
		String[] resultArr = new String[arr1.length + arr2.length];
		for(int i = 0; i < arr1.length - 1; i++){
			resultArr[2 * i] = arr1[i];
		}
		
		//printArr(resultArr);
		
		for(int j = 0; j < arr2.length - 1; j++){
			resultArr[(2 * j) + 1] = arr2[j];
		}
		
		printArr(resultArr);
	}
	
	static void printArr(String[] resultArr){
		for(int k = 0; k < resultArr.length; k++){
			System.out.print(resultArr[k] + " ");
		}
	}
}