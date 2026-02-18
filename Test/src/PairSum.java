import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class PairSum {
	public static void main(String[] args) {
		try{
			
			int numbers[] = readNumsFromCommandLine();
			System.out.println(Arrays.toString(numbers));
			System.out.println("Please Enter Sum Value ");
			try (Scanner s = new Scanner(System.in)) {
				int sum = s.nextInt();
				s.nextLine();
				
				boolean flag = checkSetExistOrNot(numbers, sum);
				System.out.println(flag);
			}
		
		}catch(Exception e){
			System.err.println("Exception in getting Values" + e.getMessage() ); 
		}
		
	}

	static boolean checkSetExistOrNot(int arr[], int sum) {
		boolean result = false;
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];
			if (s.contains(temp)) {
				result = true;
				break;
			}
			s.add(arr[i]);
		}
		return result;
	}

	public static int[] readNumsFromCommandLine() {
		System.out.println("Please enter array size");
		Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        s.nextLine(); //
        
        System.out.println("Enter values array ");
		int[] numbers = new int[count];
		Scanner numScanner = new Scanner(s.nextLine());
		for (int i = 0; i < count; i++) {
			if (numScanner.hasNextInt()) {
				numbers[i] = numScanner.nextInt();
			} else {
				System.out.println("You didn't provide enough numbers");
				break;
			}
		}
		return numbers;
	}
}
